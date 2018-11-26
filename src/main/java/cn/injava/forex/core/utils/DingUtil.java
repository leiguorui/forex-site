package cn.injava.forex.core.utils;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.Charset;

/**
 * 实例DingUtil
 *
 * @author 雷国瑞
 * @version 1.0
 * @since 2018-09-21 16:29:35
 */
public class DingUtil {
    private static final String DINGDING_URL = "https://oapi.dingtalk.com/robot/send?access_token=02b5ec8733c23af6ba52bec83cb67e14b9a52c5f2c2c23437a2958e0b5df5d25";

    private DingUtil() {
    }

    public static String sendMsg(String msg){
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters()
                .add(0, new StringHttpMessageConverter(Charset.forName("UTF-8")));

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> entity = new HttpEntity<String>(msg, headers);
        return restTemplate.postForObject(DINGDING_URL, entity, String.class);
    }
}
