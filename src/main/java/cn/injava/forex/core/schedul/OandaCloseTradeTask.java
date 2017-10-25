package cn.injava.forex.core.schedul;

import cn.injava.forex.core.utils.HtmlUnit;
import cn.injava.forex.web.model.News;
import cn.injava.forex.web.model.order.Order;
import cn.injava.forex.web.model.order.Trade;
import cn.injava.forex.web.service.NewsService;
import cn.injava.forex.web.service.TradeFxService;
import cn.injava.forex.web.service.order.OrderService;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.DomElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

/**
 * oanda.com 自动关闭订单
 */
@Component
public class OandaCloseTradeTask extends BaseTask{
    private static final Logger logger = LoggerFactory.getLogger(OandaCloseTradeTask.class);

    //执行时间间隔(秒)
    @Value("#{sysConfigProperties['oanda.close.period']}")
    private int period;

    @Resource
    private TradeFxService tradeFxService ;
    @Resource
    private OrderService orderService ;

    /**
     * 获取操作业务
     */
    @Override
    public void action() {

        super.period = period;

        logger.info("request for close");

        try {
            //盈利订单
            List<Integer> profitableId = tradeFxService.getProfitableOpenedTrades(new BigDecimal(0.1));

            for (Integer id : profitableId){
                tradeFxService.closeTrade(id);
                logger.info("close ---- " + id);
            }

            //亏损订单
            List<Integer> lossId = tradeFxService.getLossOpenedTrades(new BigDecimal(0.5));
            for (Integer id : lossId){
                // TODO: 2017/10/23 此处不要关闭订单, 而是反手做, 当反手做的也在亏损时, 则不在开仓
                Trade trade = tradeFxService.getTradeById(id);
                tradeFxService.closeTrade(id);
                tradeFxService.openTrade(trade.getCurrency(), -1*trade.getUnits());
                logger.info("close ---- " + id);
            }
        }catch (Exception e){
            logger.error(e.getMessage());
        }
    }
}
