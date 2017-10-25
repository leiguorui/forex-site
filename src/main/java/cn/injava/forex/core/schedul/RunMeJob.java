package cn.injava.forex.core.schedul;

import cn.injava.forex.core.common.ApplicationContextProvider;
import cn.injava.forex.core.concurrent.ThreadPool;
import cn.injava.forex.core.constant.SystemConstant;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.Map;
import java.util.TreeMap;

/**
 * 定时任务，调用task执行方法
 * User: Administrator
 * Date: 15-4-16
 * Time: 上午10:46
 */
public class RunMeJob extends QuartzJobBean {
    //线程池
    private ThreadPool threadPool;

    ApplicationContext applicationContext = ApplicationContextProvider.getApplicationContext();

    private static final Logger logger =
            LoggerFactory.getLogger(RunMeJob.class);

    //执行定时任务
    protected void executeInternal(JobExecutionContext context)
            throws JobExecutionException {
        logger.debug("定时任务正在启动...");

        //爬取新闻
        NewsTask newsTask = (NewsTask) applicationContext.getBean("newsTask");
//        threadPool.runTask(newsTask);

        //订阅价格
        String[] products = {"EURUSD","AUDUSD","GBPUSD","USDJPY"};
        for (String product : products){
            SubPriceTask subPriceTask = (SubPriceTask) applicationContext.getBean("subPriceTask");
            subPriceTask.setProduct(product);
//            threadPool.runTask(subPriceTask);
        }

        //订阅技术指标
        String[] productsPeriod = {"eur-usd","aud-usd"};
        for (String product : productsPeriod){
            int[] periods = {900,3600,86400}; //15分钟、60分钟、一天
            for (int period : periods){
                SubTechnicalTask subTechnicalTask =
                        (SubTechnicalTask) applicationContext.getBean("subTechnicalTask");
                subTechnicalTask.setProduct(product);
                subTechnicalTask.setPeriod(period);
//                threadPool.runTask(subTechnicalTask);
            }
        }

        //自动关闭oanda的订单
        OandaCloseTradeTask oandaCloseTradeTask = (OandaCloseTradeTask) applicationContext.getBean("oandaCloseTradeTask");
        threadPool.runTask(oandaCloseTradeTask);

        //自动开启oanda的订单
        OandaOpenTradeTask oandaOpenTradeTask = (OandaOpenTradeTask) applicationContext.getBean("oandaOpenTradeTask");
        threadPool.runTask(oandaOpenTradeTask);

        logger.debug("定时任务已启动, ActiveCount {} ", threadPool.getActiveCount());
    }

    public void setThreadPool(ThreadPool threadPool){
        this.threadPool = threadPool;
    }
}