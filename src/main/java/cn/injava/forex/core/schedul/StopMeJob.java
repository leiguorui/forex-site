package cn.injava.forex.core.schedul;

import cn.injava.forex.core.concurrent.ThreadPool;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 * 定时任务，调用task执行方法
 * User: Administrator
 * Date: 15-4-16
 * Time: 上午10:46
 */
public class StopMeJob extends QuartzJobBean {
    private ThreadPool threadPool;

    private static final Logger logger =
            LoggerFactory.getLogger(StopMeJob.class);

    public void setThreadPool(ThreadPool threadPool) {
        this.threadPool = threadPool;
    }

    protected void executeInternal(JobExecutionContext context)
            throws JobExecutionException {

        threadPool.callCancel();

        logger.debug("定时任务已停止, ActiveCount {} ", threadPool.getActiveCount());

    }
}