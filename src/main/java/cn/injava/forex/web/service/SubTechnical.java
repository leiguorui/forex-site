package cn.injava.forex.web.service;

import cn.injava.forex.core.utils.MailUtil;
import com.gargoylesoftware.htmlunit.Page;
import com.gargoylesoftware.htmlunit.WebClient;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;

@Service
public class SubTechnical {
    @Value("#{sysConfigProperties['forex.technical.host']}")
    private String forexTechnicalHost;

    @Value("#{sysConfigProperties['email.username']}")
    private String mailSender;

    @Resource
    private MailUtil mailUtil;

    /**
     * 读取技术分析
     * @param product 货币对
     * @param period   时间段
     * @return
     */
    public boolean subTechnical(String product, double period ) {
        final WebClient webClient = new WebClient();
        webClient.setJavaScriptEnabled(false);
        boolean result = false;
        try {
            final Page page = webClient.getPage(forexTechnicalHost + product+ "-technical?period="+period);
                    String response = page.getWebResponse().getContentAsString();
            System.out.println(response);


        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }

    /**
     * 订阅报价
     * @param email
     * @param product
     * @param price
     */
    public void subByEmailAsync(String email, String product, double price ){

        class OneShotTask implements Runnable {
            String email;
            String product;
            double price;
            SubTechnical subPriceService;

            // 使用构造函数传递参数
            OneShotTask(String e, String pt, double pc,SubTechnical sp) {
                email = e;
                product = pt;
                price = pc;
                subPriceService = sp;
            }

            public void run() {
                while(true){
                    if (subPriceService.subTechnical(product, price)){
                        mailUtil.sendMail(mailSender,
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
