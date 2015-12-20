package cn.injava.forex.core.schedul;

import cn.injava.forex.core.constant.SystemConstant;
import cn.injava.forex.core.utils.HtmlUnit;
import cn.injava.forex.core.utils.MailUtil;
import cn.injava.forex.web.model.Product;
import cn.injava.forex.web.model.SubModel;
import cn.injava.forex.web.model.Technical;
import cn.injava.forex.web.service.SubService;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 读取技术指标
 */
@Component
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

    private static final Logger logger =
            LoggerFactory.getLogger(SubTechnicalTask.class);

    @Override
    public void run() {

        while(true){
            Technical technical = subTechnical(product, period);

            //加入到service
            subService.setTechnical(technical);

            //TODO 需要给订阅者发送邮件提醒
            //对订阅者发送消息
//            subByMultiPeriod(product, new int[]{300, 900, 3600});

            try {
                Thread.sleep(period*1000);
            } catch (InterruptedException e) {
                //A thread cannot process an interrupt while it's sleeping.  restore interrupted status
                //当threadPoolTaskExecutor.shutdown()，会抛出这个异常，捕获之后结束循环
                Thread.currentThread().interrupt();
                break;
            }
        }

        logger.debug("thread completed ！");
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

            technical.setProdutcName(product);
            technical.setPeriod(period);
            technical.setMaBuy(maBuy);
            technical.setMaSell(maSell);
            technical.setTiBuy(tiBuy);
            technical.setTiSell(tiSell);
        } catch (IOException e) {
            e.printStackTrace();
        }

        logger.debug("完成一次技术的请求，{}", technical.toString());

        return technical;
    }

    /**
     * 根据一个时段，订阅技术分析
     *
     * @param product
     * @param period
     */
    public void subByPeriod(String product, int period, Technical technical){
        //遍历订阅者
        for (SubModel subModel : subService.getSubTechnicalByProductAndPeriod(product, period)){
            String techSingle = technical.getTechSingle();
            if (!SystemConstant.TECH_NO_CLEAR_SINGLE.equals(techSingle)){
                mailUtil.sendMail(mailSender,
                        subModel.getEmail(),
                        product+"-"+techSingle,
                        "技术分析详情： \n\n" + technical.toString());

//                subService.removeSubPrice(subModel);

                logger.debug("mail has send to {}", subModel.getEmail());
            }
        }
    }

    /**
     * 订阅多个时段的技术指标
     * @param product
     * @param periods
     */
    public void subByMultiPeriod(String product, int[] periods){
        Map<Integer, Technical> technicalsInService = subService.getProductByProductName(product).getTechnicals();
        //遍历订阅者
        for (SubModel subModel : subService.getSubTechnicalByProductAndPeriods(product, periods)){
            Set<String> techSingleSet = new HashSet<>();

            //遍历时段
            for (int period : periods){
                String techSingle = technicalsInService.get(period).getTechSingle();
                techSingleSet.add(techSingle);
            }

            if (techSingleSet.size() == 1){
                mailUtil.sendMail(mailSender,
                        subModel.getEmail(),
                        product+"-"+techSingleSet.iterator().next(),
                        "技术分析详情： \n\n" + technicalsInService.toString());

                logger.debug("mail has send to {}", subModel.getEmail());
            }
        }
    }

    public void setPeriod(int period) {
        this.period = period;
    }

    public void setProduct(String product) {
        this.product = product;
    }
}
