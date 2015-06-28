package cn.injava.forex.web.service;

import cn.injava.forex.core.utils.MailUtil;
import cn.injava.forex.web.model.Technical;
import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;

@Service
public class SubTechnicalService {
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
    public Technical subTechnical(String product, int period ) {
        final WebClient webClient = new WebClient(BrowserVersion.CHROME);
        //TODO 这里可以启动webclient的ajax功能，读取技术指标的变化
        webClient.getOptions().setCssEnabled(false);//if you don't need css
        webClient.getOptions().setJavaScriptEnabled(false);//if you don't need js
        webClient.getOptions().setActiveXNative(false);
        webClient.getOptions().setAppletEnabled(false);
        webClient.getOptions().setDoNotTrackEnabled(true);
        webClient.getOptions().setGeolocationEnabled(false);
        Technical technical = new Technical();
        try {
            final HtmlPage page = webClient.getPage(forexTechnicalHost + product+ "-technical?period="+period);
            String maBuy = page.getHtmlElementById("maBuy").asText();
            String maSell = page.getHtmlElementById("maSell").asText();
            String tiBuy = page.getHtmlElementById("tiBuy").asText();
            String tiSell = page.getHtmlElementById("tiSell").asText();

            technical.setMaBuy(maBuy);
            technical.setMaSell(maSell);
            technical.setTiBuy(tiBuy);
            technical.setTiSell(tiSell);

            System.out.println("完成一次请求");
        } catch (IOException e) {
            e.printStackTrace();
        }


        return technical;
    }

    /**
     * 订阅报价
     * @param email
     * @param product
     * @param period
     */
    public void subByEmailAsync(String email, String product, int period ){

        class OneShotTask implements Runnable {
            String email;
            String product;
            int period;
            SubTechnicalService subPriceService;

            // 使用构造函数传递参数
            OneShotTask(String e, String pt, int pc, SubTechnicalService sp) {
                email = e;
                product = pt;
                period = pc;
                subPriceService = sp;
            }

            public void run() {
                while(true){
//                    try {
//                        Thread.sleep(period*1000); // 等待60秒
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }

                    Technical technical = subPriceService.subTechnical(product, period);

                    if ("(12)".equals(technical.getMaBuy()) && "(12)".equals(technical.getTiBuy())){
                        mailUtil.sendMail(mailSender,
                                email,
                                product+"-买入",
                                "Testing only \n\n Hello Spring Email Sender");
                        System.out.println("mail has send");
                        break;
                    } else if ("(12)".equals(technical.getMaSell()) && "(12)".equals(technical.getTiSell())){
                        mailUtil.sendMail(mailSender,
                                email,
                                product+"-卖出",
                                "Testing only \n\n Hello Spring Email Sender");
                        System.out.println("mail has send");
                        break;
                    }
                }
            }
        }

        Thread t = new Thread(new OneShotTask(email,product,period,this));
        t.start();
    }
}
