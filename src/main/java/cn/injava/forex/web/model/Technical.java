package cn.injava.forex.web.model;

/**
 * investing.com/currencies/eur-usd-technical?period=300 中
 * 技术面分析的一些字段
 */
public class Technical {
    // Moving Averages buy count
    private String maBuy;
    private String maSell;
    // Technical Indicators
    private String tiBuy;
    private String tiSell;

    public String getMaBuy() {
        return maBuy;
    }

    public void setMaBuy(String maBuy) {
        this.maBuy = maBuy;
    }

    public String getMaSell() {
        return maSell;
    }

    public void setMaSell(String maSell) {
        this.maSell = maSell;
    }

    public String getTiBuy() {
        return tiBuy;
    }

    public void setTiBuy(String tiBuy) {
        this.tiBuy = tiBuy;
    }

    public String getTiSell() {
        return tiSell;
    }

    public void setTiSell(String tiSell) {
        this.tiSell = tiSell;
    }
}
