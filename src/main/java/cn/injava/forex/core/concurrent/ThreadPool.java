package cn.injava.forex.core.concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * 线程池
 *
 * Created by Administrator on 2015/7/11.
 */
public class ThreadPool {
    private int poolSize = 10;
    private int maxPoolSize = 20;
    private long keepAliveTime = 5000;
    private ThreadPoolExecutor threadPoolExecutor = null;
    private List<FutureTask> futureTasks = new ArrayList<>();
    private BlockingQueue<Runnable> blockingQueue = new ArrayBlockingQueue<Runnable>(50);

    public ThreadPool() {
        System.out.println("Starting pool...");
        threadPoolExecutor = new ThreadPoolExecutor(poolSize, maxPoolSize, keepAliveTime, TimeUnit.MILLISECONDS, blockingQueue);
    }

    public void runTask(Runnable task) {
        FutureTask futureTask = (FutureTask) threadPoolExecutor.submit(task);

        futureTasks.add(futureTask);
    }

    public void shutDown() {
        threadPoolExecutor.shutdownNow();
    }

    public void callCancel() {
        for (FutureTask futureTask : futureTasks){
            futureTask.cancel(true);
        }
    }

    public int getActiveCount(){
        return threadPoolExecutor.getActiveCount();
    }

    public int getBlockingQueueSize(){
        return blockingQueue.size();
    }
}
