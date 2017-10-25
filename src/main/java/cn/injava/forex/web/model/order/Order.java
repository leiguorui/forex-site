package cn.injava.forex.web.model.order;

import java.math.BigDecimal;
import java.util.Date;

public class Order {
    private Integer id;

    private String currency;

    private String type;

    private Float lots;

    private Float profitPips;

    private BigDecimal openPrice;

    private Date openTime;

    private BigDecimal closePrice;

    private Date closeTime;

    private String tradingId;

    private String tradingPlatform;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency == null ? null : currency.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public Float getLots() {
        return lots;
    }

    public void setLots(Float lots) {
        this.lots = lots;
    }

    public Float getProfitPips() {
        return profitPips;
    }

    public void setProfitPips(Float profitPips) {
        this.profitPips = profitPips;
    }

    public BigDecimal getOpenPrice() {
        return openPrice;
    }

    public void setOpenPrice(BigDecimal openPrice) {
        this.openPrice = openPrice;
    }

    public Date getOpenTime() {
        return openTime;
    }

    public void setOpenTime(Date openTime) {
        this.openTime = openTime;
    }

    public BigDecimal getClosePrice() {
        return closePrice;
    }

    public void setClosePrice(BigDecimal closePrice) {
        this.closePrice = closePrice;
    }

    public Date getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(Date closeTime) {
        this.closeTime = closeTime;
    }

    public String getTradingId() {
        return tradingId;
    }

    public void setTradingId(String tradingId) {
        this.tradingId = tradingId == null ? null : tradingId.trim();
    }

    public String getTradingPlatform() {
        return tradingPlatform;
    }

    public void setTradingPlatform(String tradingPlatform) {
        this.tradingPlatform = tradingPlatform == null ? null : tradingPlatform.trim();
    }
}