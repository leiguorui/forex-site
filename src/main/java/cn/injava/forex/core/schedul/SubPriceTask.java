package cn.injava.forex.core.schedul;

import cn.injava.forex.core.utils.HtmlUnit;
import cn.injava.forex.core.utils.MailUtil;
import cn.injava.forex.web.model.Product;
import cn.injava.forex.web.model.SubModel;
import cn.injava.forex.web.service.SubService;
import com.gargoylesoftware.htmlunit.Page;
import com.gargoylesoftware.htmlunit.WebClient;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.TimeZone;

/**
 * 获取价格的方法
 *
 * Created by Administrator on 2015/6/30.
 */
@Component
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
    private HtmlUnit htmlUnit;

    @Resource
    private SubService subService;

    private String product;

    private static final Logger logger =
            LoggerFactory.getLogger(SubPriceTask.class);

    @Override
    public void run() {

        while(true){
            Product productModel = subPrice(product);

            //加入到service
            subService.setProduct(productModel);

            // 报价
            BigDecimal bid = productModel.getBid();

            //遍历订阅者
            for (SubModel subModel : subService.getSubPricesByProduct(product)){
                double absul = Math.abs(bid.doubleValue() - subModel.getPrice().doubleValue());
                if (absul < pricePip){
                    mailUtil.sendMail(mailSender,
                            subModel.getEmail(),
                            product+"-"+subModel.getPrice(),
                            "Testing only \n\n Hello Spring Email Sender");

                    subService.removeSubPrice(subModel);

                    logger.debug("mail has send to {}", subModel.getEmail());
                }
            }

            try {
                Thread.sleep(10*1000); // Waiting before run.
            } catch (InterruptedException e) {
                //A thread cannot process an interrupt while it's sleeping.  restore interrupted status
                //当threadPoolTaskExecutor.shutdown()，会抛出这个异常，捕获之后结束循环
                Thread.currentThread().interrupt();
                break;
            }
        }

        logger.debug(" thread completed ！");
    }

    /**
     * 读取价格
     * @param productName 货币对
     * @return
     */
    public Product subPrice(String productName) {
        final WebClient webClient = htmlUnit.getFastWebClient();
        Product product = new Product();

        try {
            final Page page = webClient.getPage(forexPriceHost+productName);
            String response = page.getWebResponse().getContentAsString();

            JsonElement jelement = new JsonParser().parse(response);
            JsonObject jobject = jelement.getAsJsonObject();
            jobject = jobject.getAsJsonObject(productName);
            BigDecimal bid = jobject.get("bid").getAsBigDecimal();
            BigDecimal ask = jobject.get("ask").getAsBigDecimal();
            BigDecimal change = jobject.get("change").getAsBigDecimal();
            long lasttime = jobject.get("lasttime").getAsLong();

            product.setAsk(ask);
            product.setBid(bid);
            product.setChange(change);
            //TODO lasttime不知道是哪个时区,所有用了本地的时间
//            product.setDateTime(new DateTime(lasttime*1000));
            product.setDateTime(new DateTime());
            product.setProductName(productName);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            webClient.close();
        }

//        logger.debug("完成一次报价的请求, product: {}",product.toString());

        return product;
    }

    public void setProduct(String product){
        this.product = product;
    }
}
