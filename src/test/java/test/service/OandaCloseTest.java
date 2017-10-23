package test.service;

import cn.injava.forex.web.service.TradeFxService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by leiguorui on 2017/1/17.
 */
public class OandaCloseTest {

    private static final Logger logger = LoggerFactory.getLogger(OandaCloseTest.class);

    public static void main(String[] args) {

        ApplicationContext context =
                new ClassPathXmlApplicationContext(new String[] {"classpath*:spring-web-servlet.xml"});

        TradeFxService tradeFxService = (TradeFxService)context.getBean("tradeFxService");

        while (true){

            logger.info("request");

            try {
                List<Integer> profitableId = tradeFxService.getProfitableOpenedTrades(new BigDecimal(0.1));
                profitableId.addAll(tradeFxService.getLossOpenedTrades(new BigDecimal(1)));

                for (Integer id : profitableId){
                    tradeFxService.closeTrade(id);
                    logger.info("close ---- " + id);
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
