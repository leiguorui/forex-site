package cn.injava.forex.web.service.technical;

import cn.injava.forex.core.constant.SystemConstant;
import cn.injava.forex.core.utils.HtmlUnit;
import cn.injava.forex.web.model.technical.Signal;
import cn.injava.forex.web.model.technical.Technical;
import cn.injava.forex.web.model.technical.TechnicalSummary;
import cn.injava.forex.web.model.technical.TradingSignal;
import com.gargoylesoftware.htmlunit.HttpMethod;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.WebRequest;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;

/**
 *
 * 技术分析
 *
 * 地址https://www.investing.com/technical/technical-summary
 *
 * Created by leiguorui on 2017/10/27.
 */
@Service
public class TechnicalnvestingService {
    private WebRequest requestSettings;

    /**
     * 获取货币对的买入卖出
     * @return
     * @throws MalformedURLException
     */
    public Map<String, String> getTechnicals() throws MalformedURLException {

        final WebClient webClient = new HtmlUnit().getGeneralWebClient();
        Map<String, String> result = new HashMap<>();

        try {
            final String response = webClient.getPage(requestSettings).getWebResponse().getContentAsString();

            JsonObject jsonObject = new Gson().fromJson(response, JsonObject.class);

            Document doc = Jsoup.parse(jsonObject.get("html").getAsString());

            List<Element> currencys = doc.select("a.arial_14");
            List<Element> technicals = doc.select("tr[data-row-type=summary]");

            for (int n = 0; n < currencys.size(); n++){
                String currency = currencys.get(n).text().replace("/", "_");

                SortedSet<String> techs = new TreeSet<>();
                for (Element tech : technicals.get(n).select("td.js-socket-elem")){
                    techs.add(tech.text());
                }

                if (techs.size() == 1 && techs.first().contains("Strong")){
                    result.put(currency, techs.first().replace("Strong ","").toUpperCase());
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            webClient.close();
        }

        return result;
    }

    public static void main(String[] args) throws MalformedURLException {
        TechnicalnvestingService service = new TechnicalnvestingService();
        service.getTechnicals();
    }

    @PostConstruct
    public void init() throws Exception {
        URL url = new URL("https://www.investing.com/technical/Service/GetSummaryTable");
        requestSettings = new WebRequest(url, HttpMethod.POST);
        requestSettings.setAdditionalHeader("Content-Type", "application/x-www-form-urlencoded");
        requestSettings.setAdditionalHeader("Referer", "https://www.investing.com/technical/technical-summary");
        requestSettings.setAdditionalHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/61.0.3163.100 Safari/537.36");
        requestSettings.setAdditionalHeader("X-Requested-With", "XMLHttpRequest");
        requestSettings.setRequestBody("tab=forex&options%5Bperiods%5D%5B%5D=300&options%5Bperiods%5D%5B%5D=900&options%5Bperiods%5D%5B%5D=1800&options%5Bperiods%5D%5B%5D=3600&options%5Breceive_email%5D=false&options%5Bcurrencies%5D%5B%5D=1&options%5Bcurrencies%5D%5B%5D=2&options%5Bcurrencies%5D%5B%5D=3&options%5Bcurrencies%5D%5B%5D=4&options%5Bcurrencies%5D%5B%5D=5&options%5Bcurrencies%5D%5B%5D=7&options%5Bcurrencies%5D%5B%5D=8");
    }
}
