package test.service;

import cn.injava.forex.core.test.TestSupport;
import cn.injava.forex.web.service.SubPriceService;
import cn.injava.forex.web.service.SubTechnical;
import org.junit.Test;

import javax.annotation.Resource;

public class TestSubTechnical extends TestSupport {
    @Resource
    private SubTechnical subTechnical;

    @Test
    public void test_sub() {
        start();
        subTechnical.subTechnical( "eur-usd", 60);
        end();
    }
}
