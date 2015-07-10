package cn.injava.forex.core.schedul;

import cn.injava.forex.core.common.ApplicationContextProvider;
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
    private ThreadPoolTaskExecutor threadPoolTaskExecutor;

    ApplicationContext applicationContext = ApplicationContextProvider.getApplicationContext();

    private static final Logger logger =
            LoggerFactory.getLogger(RunMeJob.class);

    //执行定时任务
    protected void executeInternal(JobExecutionContext context)
            throws JobExecutionException {
        logger.debug("定时任务正在启动...");

        threadPoolTaskExecutor.setCorePoolSize(5);
        threadPoolTaskExecutor.setMaxPoolSize(10);

        //订阅价格
        SubPriceTask subPriceTaskEURUSD = (SubPriceTask) applicationContext.getBean("subPriceTask");
        subPriceTaskEURUSD.setProduct("EURUSD");
        threadPoolTaskExecutor.execute(subPriceTaskEURUSD);

        //订阅价格
        SubPriceTask subPriceTaskAUDUSD = (SubPriceTask) applicationContext.getBean("subPriceTask");
        subPriceTaskAUDUSD.setProduct("AUDUSD");
        threadPoolTaskExecutor.execute(subPriceTaskAUDUSD);

        logger.debug("定时任务已启动, 共有线程 {} 个", threadPoolTaskExecutor.getActiveCount());
    }

    public void setThreadPoolTaskExecutor(ThreadPoolTaskExecutor threadPoolTaskExecutor) {
        this.threadPoolTaskExecutor = threadPoolTaskExecutor;
    }
}