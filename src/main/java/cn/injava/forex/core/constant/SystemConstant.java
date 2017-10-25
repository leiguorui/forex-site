package cn.injava.forex.core.constant;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *  系统常量
 *
 * Created by Administrator on 2015/7/1.
 */
public class SystemConstant {
    /**
     * 订阅者类型
     */
    final public static String sub_price = "订阅报价";
    final public static String sub_technical = "订阅技术指标";

    /**
     * 技术指标的信号
     */
    final public static String TECH_BUY = "买入";
    final public static String TECH_SELL = "卖出";
    final public static String TECH_NO_CLEAR_SINGLE = "没有明确信号";

    /**
     * session中的值
     */
    final public static String S_USER = "session_user";

    /**
     * 主流货币对
     */
    final public static List<String> MAJOR_CURRENCES = new ArrayList<String>() {
        {
            add("AUD_USD");
            add("EUR_USD");
            add("GBP_USD");
            add("NZD_USD");
            add("USD_CAD");
            add("USD_CHF");
            add("USD_JPY");
        }
    };

    /**
     * 服务商
     */
    final public static String BROKER_OANDA = "oanda";

    /**
     * 交易类型
     */
    final public static String TRADE_TYPE_BUY = "BUY";
    final public static String TRADE_TYPE_SELL = "SELL";
}
