package cn.injava.forex.web.service;

import cn.injava.forex.core.constant.SystemConstant;
import cn.injava.forex.web.model.Product;
import cn.injava.forex.web.model.order.TradingOrder;
import cn.injava.forex.web.model.order.Trade;
import cn.injava.forex.web.model.order.TradingPrice;
import cn.injava.forex.web.model.technical.Candle;
import cn.injava.forex.web.model.technical.Signal;
import cn.injava.forex.web.model.technical.TradingSignal;
import cn.injava.forex.web.service.order.OrderService;
import cn.injava.forex.web.service.technical.TradingSignalService;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.joda.time.DateTime;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.*;

/**
 * oanda.com 交易
 *
 * Created by leiguorui on 2017/10/20.
 */
@Service
public class TradeFxService {

    private String baseUrl = "https://api-fxpractice.oanda.com/v3/accounts/101-011-6965723-002";
    private RestTemplate restTemplate = new RestTemplate();
    private HttpHeaders httpHeaders;

    @Resource
    private OrderService orderService;
    @Resource
    private TradingSignalService signalService;

    @Resource(name = "getSystemConfig")
    private Map<String, String> systemConfig;

    /**
     * 开仓
     * @param currency
     * @return
     */
    public TradingOrder openTrade(TradingSignal signal){

        String currency = signal.getCurrency();
        int units = SystemConstant.TRADE_TYPE_BUY.equals(signal.getType()) ? 1000 : -1000;

        String url = baseUrl + "/orders";
        String param = "{\n" +
                "  \"order\": {\n" +
                "    \"units\": \""+units+"\", \n" +
                "    \"instrument\": \""+currency+"\", \n" +
                "    \"timeInForce\": \"FOK\", \n" +
                "    \"type\": \"MARKET\", \n" +
                "    \"positionFill\": \"DEFAULT\"\n" +
                "  }\n" +
                "}";

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, new HttpEntity(param, httpHeaders), String.class);
        JsonObject JsonObject = new Gson().fromJson(response.getBody(), JsonObject.class);

        //新增订单
        TradingOrder order = new TradingOrder();
        order.setCurrency(currency);
        order.setLots((new BigDecimal(units).divide(new BigDecimal(100000))).floatValue());
        order.setTradingId(JsonObject.get("lastTransactionID").getAsString());
        order.setType(units > 0 ? SystemConstant.TRADE_TYPE_BUY : SystemConstant.TRADE_TYPE_SELL);
        order.setTradingPlatform(SystemConstant.BROKER_OANDA);
        order.setOpenPrice(JsonObject.get("orderFillTransaction").getAsJsonObject().get("price").getAsBigDecimal());
        order.setClosePrice(new BigDecimal(systemConfig.get("trade.max.loss")));
        order.setOpenTime(new Date());
        int orderId = orderService.insert(order);

        //写入订单id
        signal.setOrderId(orderId);
        signalService.update(signal);

