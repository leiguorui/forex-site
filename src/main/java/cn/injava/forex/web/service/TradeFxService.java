package cn.injava.forex.web.service;

import cn.injava.forex.core.constant.SystemConstant;
import cn.injava.forex.web.model.order.TradingOrder;
import cn.injava.forex.web.model.order.Trade;
import cn.injava.forex.web.service.order.OrderService;
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

    /**
     * 开仓
     * @param currency
     * @return
     */
    public TradingOrder openTrade(String currency, int units){
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

        TradingOrder order = new TradingOrder();
        order.setCurrency(currency);
        order.setLots((new BigDecimal(units).divide(new BigDecimal(100000))).floatValue());
        order.setTradingId(JsonObject.get("lastTransactionID").getAsString());
        order.setType(units > 0 ? SystemConstant.TRADE_TYPE_BUY : SystemConstant.TRADE_TYPE_SELL);
        order.setTradingPlatform(SystemConstant.BROKER_OANDA);
        order.setOpenPrice(JsonObject.get("orderFillTransaction").getAsJsonObject().get("price").getAsBigDecimal());
        order.setOpenTime(new Date());

        orderService.insert(order);

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
        order.setProfitPips(JsonObject.get("pl").getAsJsonObject().get("price").getAsFloat());
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
