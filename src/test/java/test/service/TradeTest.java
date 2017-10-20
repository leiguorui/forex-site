package test.service;

import cn.injava.forex.core.test.TestSupport;
import cn.injava.forex.web.dao.CustomerDao;
import cn.injava.forex.web.service.TradeFxService;
import org.junit.Test;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * Created by leiguorui on 2017/10/20.
 */
public class TradeTest extends TestSupport {

    @Resource
    private TradeFxService fxService;

    @Test
    public void getOpenedTrades() {
        fxService.getOpenedTrades();
    }

    @Test
    public void openTrade() {
        fxService.openTrade("GBP_USD", -100);
    }

    @Test
    public void closeTrade() {
        fxService.closeTrade(71);
    }

    @Test
    public void getProfitableOpenedTrades() {
        fxService.getProfitableOpenedTrades(new BigDecimal(0.75	));
    }
}
