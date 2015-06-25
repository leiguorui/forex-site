package cn.injava.forex.web.service;

import com.gargoylesoftware.htmlunit.Page;
import com.gargoylesoftware.htmlunit.WebClient;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class SubPriceService {
    @Value("#{sysConfigProperties['forex.price.host']}")
    private String forexPriceHost;

    public boolean subPrice(String product, double price ) {
        final WebClient webClient = new WebClient();
        boolean result = false;
        try {
            final Page page = webClient.getPage(forexPriceHost+product);
            String response = page.getWebResponse().getContentAsString();
            System.out.println(response);

            JsonElement jelement = new JsonParser().parse(response);
            JsonObject jobject = jelement.getAsJsonObject();
            jobject = jobject.getAsJsonObject(product);
            double bid = jobject.get("bid").getAsDouble();
            double absul = Math.abs(bid - price);
            if (absul < 0.0002){
                result = true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }

    @Async
    public void subPriceByEmailAsync(String email, String product, double price ){
        while(true){
            try {
                Thread.sleep(1000); // Waiting before run.
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (this.subPrice("EURUSD", 1.1203)){
                break;
            }
        }
    }
}
