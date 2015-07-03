package test.service;

import cn.injava.forex.core.utils.HtmlUnit;
import cn.injava.forex.core.utils.MailUtil;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

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

    @Test
    public void test_htmlUnit(){
        ApplicationContext context =
                new ClassPathXmlApplicationContext("spring-web-servlet.xml");

        HtmlUnit htmlUnit = (HtmlUnit) context.getBean("htmlUnit");
        final WebClient webClient = htmlUnit.getFastWebClient();
        final HtmlPage page;
        try {
            page = webClient.getPage("http://www.investing.com/currencies/eur-usd-technical?period=300");
            String maBuy = page.getHtmlElementById("maBuy").asText();
            System.out.println(maBuy);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
