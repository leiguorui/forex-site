package cn.injava.forex.core.schedul;

import cn.injava.forex.core.utils.HtmlUnit;
import cn.injava.forex.core.utils.MailUtil;
import cn.injava.forex.web.model.SubModel;
import cn.injava.forex.web.model.Technical;
import cn.injava.forex.web.service.SubService;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * 读取技术指标
 */
@Component
@Scope("prototype")
public class SubTechnicalTask implements Runnable{
    @Value("#{sysConfigProperties['forex.technical.host']}")
    private String forexTechnicalHost;

    @Value("#{sysConfigProperties['email.username']}")
    private String mailSender;

    @Resource
    private MailUtil mailUtil;

    @Resource
    private HtmlUnit htmlUnit;

    @Resource
    private SubService subService;

    private String product;
    private int period;

    public SubTechnicalTask(String product, int period){
        this.product = product;
        this.period = period;
    }

    @Override
    public void run() {

        while(true){
            Technical technical = subTechnical(product, period);

            //遍历订阅者
            for (SubModel subModel : subService.getSubTechnicalByProductAndPeriod(product, period)){
                if ("(12)".equals(technical.getMaBuy()) && "(12)".equals(technical.getTiBuy())){
                    mailUtil.sendMail(mailSender,
                            subModel.getEmail(),
                            product+"-买入",
                            "Testing only \n\n Hello Spring Email Sender");

                    subService.removeSubPrice(subModel);
                    System.out.println("mail has send----"+subModel.getEmail());
                } else if ("(12)".equals(technical.getMaSell()) && "(12)".equals(technical.getTiSell())){
                    mailUtil.sendMail(mailSender,
                            subModel.getEmail(),
                            product+"-卖出",
                            "Testing only \n\n Hello Spring Email Sender");

                    subService.removeSubPrice(subModel);
                    System.out.println("mail has send----"+subModel.getEmail());
                }
            }

            try {
                Thread.sleep(period*1000);
            } catch (InterruptedException e) {
                //A thread cannot process an interrupt while it's sleeping.  restore interrupted status
                //当threadPoolTaskExecutor.shutdown()，会抛出这个异常，捕获之后结束循环
                Thread.currentThread().interrupt();
                break;
            }
        }

        System.out.println("Shutting down thread");
    }

    /**
     * 读取技术分析
     * @param product 货币对
     * @param period   时间段
     * @return
     */
    public Technical subTechnical(String product, int period ) {
        final WebClient webClient = htmlUnit.getFastWebClient();

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
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("subTechnical完成一次请求");

        return technical;
    }
}
