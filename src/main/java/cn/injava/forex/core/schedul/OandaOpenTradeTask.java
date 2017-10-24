package cn.injava.forex.core.schedul;

import cn.injava.forex.web.model.order.Trade;
import cn.injava.forex.web.model.technical.Signal;
import cn.injava.forex.web.service.TradeFxService;
import cn.injava.forex.web.service.TradeSignalService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;

/**
 * oanda.com 自动下单
 */
@Component
public class OandaOpenTradeTask extends BaseTask{
    private static final Logger logger = LoggerFactory.getLogger(OandaOpenTradeTask.class);

    //执行时间间隔(秒)
    @Value("#{sysConfigProperties['oanda.open.period']}")
    private int period;

    @Resource
    private TradeFxService tradeFxService ;
    @Resource
    private TradeSignalService tradeSignalService;

    /**
     * 获取操作业务
     */
    public void action() {

        super.period = period;

        logger.info("request for open");

        try {
            List<Signal> signals = tradeSignalService.getSignals();

            for (Signal signal : signals){

                if (Signal.SIGNAL_BUY.equals(signal.getSignal())){
                    tradeFxService.openTrade(signal.getCurrency(), 1000);
                }else {
                    tradeFxService.openTrade(signal.getCurrency(), -1000);
                }

                logger.info("open ---- " + signal.toString());
            }
        }catch (Exception e){
            logger.error(e.getMessage());
        }
    }
}
