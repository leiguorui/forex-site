package test.service;

import cn.injava.forex.web.model.technical.Candle;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.ta4j.core.*;
import org.ta4j.core.indicators.candles.DojiIndicator;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * 技术分析测试
 *
 * Created by leiguorui on 2017/12/15.
 */
public class TestTa4j {
    public static void main(String[] args) {
        String url = "https://api-fxtrade.oanda.com/v3/instruments/EUR_USD/candles?count=100&price=M&granularity=M15";

        HttpHeaders httpHeadersCandle = new HttpHeaders();
        httpHeadersCandle.set("Content-Type", "application/json");
        httpHeadersCandle.set("Authorization", "Bearer 3ec65c13a6c4681bd2033c853eaef61e-ddeb0c35a9c3841c4358355cc5bb8418");
        httpHeadersCandle.set("Accept-Datetime-Format", "RFC3339");
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, new HttpEntity(httpHeadersCandle), String.class);
        JsonObject tradeJson = new Gson().fromJson(response.getBody(), JsonObject.class).getAsJsonArray("candles").get(0).getAsJsonObject();

        Candle candle = new Candle();
        candle.setH(tradeJson.getAsJsonObject("mid").get("h").getAsBigDecimal());
        candle.setL(tradeJson.getAsJsonObject("mid").get("l").getAsBigDecimal());

        List<Tick> ticks = new ArrayList<>();

        for (JsonElement candleEle : new Gson().fromJson(response.getBody(), JsonObject.class).getAsJsonArray("candles")){

            double open = candleEle.getAsJsonObject().getAsJsonObject("mid").get("o").getAsDouble();
            double high = candleEle.getAsJsonObject().getAsJsonObject("mid").get("h").getAsDouble();
            double low = candleEle.getAsJsonObject().getAsJsonObject("mid").get("l").getAsDouble();
            double close = candleEle.getAsJsonObject().getAsJsonObject("mid").get("c").getAsDouble();
            double volume = candleEle.getAsJsonObject().get("volume").getAsDouble();
            String dateTime = candleEle.getAsJsonObject().get("time").getAsString().replace(".000000000Z", "");

            ZonedDateTime date =  LocalDateTime.parse(dateTime, DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss")).atZone(ZoneId.of("Z").normalized());

            ticks.add(new BaseTick(date, open, high, low, close, volume));
        }

        TimeSeries timeSeries = new BaseTimeSeries("apple_ticks", ticks);

        DojiIndicator dojiIndicator = new DojiIndicator(timeSeries, 100, Decimal.valueOf("0.1"));


        for (int n = 0 ; n < 100 ;  n++){
            if (dojiIndicator.getValue(n)){
                System.out.println(n + "--" + timeSeries.getTick(n));
            }

        }

    }
}
