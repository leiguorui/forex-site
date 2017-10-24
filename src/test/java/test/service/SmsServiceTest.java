package test.service;

import cn.injava.forex.web.service.SmsService;

/**
 * Created by leiguorui on 2017/10/24.
 */
public class SmsServiceTest {
    public static void main(String[] args) {
        SmsService smsService = new SmsService();

        smsService.sendSms("【国瑞科技】USD_JPY在2.6589可以看涨","17600666891", 2773);

    }
}
