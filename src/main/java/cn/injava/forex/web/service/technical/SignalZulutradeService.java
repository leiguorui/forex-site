package cn.injava.forex.web.service.technical;

import cn.injava.forex.core.constant.SystemConstant;
import cn.injava.forex.core.utils.HtmlUnit;
import cn.injava.forex.web.model.technical.Signal;
import cn.injava.forex.web.model.technical.TradingSignal;
import cn.injava.forex.web.service.system.SystemService;
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

/**
 * zulutrade.com 交易信号
 *
 * Created by leiguorui on 2017/10/20.
 */
@Service
public class SignalZulutradeService {

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


            for (JsonElement trade : jsonObject.getAsJsonArray("d")){
                TradingSignal tradingSignal = new TradingSignal();

                JsonObject tradeJO = trade.getAsJsonObject();
                String[] time = tradeJO.get("ta").getAsString().split(" ");
                tradingSignal.setCurrency(tradeJO.get("cun").getAsString().replace("/", "_"));

                if (Integer.parseInt(time[0]) <= Integer.parseInt(systemConfig.get("open.trade.time")) && SystemConstant.MAJOR_CURRENCES.contains(tradingSignal.getCurrency()) ){

                    tradingSignal.setCurrency(tradingSignal.getCurrency());
                    tradingSignal.setPlatform(SystemConstant.BROKER_ZULUTRADE);
                    tradingSignal.setPrice(tradeJO.get("pr").getAsBigDecimal());
                    tradingSignal.setUserName(tradeJO.get("pn").getAsString());
                    tradingSignal.setType(tradeJO.get("tc").getAsInt() == 1 ? SystemConstant.TRADE_TYPE_SELL : SystemConstant.TRADE_TYPE_BUY);

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
        SignalZulutradeService service = new SignalZulutradeService();
        service.getSignals();
    }

    @PostConstruct
    public void init() throws Exception {
        URL url = new URL("https://www.zulutrade.com/webservices/tradewall.asmx/gettradewallevents?_tsmp="+System.currentTimeMillis());
        requestSettings = new WebRequest(url, HttpMethod.POST);
        requestSettings.setAdditionalHeader("Content-Type", "application/json; charset=UTF-8");
        requestSettings.setRequestBody("{\"platform\":\"forex\",\"minutesAgo\":288000000,\"pageIndex\":1,\"pageSize\":20,\"providerName\":\"\",\"displayStatusMessages\":false,\"displayOpenTrades\":true,\"displayClosedTrades\":false,\"displayHavingLiveFollowers\":true,\"onlyFollowedByMe\":false}");
    }
}
