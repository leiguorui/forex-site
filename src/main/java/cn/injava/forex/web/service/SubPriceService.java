package cn.injava.forex.web.service;

import cn.injava.forex.core.utils.MailUtil;
import com.gargoylesoftware.htmlunit.Page;
import com.gargoylesoftware.htmlunit.WebClient;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;

@Service
public class SubPriceService {
    @Value("#{sysConfigProperties['forex.price.host']}")
    private String forexPriceHost;

    @Resource
    private MailUtil mailUtil;

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

        class OneShotTask implements Runnable {
            String email;
            String product;
            double price;
            SubPriceService subPriceService;
            OneShotTask(String e, String pt, double pc,SubPriceService sp) {
                email = e;
                product = pt;
                price = pc;
                subPriceService = sp;
            }
            public void run() {
                while(true){
                    if (subPriceService.subPrice(product, price)){
                        mailUtil.sendMail("degree_lei2014@163.com",
                                email,
                                product+"-"+price,
                                "Testing only \n\n Hello Spring Email Sender");
                        System.out.println("mail has send");
                        break;
                    }
                }
            }
        }
        Thread t = new Thread(new OneShotTask(email,product,price,this));
        t.start();
    }
}
