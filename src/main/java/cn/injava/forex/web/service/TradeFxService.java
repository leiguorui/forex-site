package cn.injava.forex.web.service;

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
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    /**
     * 开仓
     * @param currency
     * @return
     */
    public int openTrade(String currency, int units){
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

        return JsonObject.get("lastTransactionID").getAsInt();
    }

    /**
     * 平仓
     * @param currency
     * @param units
     * @return
     */
    public int closeTrade(int tradeId){
        String url = baseUrl + "/trades/"+tradeId+"/close";

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.PUT, new HttpEntity(httpHeaders), String.class);
        JsonObject JsonObject = new Gson().fromJson(response.getBody(), JsonObject.class);

        return JsonObject.get("lastTransactionID").getAsInt();
    }

    /**
     * 获取所有持仓
     * @param instrument
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

    @PostConstruct
    public void init() {
        httpHeaders = new HttpHeaders();
        httpHeaders.set("Content-Type", "application/json");
        httpHeaders.set("Authorization", "Bearer 28440b5543bf5d47ef7b46777f298eec-5e87822fca64fbbac583c45dbce086d2");
        httpHeaders.set("Accept-Datetime-Format", "RFC3339");
    }
}
