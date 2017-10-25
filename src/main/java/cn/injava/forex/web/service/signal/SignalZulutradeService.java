package cn.injava.forex.web.service.signal;

import cn.injava.forex.core.constant.SystemConstant;
import cn.injava.forex.core.utils.HtmlUnit;
import cn.injava.forex.web.model.technical.Signal;
import com.gargoylesoftware.htmlunit.HttpMethod;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.WebRequest;
import com.gargoylesoftware.htmlunit.xml.XmlPage;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * zulutrade.com 交易信号
 *
 * Created by leiguorui on 2017/10/20.
 */
@Service
public class SignalZulutradeService {

    private WebRequest requestSettings;

    public List<Signal> getSignals() throws MalformedURLException {

        final WebClient webClient = new HtmlUnit().getGeneralWebClient();
        List<Signal> signals = new ArrayList<>();

        try {
            final String response = webClient.getPage(requestSettings).getWebResponse().getContentAsString();

            JsonObject jsonObject = new Gson().fromJson(response, JsonObject.class);

            for (JsonElement trade : jsonObject.getAsJsonArray("d")){
                Signal signal = new Signal();

                JsonObject tradeJO = trade.getAsJsonObject();
                String[] time = tradeJO.get("ta").getAsString().split(" ");
                signal.setCurrency(tradeJO.get("cun").getAsString().replace("/", "_"));

                if (Integer.parseInt(time[0]) <= 3 && SystemConstant.MAJOR_CURRENCES.contains(signal.getCurrency()) ){

                    signal.setPrice(tradeJO.get("pr").getAsDouble());

                    if (tradeJO.get("tc").getAsInt() == 1){
                        signal.setSignal(Signal.SIGNAL_SELL);
                    }else {
                        signal.setSignal(Signal.SIGNAL_BUY);
                    }

                    signals.add(signal);
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
