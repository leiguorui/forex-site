package cn.injava.forex.web.service.technical;

import cn.injava.forex.core.constant.SystemConstant;
import cn.injava.forex.core.utils.HtmlUnit;
import cn.injava.forex.web.model.technical.TradingSignal;
import com.gargoylesoftware.htmlunit.HttpMethod;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.WebRequest;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * zulutrade.com 交易信号
 *
 * Created by leiguorui on 2017/10/20.
 */
@Service
public class SignalHitraderService {

    @Resource
    private TradingSignalService signalService;
    @Resource
    private TechnicalnvestingService technicalnvestingService;

    @Resource(name = "getSystemConfig")
    private Map<String, String> systemConfig;

    private WebRequest requestSettings;

    public List<TradingSignal> getSignals() throws MalformedURLException {

        final WebClient webClient = new HtmlUnit().getGeneralWebClient();
        List<TradingSignal> signals = new ArrayList<>();

        try {
            final String response = webClient.getPage(requestSettings).getWebResponse().getContentAsString();
            JsonObject jsonObject = new Gson().fromJson(response, JsonObject.class);

            //获取技术分析结果
            Map<String, String> technicals = technicalnvestingService.getTechnicals();


            for (JsonElement trade : jsonObject.getAsJsonObject("data").getAsJsonArray("info")){
                TradingSignal tradingSignal = new TradingSignal();

                JsonObject tradeJO = trade.getAsJsonObject();
                long time = jsonObject.getAsJsonObject("data").get("time").getAsLong() - tradeJO.get("submit_time").getAsLong() ;
                String currency = tradeJO.get("name").getAsString();
                tradingSignal.setCurrency(currency.substring(0, 3) + "_" + currency.substring(3, currency.length()));

                if (TimeUnit.SECONDS.toMinutes(time) <= Integer.parseInt(systemConfig.get("open.trade.time"))
                        && SystemConstant.MAJOR_CURRENCES.contains(tradingSignal.getCurrency()) ){

                    tradingSignal.setPlatform(SystemConstant.BROKER_HITRADER);
                    tradingSignal.setPrice(tradeJO.get("buying_price").getAsBigDecimal());
                    tradingSignal.setUserName(tradeJO.get("uname").getAsString());
                    tradingSignal.setType(tradeJO.get("trade_type").getAsInt() == 1 ? SystemConstant.TRADE_TYPE_SELL : SystemConstant.TRADE_TYPE_BUY);

                    String technical = technicals.get(tradingSignal.getCurrency());
                    //信号符合技术分析
                    if (technical != null && technical.equals(tradingSignal.getType())){
                        tradingSignal.setProfitPrice(new BigDecimal(1));
                    }

                    if (signalService.insert(tradingSignal)){
                        signals.add(tradingSignal);
                    }

                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            webClient.close();
        }

        return signals;
    }

    public static void main(String[] args) throws MalformedURLException {
        SignalHitraderService service = new SignalHitraderService();
        service.getSignals();
        System.out.println(service.getSignals());
    }

    @PostConstruct
    public void init() throws Exception {
        URL url = new URL("http://www.hitrader.com/Data/dynamic?param=0");
        requestSettings = new WebRequest(url, HttpMethod.GET);
        requestSettings.setAdditionalHeader("X-Requested-With", "XMLHttpRequest");
    }
}
