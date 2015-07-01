package cn.injava.forex.core.schedul;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
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

    //订阅价格
    private SubPriceTask subPriceTaskEURUSD;

    //订阅技术分析
    private SubTechnicalTask subTechnicalTaskEURUSD300;

    //执行定时任务
    protected void executeInternal(JobExecutionContext context)
            throws JobExecutionException {

        threadPoolTaskExecutor.execute(subPriceTaskEURUSD);
        threadPoolTaskExecutor.execute(subTechnicalTaskEURUSD300);

    }

    public void setThreadPoolTaskExecutor(ThreadPoolTaskExecutor threadPoolTaskExecutor) {
        this.threadPoolTaskExecutor = threadPoolTaskExecutor;
    }
    public void setSubPriceTaskEURUSD(SubPriceTask subPriceTaskEURUSD) {
        this.subPriceTaskEURUSD = subPriceTaskEURUSD;
    }
    public void setSubTechnicalTaskEURUSD300(SubTechnicalTask subTechnicalTaskEURUSD300) {
        this.subTechnicalTaskEURUSD300 = subTechnicalTaskEURUSD300;
    }
}