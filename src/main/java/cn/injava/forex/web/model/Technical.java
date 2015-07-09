package cn.injava.forex.web.model;

import cn.injava.forex.core.constant.SystemConstant;

/**
 * investing.com/currencies/eur-usd-technical?period=300 中
 * 技术面分析的一些字段
 */
public class Technical {
    private String produtcName;
    //k线图的时间段
    private int period;
    // Moving Averages buy count
    private String maBuy;
    private String maSell;
    // Technical Indicators
    private String tiBuy;
    private String tiSell;

    /**
     * 获取技术分析的结果
     * @return 买或卖
     */
    public String getTechSingle() {
        String summary = SystemConstant.TECH_NO_CLEAR_SINGLE;

        if ("(0)".equals(maBuy) && "(0)".equals(tiBuy)) {
            summary = SystemConstant.TECH_SELL;
        }

        if ("(0)".equals(maSell) && "(0)".equals(tiSell)) {
            summary = SystemConstant.TECH_BUY;
        }

        return summary;
    }

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

    public String getProdutcName() {
        return produtcName;
    }

    public void setProdutcName(String produtcName) {
        this.produtcName = produtcName;
    }

    public int getPeriod() {
        return period;
    }

    public void setPeriod(int period) {
        this.period = period;
    }

    @Override
    public String toString() {
        return "Technical{" +
                "produtcName='" + produtcName + '\'' +
                ", period=" + period +
                ", maBuy='" + maBuy + '\'' +
                ", maSell='" + maSell + '\'' +
                ", tiBuy='" + tiBuy + '\'' +
                ", tiSell='" + tiSell + '\'' +
                '}';
    }
}
