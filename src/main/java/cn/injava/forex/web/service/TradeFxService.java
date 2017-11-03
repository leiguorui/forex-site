package cn.injava.forex.web.service;

import cn.injava.forex.core.constant.SystemConstant;
import cn.injava.forex.web.model.order.TradingOrder;
import cn.injava.forex.web.model.order.Trade;
import cn.injava.forex.web.model.order.TradingPrice;
import cn.injava.forex.web.model.technical.Signal;
import cn.injava.forex.web.model.technical.TradingSignal;
import cn.injava.forex.web.service.order.OrderService;
import cn.injava.forex.web.service.technical.TradingSignalService;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
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
        order.setClosePrice(JsonObject.get("orderFillTransaction").getAsJsonObject().get("price").getAsBigDecimal());

        order.setProfitPips((order.getClosePrice().subtract(order.getOpenPrice()).floatValue()) * 10000 * (order.getType().equals(SystemConstant.TRADE_TYPE_SELL) ? -1 : 1) );
        //如果是含有日元, 获利点数为价格乘100
        if (order.getCurrency().contains("JPY")){
            order.setProfitPips((order.getClosePrice().subtract(order.getOpenPrice()).floatValue()) * 100 * (order.getType().equals(SystemConstant.TRADE_TYPE_SELL) ? -1 : 1) );
        }

        order.setCloseTime(new Date());

        orderService.update(order);

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

    @PostConstruct
    public void init() {
        httpHeaders = new HttpHeaders();
        httpHeaders.set("Content-Type", "application/json");
        httpHeaders.set("Authorization", "Bearer 28440b5543bf5d47ef7b46777f298eec-5e87822fca64fbbac583c45dbce086d2");
        httpHeaders.set("Accept-Datetime-Format", "RFC3339");
    }
}
