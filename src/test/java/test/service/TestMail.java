package test.service;

import cn.injava.forex.core.schedul.task.SubPriceTask;
import cn.injava.forex.core.utils.HtmlUnit;
import cn.injava.forex.core.utils.MailUtil;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlDivision;
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
            page = webClient.getPage("http://m.investing.com/currencies/eur-usd-technical?period=3600");
            String maBuy = ((HtmlDivision)page.getByXPath("//p[@class='coloredBox']").get(0)).asText();
            System.out.println(maBuy);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test_subprice(){
        ApplicationContext context =
                new ClassPathXmlApplicationContext("spring-web-servlet.xml");

        SubPriceTask subPriceTask1 = (SubPriceTask) context.getBean("subPriceTask");
        SubPriceTask subPriceTask2 = (SubPriceTask) context.getBean("subPriceTask");

        System.out.println(subPriceTask1.toString());
        System.out.println(subPriceTask2.toString());
    }
}
