package cn.injava.forex.core.schedul.task;

import cn.injava.forex.web.model.technical.TradingSignal;
import cn.injava.forex.web.service.SmsService;
import cn.injava.forex.web.service.TradeFxService;
import cn.injava.forex.web.service.order.OrderService;
import cn.injava.forex.web.service.technical.SignalHitraderService;
import cn.injava.forex.web.service.technical.SignalZulutradeService;
import cn.injava.forex.web.service.technical.TechnicalnvestingService;
import cn.injava.forex.web.service.technical.TradeSignalService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * oanda.com 自动下单
 */
@Component
public class OandaOpenTradeTask extends BaseTask {
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
    private SignalHitraderService signalHitraderService;
    @Resource
    private OrderService orderService;
    @Resource
    private TechnicalnvestingService technicalnvestingService;

    /**
     * 获取操作业务
     */
    @Override
    public void action() {

        super.period = period;

        logger.debug("request for open");

        try {
            List<TradingSignal> signals = signalZulutradeService.getSignals();
            signals.addAll(signalHitraderService.getSignals());

            for (TradingSignal signal : signals){

                //没有头寸, 且符合技术分析
                if (!tradeFxService.hasTrading(signal.getCurrency()) && signal.getProfitPrice() != null){

                    tradeFxService.openTrade(signal);

                    logger.info("open ---- " + signal.toString());

                }

            }
        }catch (Exception e){
            logger.error(e.getMessage());
        }
    }
}
