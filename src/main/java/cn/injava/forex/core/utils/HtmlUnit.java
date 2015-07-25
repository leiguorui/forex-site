package cn.injava.forex.core.utils;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;

/**
 * 访问页面工具
 *
 * Created by Administrator on 2015/6/25.
 */
@Component
public class HtmlUnit {
    private WebClient webClient;

    /**
     * 获取速度最快的浏览器
     * @return
     */
    public WebClient getFastWebClient() {
        webClient = new WebClient(BrowserVersion.CHROME);

        //TODO 这里可以启动webclient的ajax功能，读取技术指标的变化
        webClient.getOptions().setCssEnabled(false);//if you don't need css
        webClient.getOptions().setJavaScriptEnabled(false);//if you don't need js
        webClient.getOptions().setActiveXNative(false);
        webClient.getOptions().setAppletEnabled(false);
        webClient.getOptions().setGeolocationEnabled(false);
//        webClient.getOptions().setDoNotTrackEnabled(true);  //不追踪隐私
        webClient.getOptions().setThrowExceptionOnFailingStatusCode(false);  //页面有错，不抛出异常
        webClient.getOptions().setPrintContentOnFailingStatusCode(false);    //页面有错，不打印

        return webClient;
    }
}
