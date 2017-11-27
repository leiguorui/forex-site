package test.service;

import cn.injava.forex.core.constant.SystemConstant;
import cn.injava.forex.core.test.TestSupport;
import cn.injava.forex.web.dao.CustomerDao;
import cn.injava.forex.web.model.Customer;
import cn.injava.forex.web.service.TradeFxService;
import org.junit.Test;

import javax.annotation.Resource;

/**
 * Created by Green Lei on 2015/7/20 10:11.
 */
public class ServiceDao extends TestSupport {
    @Resource
    private TradeFxService tradeFxService;

    @Test
    public void closeTrade() {
        tradeFxService.closeTrade(742);
    }

    @Test
    public void isInThreshold() {
        tradeFxService.isInThreshold("EUR_USD", SystemConstant.TRADE_TYPE_BUY);
    }


}
