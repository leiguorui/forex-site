package cn.injava.forex.core.schedul;

import cn.injava.forex.core.utils.MailUtil;
import cn.injava.forex.web.model.SubPrice;
import cn.injava.forex.web.service.SubService;
import com.gargoylesoftware.htmlunit.Page;
import com.gargoylesoftware.htmlunit.WebClient;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;

/**
 * 获取价格的方法
 *
 * Created by Administrator on 2015/6/30.
 */
@Component
@Scope("prototype")
public class SubPriceTask implements Runnable{
    @Value("#{sysConfigProperties['forex.price.host']}")
    private String forexPriceHost;

    @Value("#{sysConfigProperties['email.username']}")
    private String mailSender;

    @Value("#{sysConfigProperties['price.pip']}")
    private double pricePip;

    @Resource
    private MailUtil mailUtil;

    @Resource
    private SubService subService;

    private String product;

    public SubPriceTask(String product){
        this.product = product;
    }

    @Override
    public void run() {

        while(true){
            // 报价
            double bid = subPrice(product);

            //遍历订阅者
            for (SubPrice subPrice : subService.getSubPricesByProduct(product)){
                double absul = Math.abs(bid - subPrice.getPrice());
                if (absul < pricePip){
                    mailUtil.sendMail(mailSender,
                            subPrice.getEmail(),
                            product+"-"+subPrice.getPrice(),
                            "Testing only \n\n Hello Spring Email Sender");

                    subService.removeSubPrice(subPrice);
                    System.out.println("mail has send----"+subPrice.getEmail());
                }
            }

            try {
                Thread.sleep(1000); // Waiting before run.
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 读取价格
     * @param product 货币对
     * @return
     */
    public double subPrice(String product) {
        final WebClient webClient = new WebClient();
        double bid = 0;
        try {
            final Page page = webClient.getPage(forexPriceHost+product);
            String response = page.getWebResponse().getContentAsString();
            System.out.println(response);

            JsonElement jelement = new JsonParser().parse(response);
            JsonObject jobject = jelement.getAsJsonObject();
            jobject = jobject.getAsJsonObject(product);
            bid = jobject.get("bid").getAsDouble();

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("subPrice完成一次请求");

        return bid;
    }
}
