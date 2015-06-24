package test.service;

import cn.injava.forex.core.TestSupport;
import cn.injava.forex.web.service.SubPriceService;
import org.junit.Test;

import javax.annotation.Resource;

public class TestSubPrice extends TestSupport {
    @Resource
    private SubPriceService subPriceService;

    @Test
    public void test_sub() {
        start();
        while(true){
            try {
                Thread.sleep(1000); // Waiting before run.
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (subPriceService.subPrice("degreelei@gmail.com", "EURUSD", 1.1203)){
                break;
            }
        }
        end();
    }
}
