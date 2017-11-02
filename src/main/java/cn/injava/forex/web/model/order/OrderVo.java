package cn.injava.forex.web.model.order;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by leiguorui on 2017/11/2.
 */
public class OrderVo extends TradingOrder{
    private BigDecimal maxProfit;
    private BigDecimal maxLoss;
    private String signalSrc;
    private String signalUser;
    private List<TradingPrice> tradingPrices;

    public BigDecimal getMaxProfit() {
        return maxProfit;
    }

    public void setMaxProfit(BigDecimal maxProfit) {
        this.maxProfit = maxProfit;
    }

    public BigDecimal getMaxLoss() {
        return maxLoss;
    }

    public void setMaxLoss(BigDecimal maxLoss) {
        this.maxLoss = maxLoss;
    }

    public String getSignalSrc() {
        return signalSrc;
    }

    public void setSignalSrc(String signalSrc) {
        this.signalSrc = signalSrc;
    }

    public String getSignalUser() {
        return signalUser;
    }

    public void setSignalUser(String signalUser) {
        this.signalUser = signalUser;
    }

    public List<TradingPrice> getTradingPrices() {
        return tradingPrices;
    }

    public void setTradingPrices(List<TradingPrice> tradingPrices) {
        this.tradingPrices = tradingPrices;

        maxProfit = new BigDecimal(-99999);
        maxLoss = new BigDecimal(99999);

        for (TradingPrice tradingPrice : tradingPrices){
            if (maxProfit.compareTo(tradingPrice.getProfitPrice()) == -1){
                maxProfit = tradingPrice.getProfitPrice();
            }

            if (maxLoss.compareTo(tradingPrice.getProfitPrice()) == 1){
                maxLoss = tradingPrice.getProfitPrice();
            }
        }

    }
}
