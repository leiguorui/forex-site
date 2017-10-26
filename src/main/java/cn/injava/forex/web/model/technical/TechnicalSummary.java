package cn.injava.forex.web.model.technical;

import java.util.Map;

/**
 * 技术分析总览
 *
 * Created by leiguorui on 2017/10/27.
 */
public class TechnicalSummary {
    private String currency;
    private String Summary;
    /**
     * Map<时间, 买入卖出>
     */
    private Map<String, String> technical;

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getSummary() {
        return Summary;
    }

    public void setSummary(String summary) {
        Summary = summary;
    }

    public Map<String, String> getTechnical() {
        return technical;
    }

    public void setTechnical(Map<String, String> technical) {
        this.technical = technical;
    }
}
