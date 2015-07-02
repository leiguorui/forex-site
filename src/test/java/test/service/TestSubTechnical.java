package test.service;

import cn.injava.forex.core.test.TestSupport;
import cn.injava.forex.web.service.SubTechnicalService;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;

public class TestSubTechnical extends TestSupport {
    @Resource
    private SubTechnicalService subTechnical;

    private static final Logger logger =
            LoggerFactory.getLogger(TestSubTechnical.class);

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
        logger.debug("welcome() is executed, value 1321");
        logger.info("welcome() is executed, value 1321 info");
        logger.debug("welcome() is executed, value {}", "mkyong");
        logger.error("This is Error message", new Exception("Testing"));
    }
}
