package test.service;

import cn.injava.forex.core.test.TestSupport;
import cn.injava.forex.web.service.SubTechnicalService;
import org.junit.Test;

import javax.annotation.Resource;

public class TestSubTechnical extends TestSupport {
    @Resource
    private SubTechnicalService subTechnical;

    @Test
    public void test_sub() {
        start();
        subTechnical.subTechnical( "eur-usd", 60);
        end();
    }

    @Test
    public void test_service() {
        start();
        subTechnical.subByEmailAsync("green_forex@163.com", "eur-usd", 60);
        end();
    }

    @Test
    public void test_se() {
        System.out.println("你好");
    }
}
