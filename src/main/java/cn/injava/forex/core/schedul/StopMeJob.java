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
public class StopMeJob extends QuartzJobBean {
    private ThreadPoolTaskExecutor threadPoolTaskExecutor;

    public void setThreadPoolTaskExecutor(ThreadPoolTaskExecutor threadPoolTaskExecutor) {
        this.threadPoolTaskExecutor = threadPoolTaskExecutor;
    }

    protected void executeInternal(JobExecutionContext context)
            throws JobExecutionException {

        threadPoolTaskExecutor.shutdown();

    }
}