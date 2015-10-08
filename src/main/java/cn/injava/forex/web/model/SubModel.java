package cn.injava.forex.web.model;

import java.math.BigDecimal;

/**
 * 订阅者的参数
 *
 * Created by Administrator on 2015/6/30.
 */
public class SubModel {
    private String email;
    private String product;
    private BigDecimal price;
    //订阅一个时段的技术指标
    private int period;
    //订阅多个时段的技术指标
    private int[] periods;
    //订阅类型
    private String subType;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getPeriod() {
        return period;
    }

    public void setPeriod(int period) {
        this.period = period;
    }

    public String getSubType() {
        return subType;
    }

    public void setSubType(String subType) {
        this.subType = subType;
    }

    public int[] getPeriods() {
        return periods;
    }

    public void setPeriods(int[] periods) {
        this.periods = periods;
    }
}
