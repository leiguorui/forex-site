package cn.injava.forex.core.schedul;

import cn.injava.forex.core.common.ApplicationContextProvider;
import cn.injava.forex.core.concurrent.ThreadPool;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.scheduling.quartz.QuartzJobBean;

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

        String[] products = {"EURUSD","AUDUSD","GBPUSD","USDJPY","NZDUSD","CHFUSD","USDCAD"};

        for (String product : products){
            //订阅价格
            SubPriceTask subPriceTask = (SubPriceTask) applicationContext.getBean("subPriceTask");
            subPriceTask.setProduct(product);
            threadPool.runTask(subPriceTask);
        }

        logger.debug("定时任务已启动, ActiveCount {} ", threadPool.getActiveCount());
    }

    public void setThreadPool(ThreadPool threadPool){
        this.threadPool = threadPool;
    }
}