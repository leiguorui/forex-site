package cn.injava.forex.web.model.order;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 持有透彻
 *
 * Created by leiguorui on 2017/10/23.
 */
public class Trade {
    private String currency;
    private BigDecimal price;
    //持仓手数
    private int units;
    //盈利金额
    private BigDecimal pl;

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getUnits() {
        return units;
    }

    public void setUnits(int units) {
        this.units = units;
    }

    public BigDecimal getPl() {
        return pl;
    }

    public void setPl(BigDecimal pl) {
        this.pl = pl;
    }

    @Override
    public String toString() {
        return "Trade{" +
                "currency='" + currency + '\'' +
                ", price=" + price +
                ", units=" + units +
                ", pl=" + pl +
                '}';
    }
}
