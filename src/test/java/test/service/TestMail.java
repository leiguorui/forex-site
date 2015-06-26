package test.service;

import cn.injava.forex.core.utils.MailUtil;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Administrator on 2015/6/25.
 */
public class TestMail {
    @Test
    public void test_mail(){
        ApplicationContext context =
                new ClassPathXmlApplicationContext("spring-web-servlet.xml");

        MailUtil mm = (MailUtil) context.getBean("mailUtil");
        mm.sendMail("green_forex@163.com",
                "green_forex@163.com",
                "Testing123",
                "Testing only \n\n Hello Spring Email Sender");
    }
}
