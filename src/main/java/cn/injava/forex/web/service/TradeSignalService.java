package cn.injava.forex.web.service;

import cn.injava.forex.core.utils.HtmlUnit;
import cn.injava.forex.web.model.technical.Signal;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.WebRequest;
import com.gargoylesoftware.htmlunit.xml.XmlPage;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * forexfactory.com 交易信号
 *
 * Created by leiguorui on 2017/10/20.
 */
@Service
public class TradeSignalService {

    private WebRequest requestSettings;

    public List<Signal> getSignals() {

        final WebClient webClient = new HtmlUnit().getGeneralWebClient();
        List<Signal> signals = new ArrayList<>();

        try {

            final XmlPage page = webClient.getPage(requestSettings);

            Document doc = Jsoup.parse(page.asText());

            for (Element element : doc.select("tr[class=trades_activity__row]")){

//     -----------------           返回的数据格式
//                    System.out.println(element.select("p[class=trades_activity__overview]").text());
//                    System.out.println(element.select("p[class=trades_activity__info caption]").text());
//                    System.out.println(element.select("a[class=avatar]").next().text());
//                    System.out.println(element.select("span[class~=^(better|worse)$]").text());

//                    EUR/USD  BUY  1.1755
//                    Opened Long | 3 min ago
//                    M.A.C.Doug
//                    0.1% 1

                String[] currency = element.select("p[class=trades_activity__overview]").text().split(" ");
                String[] time = element.select("p.trades_activity__info span.nowrap").text().split(" ");
                String user = element.select("a[class=avatar]").next().text();
                String[] profit = element.select("span[class~=^(better|worse)$]").text().split(" ");
                if(Integer.parseInt(time[0].replace("~","")) < 3 && "min".equals(time[1])){

                    Signal signal = new Signal();
                    signal.setCurrency(currency[0].replace("/", "_"));
                    signal.setSignal(currency[1].substring(1, currency[1].length()-1));

                    //设置信号强度
                    if(Integer.parseInt(profit[1]) > 0){
                        signal.setIntensity(5);
                    }else {
                        signal.setIntensity(1);
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

    @PostConstruct
    public void init() throws Exception {
        URL url = new URL("https://www.forexfactory.com/flex.php");
        requestSettings = new WebRequest(url, com.gargoylesoftware.htmlunit.HttpMethod.POST);
        requestSettings.setAdditionalHeader("Content-Type", "application/x-www-form-urlencoded");
        requestSettings.setRequestBody("s=&securitytoken=guest&do=saveoptions&setdefault=no&ignoreinput=no&flex%5BTrades%2FActivity_tradesActivityCopy2%5D%5BidSuffix%5D=&flex%5BTrades%2FActivity_tradesActivityCopy2%5D%5B_flexForm_%5D=flexForm&flex%5BTrades%2FActivity_tradesActivityCopy2%5D%5BmodelData%5D=YTo5OntzOjEwOiJpc0hvbWVwYWdlIjtiOjE7czoxMzoicHJlbG9hZE9uVmlldyI7YjowO3M6MTg6ImRlZmF1bHRJbnN0cnVtZW50cyI7YTo5Njp7aTowO3M6NjoiQVVEQ0FEIjtpOjE7czo2OiJBVURDSEYiO2k6MjtzOjY6IkFVRENaSyI7aTozO3M6NjoiQVVEREtLIjtpOjQ7czo2OiJBVURKUFkiO2k6NTtzOjY6IkFVRE5aRCI7aTo2O3M6NjoiQVVEUExOIjtpOjc7czo2OiJBVURTR0QiO2k6ODtzOjY6IkFVRFVTRCI7aTo5O3M6NjoiQlRDVVNEIjtpOjEwO3M6NjoiQ0FEQ0hGIjtpOjExO3M6NjoiQ0FESlBZIjtpOjEyO3M6NjoiQ0hGSEtEIjtpOjEzO3M6NjoiQ0hGSlBZIjtpOjE0O3M6NjoiQ0hGUExOIjtpOjE1O3M6NjoiQ0hGU0dEIjtpOjE2O3M6NjoiQ0hGWkFSIjtpOjE3O3M6NjoiRVVSQVVEIjtpOjE4O3M6NjoiRVVSQ0FEIjtpOjE5O3M6NjoiRVVSQ0hGIjtpOjIwO3M6NjoiRVVSQ1pLIjtpOjIxO3M6NjoiRVVSREtLIjtpOjIyO3M6NjoiRVVSR0JQIjtpOjIzO3M6NjoiRVVSSEtEIjtpOjI0O3M6NjoiRVVSSFVGIjtpOjI1O3M6NjoiRVVSSlBZIjtpOjI2O3M6NjoiRVVSTVhOIjtpOjI3O3M6NjoiRVVSTk9LIjtpOjI4O3M6NjoiRVVSTlpEIjtpOjI5O3M6NjoiRVVSUExOIjtpOjMwO3M6NjoiRVVSUlVCIjtpOjMxO3M6NjoiRVVSU0VLIjtpOjMyO3M6NjoiRVVSU0dEIjtpOjMzO3M6NjoiRVVSVFJZIjtpOjM0O3M6NjoiRVVSVVNEIjtpOjM1O3M6NjoiRVVSWkFSIjtpOjM2O3M6NjoiR0JQQVVEIjtpOjM3O3M6NjoiR0JQQ0FEIjtpOjM4O3M6NjoiR0JQQ0hGIjtpOjM5O3M6NjoiR0JQREtLIjtpOjQwO3M6NjoiR0JQSlBZIjtpOjQxO3M6NjoiR0JQTk9LIjtpOjQyO3M6NjoiR0JQTlpEIjtpOjQzO3M6NjoiR0JQUExOIjtpOjQ0O3M6NjoiR0JQU0VLIjtpOjQ1O3M6NjoiR0JQU0dEIjtpOjQ2O3M6NjoiR0JQVFJZIjtpOjQ3O3M6NjoiR0JQVVNEIjtpOjQ4O3M6NjoiR0JQWkFSIjtpOjQ5O3M6NjoiTk9LSlBZIjtpOjUwO3M6NjoiTk9LU0VLIjtpOjUxO3M6NjoiTlpEQ0FEIjtpOjUyO3M6NjoiTlpEQ0hGIjtpOjUzO3M6NjoiTlpESEtEIjtpOjU0O3M6NjoiTlpESlBZIjtpOjU1O3M6NjoiTlpEU0dEIjtpOjU2O3M6NjoiTlpEVVNEIjtpOjU3O3M6NjoiUExOSlBZIjtpOjU4O3M6NjoiU0VLSlBZIjtpOjU5O3M6NjoiU0dEQ0hGIjtpOjYwO3M6NjoiU0dESlBZIjtpOjYxO3M6NjoiVVNEQ0FEIjtpOjYyO3M6NjoiVVNEQ0hGIjtpOjYzO3M6NjoiVVNEQ05IIjtpOjY0O3M6NjoiVVNEQ1pLIjtpOjY1O3M6NjoiVVNEREtLIjtpOjY2O3M6NjoiVVNESEtEIjtpOjY3O3M6NjoiVVNESFVGIjtpOjY4O3M6NjoiVVNESUxTIjtpOjY5O3M6NjoiVVNESlBZIjtpOjcwO3M6NjoiVVNETVhOIjtpOjcxO3M6NjoiVVNETk9LIjtpOjcyO3M6NjoiVVNEUExOIjtpOjczO3M6NjoiVVNEUlVCIjtpOjc0O3M6NjoiVVNEU0VLIjtpOjc1O3M6NjoiVVNEU0dEIjtpOjc2O3M6NjoiVVNEVEhCIjtpOjc3O3M6NjoiVVNEVFJZIjtpOjc4O3M6NjoiVVNEWkFSIjtpOjc5O3M6NjoiWkFSSlBZIjtpOjgwO3M6NjoiQVVER0JQIjtpOjgxO3M6NjoiQVVETk9LIjtpOjgyO3M6NjoiQVVEWkFSIjtpOjgzO3M6NjoiQ0FESEtEIjtpOjg0O3M6NjoiQ0FETk9LIjtpOjg1O3M6NjoiQ0FEWkFSIjtpOjg2O3M6NjoiQ0hGQ1pLIjtpOjg3O3M6NjoiQ0hGU0VLIjtpOjg4O3M6NjoiQ1pLSlBZIjtpOjg5O3M6NjoiR0JQQkdOIjtpOjkwO3M6NjoiR0JQSEtEIjtpOjkxO3M6NjoiR0JQTVhOIjtpOjkyO3M6NjoiVFJZSlBZIjtpOjkzO3M6NjoiVVNEQkdOIjtpOjk0O3M6NjoiVVNESU5SIjtpOjk1O3M6Njoic3RvY2tzIjt9czoxMToicGFfY29udHJvbHMiO3M6MjQ6ImhvbWVwYWdlfFRyYWRlRmVlZF9Db3B5MiI7czoxNjoicGFfaW5qZWN0cmV2ZXJzZSI7YjowO3M6MTY6InBhX2hhcmRpbmplY3Rpb24iO2I6MDtzOjExOiJwYV9pbmplY3RhdCI7YjowO3M6ODoic2hvd0xpdmUiO2I6MTtzOjE0OiJzdHJlYW1DaGVja2JveCI7czozNzg6IjxzcGFuIGNsYXNzPSJmbGV4RXh0ZXJuYWxPcHRpb24iIGRhdGEtdHlwZT0iSW5saW5lQ2hlY2tib3giPjxpbnB1dCB0eXBlPSJjaGVja2JveCIgY2xhc3M9ImNoZWNrYm94IiBuYW1lPSJmbGV4W1RyYWRlcy9BY3Rpdml0eV90cmFkZXNBY3Rpdml0eUNvcHkyXVt0cmFkZXMvc3RyZWFtXVtdIiBpZD0iZmxleFtUcmFkZXMvQWN0aXZpdHlfdHJhZGVzQWN0aXZpdHlDb3B5Ml1bdHJhZGVzL3N0cmVhbV1bMV0iIHZhbHVlPSIxIiBjaGVja2VkPSJjaGVja2VkIiBkYXRhLWlzZGVmYXVsdD0idHJ1ZSIgLz48bGFiZWwgZm9yPSJmbGV4W1RyYWRlcy9BY3Rpdml0eV90cmFkZXNBY3Rpdml0eUNvcHkyXVt0cmFkZXMvc3RyZWFtXVsxXSIgPlN0cmVhbTwvbGFiZWw%2BPC9zcGFuPiI7fQ%3D%3D&flex%5BTrades%2FActivity_tradesActivityCopy2%5D%5Btrades%2Fstream%5D%5B%5D=1&flex%5BTrades%2FActivity_tradesActivityCopy2%5D%5Btrades%2Ftradetype%5D=entries&flex%5BTrades%2FActivity_tradesActivityCopy2%5D%5Btrades%2Faccounttype%5D=live&flex%5BTrades%2FActivity_tradesActivityCopy2%5D%5Bmirs%5D=1&flex%5BTrades%2FActivity_tradesActivityCopy2%5D%5Bmirs%5D=3&flex%5BTrades%2FActivity_tradesActivityCopy2%5D%5Btrades%2Finstruments%5D%5B%5D=AUDUSD&flex%5BTrades%2FActivity_tradesActivityCopy2%5D%5Btrades%2Finstruments%5D%5B%5D=EURUSD&flex%5BTrades%2FActivity_tradesActivityCopy2%5D%5Btrades%2Finstruments%5D%5B%5D=GBPUSD&flex%5BTrades%2FActivity_tradesActivityCopy2%5D%5Btrades%2Finstruments%5D%5B%5D=NZDUSD&flex%5BTrades%2FActivity_tradesActivityCopy2%5D%5Btrades%2Finstruments%5D%5B%5D=USDCAD&flex%5BTrades%2FActivity_tradesActivityCopy2%5D%5Btrades%2Finstruments%5D%5B%5D=USDCHF&flex%5BTrades%2FActivity_tradesActivityCopy2%5D%5Btrades%2Finstruments%5D%5B%5D=USDJPY&false");
    }
}
