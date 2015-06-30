package cn.injava.forex.core.schedul;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 定时任务，调用task执行方法
 * User: Administrator
 * Date: 15-4-16
 * Time: 上午10:46
 */
public class RunMeJob extends QuartzJobBean {
    private ThreadPoolTaskExecutor threadPoolTaskExecutor;
    private SubPriceTask subPriceTaskEURUSD;

    public void setThreadPoolTaskExecutor(ThreadPoolTaskExecutor threadPoolTaskExecutor) {
        this.threadPoolTaskExecutor = threadPoolTaskExecutor;
    }
    public void setSubPriceTaskEURUSD(SubPriceTask subPriceTaskEURUSD) {
        this.subPriceTaskEURUSD = subPriceTaskEURUSD;
    }

    protected void executeInternal(JobExecutionContext context)
            throws JobExecutionException {

        threadPoolTaskExecutor.execute(subPriceTaskEURUSD);

    }
}