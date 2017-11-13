package cn.injava.forex.core.schedul.task;

import cn.injava.forex.web.service.TradeFxService;
import cn.injava.forex.web.service.order.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * oanda.com 自动关闭订单
 */
@Component
public class OandaCloseTradeTask extends BaseTask {
    private static final Logger logger = LoggerFactory.getLogger(OandaCloseTradeTask.class);

    //执行时间间隔(秒)
    @Value("#{sysConfigProperties['oanda.close.period']}")
    private int period;

    @Resource
    private TradeFxService tradeFxService ;
    @Resource
    private OrderService orderService ;

    @Resource(name = "getSystemConfig")
    private Map<String, String> systemConfig;

    /**
     * 获取操作业务
     */
    @Override
    public void action() {

        super.period = period;

        logger.debug("request for close");

        try {

            List<Integer> orderIds = tradeFxService.getStopLossTrades();

            for (Integer id : orderIds){
                tradeFxService.closeTrade(id);
                logger.info("close ---- " + id);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
