package cn.injava.forex.web.model.technical;

/**
 * 交易信号
 *
 * Created by leiguorui on 2017/10/23.
 */
public class Signal {

    public static String SIGNAL_BUY = "BUY";
    public static String SIGNAL_SELL = "SELL";

    //格式 USD_CAD
    private String currency;

    // buy sell
    private String signal;

    //交易价格
    private double price;

    //信号强度 1-5
    private int intensity;

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getSignal() {
        return signal;
    }

    public void setSignal(String signal) {
        this.signal = signal;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getIntensity() {
        return intensity;
    }

    public void setIntensity(int intensity) {
        this.intensity = intensity;
    }

    @Override
    public String toString() {
        return "Signal{" +
                "currency='" + currency + '\'' +
                ", technical='" + signal + '\'' +
                ", price=" + price +
                ", intensity=" + intensity +
                '}';
    }
}
