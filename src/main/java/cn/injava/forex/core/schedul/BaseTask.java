package cn.injava.forex.core.schedul;

import cn.injava.forex.web.service.TradeFxService;
import org.springframework.beans.factory.annotation.Value;

import javax.annotation.Resource;

/**
 * Created by leiguorui on 2017/10/24.
 */
public class BaseTask implements Runnable{
    //执行时间间隔(秒)
    protected int period;

    @Override
    public void run() {

        while(true){

            action();

            if (period == 0){
                break;
            }

            try {
                Thread.sleep(period*1000);
            } catch (InterruptedException e) {
                //A thread cannot process an interrupt while it's sleeping.  restore interrupted status
                //当threadPoolTaskExecutor.shutdown()，会抛出这个异常，捕获之后结束循环
                Thread.currentThread().interrupt();
                break;
            }
        }
    }

    /**
     * 操作业务
     */
    public void action() {

    }
}
