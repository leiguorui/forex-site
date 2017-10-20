package test.service;

import cn.injava.forex.core.utils.HtmlUnit;
import cn.injava.forex.web.service.TradeFxService;
import com.gargoylesoftware.htmlunit.HttpMethod;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.WebRequest;
import com.gargoylesoftware.htmlunit.xml.XmlPage;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.URL;
import java.util.List;

/**
 * Created by leiguorui on 2017/1/17.
 */
public class OandaTest {

    private static final Logger logger = LoggerFactory.getLogger(OandaTest.class);

    public static void main(String[] args) {

        ApplicationContext context =
                new ClassPathXmlApplicationContext(new String[] {"classpath*:spring-web-servlet.xml"});

        TradeFxService tradeFxService = (TradeFxService)context.getBean("tradeFxService");

        while (true){

            logger.info("request");

            try {
                List<Integer> profitableId = tradeFxService.getProfitableOpenedTrades(new BigDecimal(0.1));

                for (Integer id : profitableId){
                    tradeFxService.closeTrade(id);
                }
            }catch (Exception e){
                logger.error(e.getMessage());
            }

            try {
                Thread.sleep(1000); // Waiting before run.
                logger.info("暂停");
            } catch (InterruptedException e) {
                //A thread cannot process an interrupt while it's sleeping.  restore interrupted status
                //当threadPoolTaskExecutor.shutdown()，会抛出这个异常，捕获之后结束循环
                Thread.currentThread().interrupt();
                break;
            }
        }

    }

}
