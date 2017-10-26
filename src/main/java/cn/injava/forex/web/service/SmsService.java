package cn.injava.forex.web.service;

import cn.injava.forex.core.utils.HtmlUnit;
import com.gargoylesoftware.htmlunit.HttpMethod;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.WebRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URL;
import java.net.URLEncoder;

/**
 * 短信服务
 *
 * Created by leiguorui on 2017/10/24.
 */
@Service
public class SmsService {
    private static final Logger logger = LoggerFactory.getLogger(SmsService.class);

    public int sendSms(String content, String mobile, int tplId){
        final WebClient webClient = new HtmlUnit().getGeneralWebClient();
        int result = 0;
        try {
            URL url = new URL("http://apis.haoservice.com/sms/sendv2/");
            WebRequest requestSettings = new WebRequest(url, HttpMethod.POST);

            requestSettings.setAdditionalHeader("Content-Type", "application/x-www-form-urlencoded");

            requestSettings.setRequestBody("key=bc0a7b18577f429f932eea97b52db071&mobile=17600666891&tpl_id="+tplId+"&content="+
                    URLEncoder.encode(content, "UTF-8"));
            String response = webClient.getPage(requestSettings).getWebResponse().getContentAsString();

            if(response.contains("成功")){
                result = 1;
            }else {
                logger.error("send fail sms: "+mobile);
                logger.error("send fail sms reason: " + response);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            webClient.close();
        }

        return result;
    }
}
