package cn.injava.forex.core.schedul;

import cn.injava.forex.web.model.technical.Signal;
import cn.injava.forex.web.service.SmsService;
import cn.injava.forex.web.service.TradeFxService;
import cn.injava.forex.web.service.order.OrderService;
import cn.injava.forex.web.service.technical.SignalZulutradeService;
import cn.injava.forex.web.service.technical.TradeSignalService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
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
    @Resource
    private SignalZulutradeService signalZulutradeService;
    @Resource
    private OrderService orderService;

    /**
     * 获取操作业务
     */
    @Override
    public void action() {

        super.period = period;

        logger.info("request for open");

        try {
            List<Signal> signals = signalZulutradeService.getSignals();

            for (Signal signal : signals){

                tradeFxService.openTrade(signal.getCurrency(), Signal.SIGNAL_BUY.equals(signal.getSignal()) ? 1000 : -1000);

                logger.info("open ---- " + signal.toString());

                SmsService smsService = new SmsService();
                smsService.sendSms("【国瑞科技】"+signal.getCurrency()+"在"+signal.getPrice()+"可以看涨","17600666891", 2773);
            }
        }catch (Exception e){
            logger.error(e.getMessage());
        }
    }
}
