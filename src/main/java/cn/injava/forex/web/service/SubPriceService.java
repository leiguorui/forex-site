package cn.injava.forex.web.service;

import com.gargoylesoftware.htmlunit.Page;
import com.gargoylesoftware.htmlunit.WebClient;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class SubPriceService {
    public boolean subPrice(String email, String product, double price ) {
        final WebClient webClient = new WebClient();
        boolean result = false;
        try {
            final Page page = webClient.getPage("http://quotes.instaforex.com/get_quotes.php?m=json&q="+product);
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
}