        return order;
    }

    /**
     * 平仓
     * @return
     */
    public TradingOrder closeTrade(int tradeId){
        String url = baseUrl + "/trades/"+tradeId+"/close";

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.PUT, new HttpEntity(httpHeaders), String.class);
        JsonObject JsonObject = new Gson().fromJson(response.getBody(), JsonObject.class);

        TradingOrder order = orderService.selectOrderByRradeId(tradeId+"");
        BigDecimal closePrice = JsonObject.get("orderFillTransaction").getAsJsonObject().get("price").getAsBigDecimal();

        order.setProfitPips((closePrice.subtract(order.getOpenPrice()).floatValue()) * 10000 * (order.getType().equals(SystemConstant.TRADE_TYPE_SELL) ? -1 : 1) );
        //如果是含有日元, 获利点数为价格乘100
        if (order.getCurrency().contains("JPY")){
            order.setProfitPips(order.getProfitPips() / 100);
        }

        orderService.close(order);

        return order;
    }

    /**
     * 获取所有持仓
     * @return
     */
    public JsonObject getOpenedTrades(){
        String url = baseUrl + "/openTrades";
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, new HttpEntity(httpHeaders), String.class);
        JsonObject JsonObject = new Gson().fromJson(response.getBody(), JsonObject.class);

        return JsonObject;
    }

    /**
     * 是否有持仓
     * @return
     */
    public boolean hasTrading(String currency){
        String url = baseUrl + "/openTrades";
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, new HttpEntity(httpHeaders), String.class);
        JsonObject trades = new Gson().fromJson(response.getBody(), JsonObject.class);

        boolean result = false;
        for (JsonElement trade : trades.getAsJsonArray("trades")){
            JsonObject tradeJO = trade.getAsJsonObject();
            String instrument = tradeJO.get("instrument").getAsString();
            if (currency.equals(instrument)){
                result = true;
            }
        }

        return result;
    }

    /**
     * 返回盈利的持仓id
     * @return
     */
    public List<Integer> getProfitableOpenedTrades(BigDecimal profit){
        String url = baseUrl + "/openTrades";
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, new HttpEntity(httpHeaders), String.class);
        JsonObject trades = new Gson().fromJson(response.getBody(), JsonObject.class);

        List<Integer> tradesIds = new ArrayList<>();
        for (JsonElement trade : trades.getAsJsonArray("trades")){
            JsonObject tradeJO = trade.getAsJsonObject();
            BigDecimal unrealizedPL = tradeJO.get("unrealizedPL").getAsBigDecimal();
            if (unrealizedPL.subtract(profit).doubleValue() > 0){
                tradesIds.add(tradeJO.get("id").getAsInt());
            }
        }

        return tradesIds;
    }

    /**
     * 获取亏损的持仓id
     * @param profit
     * @return
     */
    public List<Integer> getLossOpenedTrades(BigDecimal profit){
        String url = baseUrl + "/openTrades";
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, new HttpEntity(httpHeaders), String.class);
        JsonObject trades = new Gson().fromJson(response.getBody(), JsonObject.class);

        List<Integer> tradesIds = new ArrayList<>();
        for (JsonElement trade : trades.getAsJsonArray("trades")){
            JsonObject tradeJO = trade.getAsJsonObject();
            BigDecimal unrealizedPL = tradeJO.get("unrealizedPL").getAsBigDecimal();
            if (unrealizedPL.subtract(profit.multiply(new BigDecimal(-1))).doubleValue() < 0){
                tradesIds.add(tradeJO.get("id").getAsInt());
            }
        }

        return tradesIds;
    }

    /**
     * 盈利和亏损订单
     * @param profit
     * @param loss
     * @return
     */
    public Map<String, List<Integer>> getLossOrProfitTrades(BigDecimal profit, BigDecimal loss){
        String url = baseUrl + "/openTrades";
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, new HttpEntity(httpHeaders), String.class);
        JsonObject trades = new Gson().fromJson(response.getBody(), JsonObject.class);

        List<Integer> lossIds = new ArrayList<>();
        List<Integer> profitIds = new ArrayList<>();
        for (JsonElement trade : trades.getAsJsonArray("trades")){
            JsonObject tradeJO = trade.getAsJsonObject();
            BigDecimal unrealizedPL = tradeJO.get("unrealizedPL").getAsBigDecimal();

            if (unrealizedPL.subtract(loss).doubleValue() < 0){
                lossIds.add(tradeJO.get("id").getAsInt());
            }

            if (unrealizedPL.subtract(profit).doubleValue() > 0){
                profitIds.add(tradeJO.get("id").getAsInt());
            }

            //设置订单获利情况
            TradingPrice tradingPrice = new TradingPrice();
            tradingPrice.setCurrency(tradeJO.get("instrument").getAsString());
            tradingPrice.setOrderId(tradeJO.get("id").getAsInt());
            tradingPrice.setPlatform(SystemConstant.BROKER_OANDA);
            tradingPrice.setProfitPrice(tradeJO.get("unrealizedPL").getAsBigDecimal());
            orderService.addOrderPrice(tradingPrice);
        }

        Map<String, List<Integer>> result = new HashMap<>(2);
        result.put("profit", profitIds);
        result.put("loss", lossIds);

        return result;
    }

    /**
     * 获取达到止损点的订单
     * @param profit
     * @param loss
     * @return
     */
    public List<Integer> getStopLossTrades(){
        String url = baseUrl + "/openTrades";
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, new HttpEntity(httpHeaders), String.class);
        JsonObject trades = new Gson().fromJson(response.getBody(), JsonObject.class);

        List<Integer> stopLossIds = new ArrayList<>();
        for (JsonElement trade : trades.getAsJsonArray("trades")){
            JsonObject tradeJO = trade.getAsJsonObject();
            BigDecimal unrealizedPL = tradeJO.get("unrealizedPL").getAsBigDecimal();

            //设置订单获利情况
            TradingPrice tradingPrice = new TradingPrice();
            tradingPrice.setCurrency(tradeJO.get("instrument").getAsString());
            tradingPrice.setOrderId(tradeJO.get("id").getAsInt());
            tradingPrice.setPlatform(SystemConstant.BROKER_OANDA);
            tradingPrice.setProfitPrice(tradeJO.get("unrealizedPL").getAsBigDecimal());
            orderService.addOrderPrice(tradingPrice);

            TradingOrder tradingOrder = orderService.selectOrderByRradeId(tradingPrice.getOrderId() + "");

            //平仓出场
            if (unrealizedPL.compareTo(tradingOrder.getClosePrice()) < 0){
                stopLossIds.add(tradingPrice.getOrderId());
            }
            //刚开始盈利的订单, 设置获利最低是0
            if (tradingOrder.getClosePrice().compareTo(new BigDecimal(systemConfig.get("trade.max.loss"))) == 0 && unrealizedPL.compareTo(new BigDecimal(systemConfig.get("trade.min.profit.trigger"))) > 0){
                tradingOrder.setClosePrice(new BigDecimal(systemConfig.get("trade.min.profit")));
            }
            //已经盈利的订单, 设置获利最低上浮0.2
            if (tradingOrder.getClosePrice().compareTo(new BigDecimal(systemConfig.get("trade.max.loss"))) > 0 && unrealizedPL.subtract(tradingOrder.getClosePrice()).doubleValue() > Double.parseDouble(systemConfig.get("trade.move.trigger"))){
                tradingOrder.setClosePrice(tradingOrder.getClosePrice().add(new BigDecimal(systemConfig.get("trade.move.loss"))));
            }

            orderService.update(tradingOrder);

        }

        return stopLossIds;
    }

    /**
     * 根据id, 获取oanda的持仓头寸
     * @param id
     * @return
     */
    public Trade getTradeById(int id){
        String url = baseUrl + "/trades/"+id;
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, new HttpEntity(httpHeaders), String.class);
        JsonObject tradeJson = new Gson().fromJson(response.getBody(), JsonObject.class).get("trade").getAsJsonObject();

        Trade trade = new Trade();
        trade.setCurrency(tradeJson.get("instrument").getAsString());
        trade.setPl(tradeJson.get("unrealizedPL").getAsBigDecimal());
        trade.setPrice(tradeJson.get("price").getAsBigDecimal());
        trade.setUnits(tradeJson.get("currentUnits").getAsInt());

        return trade;
    }

    /**
     * 获取前一个蜡烛图, 并与之比较
     *
     *
     * @param currency
     * @return
     */
    public boolean isInThreshold(String currency, String signalType){
        String url = "https://api-fxtrade.oanda.com/v3/instruments/"+currency+"/candles?count=2&price=M&granularity=M15";

        HttpHeaders httpHeadersCandle = new HttpHeaders();
        httpHeadersCandle.set("Content-Type", "application/json");
        httpHeadersCandle.set("Authorization", "Bearer 3ec65c13a6c4681bd2033c853eaef61e-ddeb0c35a9c3841c4358355cc5bb8418");
        httpHeadersCandle.set("Accept-Datetime-Format", "RFC3339");

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, new HttpEntity(httpHeadersCandle), String.class);
        JsonObject tradeJson = new Gson().fromJson(response.getBody(), JsonObject.class).getAsJsonArray("candles").get(0).getAsJsonObject();

        Candle candle = new Candle();
        candle.setH(tradeJson.getAsJsonObject("mid").get("h").getAsBigDecimal());
        candle.setL(tradeJson.getAsJsonObject("mid").get("l").getAsBigDecimal());

        Product product = getCurrentCurrent(currency);

        boolean result = false;

        //如果信号是买入, bid在阈值内
        if (SystemConstant.TRADE_TYPE_BUY.equals(signalType) &&
                product.getAsk().subtract(candle.getL()).abs().compareTo(new BigDecimal(systemConfig.get("trade.open.threshold"))) < 0){
            result = true;
        }

        //如果信号是买出, ask在阈值内
        if (SystemConstant.TRADE_TYPE_SELL.equals(signalType) &&
                product.getBid().subtract(candle.getH()).abs().compareTo(new BigDecimal(systemConfig.get("trade.open.threshold"))) < 0){
            result = true;
        }

        //如果信号是买入, 开盘价低于关盘价
        if (SystemConstant.TRADE_TYPE_SELL.equals(signalType) &&
                candle.getO().compareTo(candle.getC()) < 0){
            result = true;
        }

        //如果信号是卖出, 开盘价低于关盘价
        if (SystemConstant.TRADE_TYPE_SELL.equals(signalType) &&
                candle.getO().compareTo(candle.getC()) > 0){
            result = true;
        }

        return result;
    }

    /**
     * 获取最新价格
     * @param currency
     * @return
     */
    public Product getCurrentCurrent(String currency){
        String url = baseUrl + "/pricing?instruments="+currency;
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, new HttpEntity(httpHeaders), String.class);
        JsonObject JsonObject = new Gson().fromJson(response.getBody(), JsonObject.class).getAsJsonArray("prices").get(0).getAsJsonObject();

        Product product = new Product();
        product.setProductName(currency);
        product.setDateTime(new DateTime());
        product.setBid(JsonObject.getAsJsonArray("bids").get(0).getAsJsonObject().get("price").getAsBigDecimal());
        product.setAsk(JsonObject.getAsJsonArray("asks").get(0).getAsJsonObject().get("price").getAsBigDecimal());

        return product;
    }

    @PostConstruct
    public void init() {
        httpHeaders = new HttpHeaders();
        httpHeaders.set("Content-Type", "application/json");
        httpHeaders.set("Authorization", "Bearer d450d41406adf71bcbc8dbc3f0113de6-dc0a88769448d432d0d8f607fc14f026");
        httpHeaders.set("Accept-Datetime-Format", "RFC3339");
    }
}
