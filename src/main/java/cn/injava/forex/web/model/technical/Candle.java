package cn.injava.forex.web.model.technical;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 蜡烛图
 *
 * Created by leiguorui on 2017/11/27.
 */
public class Candle {

    private int volume;
    private Date time;
    private String type;
    private BigDecimal o;
    private BigDecimal h;
    private BigDecimal l;
    private BigDecimal c;

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public BigDecimal getO() {
        return o;
    }

    public void setO(BigDecimal o) {
        this.o = o;
    }

    public BigDecimal getH() {
        return h;
    }

    public void setH(BigDecimal h) {
        this.h = h;
    }

    public BigDecimal getL() {
        return l;
    }

    public void setL(BigDecimal l) {
        this.l = l;
    }

    public BigDecimal getC() {
        return c;
    }

    public void setC(BigDecimal c) {
        this.c = c;
    }
}
