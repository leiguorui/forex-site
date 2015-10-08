package cn.injava.forex.web.model;

import org.joda.time.DateTime;

import java.math.BigDecimal;
import java.util.Map;

/**
 * 货币对
 *
 * Created by Administrator on 2015/7/3.
 */
public class Product {
    String productName;
    DateTime dateTime;
    // 买入价
    BigDecimal bid;
    // 卖出价
    BigDecimal ask;
    //涨跌幅
    BigDecimal change;

    /**
     * 技术分析
     * Integer   时段
     * Technical 该时段的技术分析
     */
    Map<Integer, Technical> technicals;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public DateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(DateTime dateTime) {
        this.dateTime = dateTime;
    }

    public BigDecimal getBid() {
        return bid;
    }

    public void setBid(BigDecimal bid) {
        this.bid = bid;
    }

    public BigDecimal getAsk() {
        return ask;
    }

    public void setAsk(BigDecimal ask) {
        this.ask = ask;
    }

    public BigDecimal getChange() {
        return change;
    }

    public void setChange(BigDecimal change) {
        this.change = change;
    }

    public Map<Integer, Technical> getTechnicals() {
        return technicals;
    }

    public void setTechnicals(Map<Integer, Technical> technicals) {
        this.technicals = technicals;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productName='" + productName + '\'' +
                ", dateTime=" + dateTime +
                ", bid=" + bid +
                ", ask=" + ask +
                ", change=" + change +
                ", technicals=" + technicals +
                '}';
    }
}
