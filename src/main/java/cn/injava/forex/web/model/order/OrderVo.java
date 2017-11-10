package cn.injava.forex.web.model.order;

import java.math.BigDecimal;
import java.util.Iterator;
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

        maxProfit = new BigDecimal(-99999);
        maxLoss = new BigDecimal(99999);
        BigDecimal prePrice = null;

        for (Iterator<TradingPrice> iterator = tradingPrices.iterator(); iterator.hasNext(); ) {
            TradingPrice tradingPrice = iterator.next();

            //移除重复值
            if (prePrice != null && prePrice.compareTo(tradingPrice.getProfitPrice()) == 0){
                iterator.remove();
                continue;
            }else {
                prePrice = tradingPrice.getProfitPrice();
            }

            //设置最大值
            if (maxProfit.compareTo(prePrice) == -1){
                maxProfit = prePrice;
            }

            //设置最小值
            if (maxLoss.compareTo(prePrice) == 1){
                maxLoss = prePrice;
            }

            tradingPrice.setId(null);
            tradingPrice.setCreateTime(null);
            tradingPrice.setPlatform(null);
        }

        this.tradingPrices = tradingPrices;

    }
}
