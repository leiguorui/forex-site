package cn.injava.forex.core.utils;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

/**
 * 访问页面工具
 *
 * Created by Administrator on 2015/6/25.
 */
public class HtmlUnit {
    private WebClient webClient = new WebClient(BrowserVersion.CHROME) ;

    /**
     * 获取速度最快的浏览器
     * @return
     */
    public WebClient getFastWebClient() {

        //TODO 这里可以启动webclient的ajax功能，读取技术指标的变化
        webClient.getOptions().setCssEnabled(false);//if you don't need css
        webClient.getOptions().setJavaScriptEnabled(false);//if you don't need js
        webClient.getOptions().setActiveXNative(false);
        webClient.getOptions().setAppletEnabled(false);
        webClient.getOptions().setGeolocationEnabled(false);
        webClient.getOptions().setDoNotTrackEnabled(true);
        webClient.getOptions().setThrowExceptionOnFailingStatusCode(false);
        webClient.getOptions().setPrintContentOnFailingStatusCode(false);

        return webClient;
    }
}
