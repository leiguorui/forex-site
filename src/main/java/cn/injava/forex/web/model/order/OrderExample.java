package cn.injava.forex.web.model.order;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OrderExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andCurrencyIsNull() {
            addCriterion("currency is null");
            return (Criteria) this;
        }

        public Criteria andCurrencyIsNotNull() {
            addCriterion("currency is not null");
            return (Criteria) this;
        }

        public Criteria andCurrencyEqualTo(String value) {
            addCriterion("currency =", value, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyNotEqualTo(String value) {
            addCriterion("currency <>", value, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyGreaterThan(String value) {
            addCriterion("currency >", value, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyGreaterThanOrEqualTo(String value) {
            addCriterion("currency >=", value, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyLessThan(String value) {
            addCriterion("currency <", value, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyLessThanOrEqualTo(String value) {
            addCriterion("currency <=", value, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyLike(String value) {
            addCriterion("currency like", value, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyNotLike(String value) {
            addCriterion("currency not like", value, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyIn(List<String> values) {
            addCriterion("currency in", values, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyNotIn(List<String> values) {
            addCriterion("currency not in", values, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyBetween(String value1, String value2) {
            addCriterion("currency between", value1, value2, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyNotBetween(String value1, String value2) {
            addCriterion("currency not between", value1, value2, "currency");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(String value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(String value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(String value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(String value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(String value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(String value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLike(String value) {
            addCriterion("type like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotLike(String value) {
            addCriterion("type not like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<String> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<String> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(String value1, String value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(String value1, String value2) {
            addCriterion("type not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andLotsIsNull() {
            addCriterion("lots is null");
            return (Criteria) this;
        }

        public Criteria andLotsIsNotNull() {
            addCriterion("lots is not null");
            return (Criteria) this;
        }

        public Criteria andLotsEqualTo(Float value) {
            addCriterion("lots =", value, "lots");
            return (Criteria) this;
        }

        public Criteria andLotsNotEqualTo(Float value) {
            addCriterion("lots <>", value, "lots");
            return (Criteria) this;
        }

        public Criteria andLotsGreaterThan(Float value) {
            addCriterion("lots >", value, "lots");
            return (Criteria) this;
        }

        public Criteria andLotsGreaterThanOrEqualTo(Float value) {
            addCriterion("lots >=", value, "lots");
            return (Criteria) this;
        }

        public Criteria andLotsLessThan(Float value) {
            addCriterion("lots <", value, "lots");
            return (Criteria) this;
        }

        public Criteria andLotsLessThanOrEqualTo(Float value) {
            addCriterion("lots <=", value, "lots");
            return (Criteria) this;
        }

        public Criteria andLotsIn(List<Float> values) {
            addCriterion("lots in", values, "lots");
            return (Criteria) this;
        }

        public Criteria andLotsNotIn(List<Float> values) {
            addCriterion("lots not in", values, "lots");
            return (Criteria) this;
        }

        public Criteria andLotsBetween(Float value1, Float value2) {
            addCriterion("lots between", value1, value2, "lots");
            return (Criteria) this;
        }

        public Criteria andLotsNotBetween(Float value1, Float value2) {
            addCriterion("lots not between", value1, value2, "lots");
            return (Criteria) this;
        }

        public Criteria andProfitPipsIsNull() {
            addCriterion("profit_pips is null");
            return (Criteria) this;
        }

        public Criteria andProfitPipsIsNotNull() {
            addCriterion("profit_pips is not null");
            return (Criteria) this;
        }

        public Criteria andProfitPipsEqualTo(Float value) {
            addCriterion("profit_pips =", value, "profitPips");
            return (Criteria) this;
        }

        public Criteria andProfitPipsNotEqualTo(Float value) {
            addCriterion("profit_pips <>", value, "profitPips");
            return (Criteria) this;
        }

        public Criteria andProfitPipsGreaterThan(Float value) {
            addCriterion("profit_pips >", value, "profitPips");
            return (Criteria) this;
        }

        public Criteria andProfitPipsGreaterThanOrEqualTo(Float value) {
            addCriterion("profit_pips >=", value, "profitPips");
            return (Criteria) this;
        }

        public Criteria andProfitPipsLessThan(Float value) {
            addCriterion("profit_pips <", value, "profitPips");
            return (Criteria) this;
        }

        public Criteria andProfitPipsLessThanOrEqualTo(Float value) {
            addCriterion("profit_pips <=", value, "profitPips");
            return (Criteria) this;
        }

        public Criteria andProfitPipsIn(List<Float> values) {
            addCriterion("profit_pips in", values, "profitPips");
            return (Criteria) this;
        }

        public Criteria andProfitPipsNotIn(List<Float> values) {
            addCriterion("profit_pips not in", values, "profitPips");
            return (Criteria) this;
        }

        public Criteria andProfitPipsBetween(Float value1, Float value2) {
            addCriterion("profit_pips between", value1, value2, "profitPips");
            return (Criteria) this;
        }

        public Criteria andProfitPipsNotBetween(Float value1, Float value2) {
            addCriterion("profit_pips not between", value1, value2, "profitPips");
            return (Criteria) this;
        }

        public Criteria andOpenPriceIsNull() {
            addCriterion("open_price is null");
            return (Criteria) this;
        }

        public Criteria andOpenPriceIsNotNull() {
            addCriterion("open_price is not null");
            return (Criteria) this;
        }

        public Criteria andOpenPriceEqualTo(BigDecimal value) {
            addCriterion("open_price =", value, "openPrice");
            return (Criteria) this;
        }

        public Criteria andOpenPriceNotEqualTo(BigDecimal value) {
            addCriterion("open_price <>", value, "openPrice");
            return (Criteria) this;
        }

        public Criteria andOpenPriceGreaterThan(BigDecimal value) {
            addCriterion("open_price >", value, "openPrice");
            return (Criteria) this;
        }

        public Criteria andOpenPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("open_price >=", value, "openPrice");
            return (Criteria) this;
        }

        public Criteria andOpenPriceLessThan(BigDecimal value) {
            addCriterion("open_price <", value, "openPrice");
            return (Criteria) this;
        }

        public Criteria andOpenPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("open_price <=", value, "openPrice");
            return (Criteria) this;
        }

        public Criteria andOpenPriceIn(List<BigDecimal> values) {
            addCriterion("open_price in", values, "openPrice");
            return (Criteria) this;
        }

        public Criteria andOpenPriceNotIn(List<BigDecimal> values) {
            addCriterion("open_price not in", values, "openPrice");
            return (Criteria) this;
        }

        public Criteria andOpenPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("open_price between", value1, value2, "openPrice");
            return (Criteria) this;
        }

        public Criteria andOpenPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("open_price not between", value1, value2, "openPrice");
            return (Criteria) this;
        }

        public Criteria andOpenTimeIsNull() {
            addCriterion("open_time is null");
            return (Criteria) this;
        }

        public Criteria andOpenTimeIsNotNull() {
            addCriterion("open_time is not null");
            return (Criteria) this;
        }

        public Criteria andOpenTimeEqualTo(Date value) {
            addCriterion("open_time =", value, "openTime");
            return (Criteria) this;
        }

        public Criteria andOpenTimeNotEqualTo(Date value) {
            addCriterion("open_time <>", value, "openTime");
            return (Criteria) this;
        }

        public Criteria andOpenTimeGreaterThan(Date value) {
            addCriterion("open_time >", value, "openTime");
            return (Criteria) this;
        }

        public Criteria andOpenTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("open_time >=", value, "openTime");
            return (Criteria) this;
        }

        public Criteria andOpenTimeLessThan(Date value) {
            addCriterion("open_time <", value, "openTime");
            return (Criteria) this;
        }

        public Criteria andOpenTimeLessThanOrEqualTo(Date value) {
            addCriterion("open_time <=", value, "openTime");
            return (Criteria) this;
        }

        public Criteria andOpenTimeIn(List<Date> values) {
            addCriterion("open_time in", values, "openTime");
            return (Criteria) this;
        }

        public Criteria andOpenTimeNotIn(List<Date> values) {
            addCriterion("open_time not in", values, "openTime");
            return (Criteria) this;
        }

        public Criteria andOpenTimeBetween(Date value1, Date value2) {
            addCriterion("open_time between", value1, value2, "openTime");
            return (Criteria) this;
        }

        public Criteria andOpenTimeNotBetween(Date value1, Date value2) {
            addCriterion("open_time not between", value1, value2, "openTime");
            return (Criteria) this;
        }

        public Criteria andClosePriceIsNull() {
            addCriterion("close_price is null");
            return (Criteria) this;
        }

        public Criteria andClosePriceIsNotNull() {
            addCriterion("close_price is not null");
            return (Criteria) this;
        }

        public Criteria andClosePriceEqualTo(BigDecimal value) {
            addCriterion("close_price =", value, "closePrice");
            return (Criteria) this;
        }

        public Criteria andClosePriceNotEqualTo(BigDecimal value) {
            addCriterion("close_price <>", value, "closePrice");
            return (Criteria) this;
        }

        public Criteria andClosePriceGreaterThan(BigDecimal value) {
            addCriterion("close_price >", value, "closePrice");
            return (Criteria) this;
        }

        public Criteria andClosePriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("close_price >=", value, "closePrice");
            return (Criteria) this;
        }

        public Criteria andClosePriceLessThan(BigDecimal value) {
            addCriterion("close_price <", value, "closePrice");
            return (Criteria) this;
        }

        public Criteria andClosePriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("close_price <=", value, "closePrice");
            return (Criteria) this;
        }

        public Criteria andClosePriceIn(List<BigDecimal> values) {
            addCriterion("close_price in", values, "closePrice");
            return (Criteria) this;
        }

        public Criteria andClosePriceNotIn(List<BigDecimal> values) {
            addCriterion("close_price not in", values, "closePrice");
            return (Criteria) this;
        }

        public Criteria andClosePriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("close_price between", value1, value2, "closePrice");
            return (Criteria) this;
        }

        public Criteria andClosePriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("close_price not between", value1, value2, "closePrice");
            return (Criteria) this;
        }

        public Criteria andCloseTimeIsNull() {
            addCriterion("close_time is null");
            return (Criteria) this;
        }

        public Criteria andCloseTimeIsNotNull() {
            addCriterion("close_time is not null");
            return (Criteria) this;
        }

        public Criteria andCloseTimeEqualTo(Date value) {
            addCriterion("close_time =", value, "closeTime");
            return (Criteria) this;
        }

        public Criteria andCloseTimeNotEqualTo(Date value) {
            addCriterion("close_time <>", value, "closeTime");
            return (Criteria) this;
        }

        public Criteria andCloseTimeGreaterThan(Date value) {
            addCriterion("close_time >", value, "closeTime");
            return (Criteria) this;
        }

        public Criteria andCloseTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("close_time >=", value, "closeTime");
            return (Criteria) this;
        }

        public Criteria andCloseTimeLessThan(Date value) {
            addCriterion("close_time <", value, "closeTime");
            return (Criteria) this;
        }

        public Criteria andCloseTimeLessThanOrEqualTo(Date value) {
            addCriterion("close_time <=", value, "closeTime");
            return (Criteria) this;
        }

        public Criteria andCloseTimeIn(List<Date> values) {
            addCriterion("close_time in", values, "closeTime");
            return (Criteria) this;
        }

        public Criteria andCloseTimeNotIn(List<Date> values) {
            addCriterion("close_time not in", values, "closeTime");
            return (Criteria) this;
        }

        public Criteria andCloseTimeBetween(Date value1, Date value2) {
            addCriterion("close_time between", value1, value2, "closeTime");
            return (Criteria) this;
        }

        public Criteria andCloseTimeNotBetween(Date value1, Date value2) {
            addCriterion("close_time not between", value1, value2, "closeTime");
            return (Criteria) this;
        }

        public Criteria andTradingIdIsNull() {
            addCriterion("trading_id is null");
            return (Criteria) this;
        }

        public Criteria andTradingIdIsNotNull() {
            addCriterion("trading_id is not null");
            return (Criteria) this;
        }

        public Criteria andTradingIdEqualTo(String value) {
            addCriterion("trading_id =", value, "tradingId");
            return (Criteria) this;
        }

        public Criteria andTradingIdNotEqualTo(String value) {
            addCriterion("trading_id <>", value, "tradingId");
            return (Criteria) this;
        }

        public Criteria andTradingIdGreaterThan(String value) {
            addCriterion("trading_id >", value, "tradingId");
            return (Criteria) this;
        }

        public Criteria andTradingIdGreaterThanOrEqualTo(String value) {
            addCriterion("trading_id >=", value, "tradingId");
            return (Criteria) this;
        }

        public Criteria andTradingIdLessThan(String value) {
            addCriterion("trading_id <", value, "tradingId");
            return (Criteria) this;
        }

        public Criteria andTradingIdLessThanOrEqualTo(String value) {
            addCriterion("trading_id <=", value, "tradingId");
            return (Criteria) this;
        }

        public Criteria andTradingIdLike(String value) {
            addCriterion("trading_id like", value, "tradingId");
            return (Criteria) this;
        }

        public Criteria andTradingIdNotLike(String value) {
            addCriterion("trading_id not like", value, "tradingId");
            return (Criteria) this;
        }

        public Criteria andTradingIdIn(List<String> values) {
            addCriterion("trading_id in", values, "tradingId");
            return (Criteria) this;
        }

        public Criteria andTradingIdNotIn(List<String> values) {
            addCriterion("trading_id not in", values, "tradingId");
            return (Criteria) this;
        }

        public Criteria andTradingIdBetween(String value1, String value2) {
            addCriterion("trading_id between", value1, value2, "tradingId");
            return (Criteria) this;
        }

        public Criteria andTradingIdNotBetween(String value1, String value2) {
            addCriterion("trading_id not between", value1, value2, "tradingId");
            return (Criteria) this;
        }

        public Criteria andTradingPlatformIsNull() {
            addCriterion("trading_platform is null");
            return (Criteria) this;
        }

        public Criteria andTradingPlatformIsNotNull() {
            addCriterion("trading_platform is not null");
            return (Criteria) this;
        }

        public Criteria andTradingPlatformEqualTo(String value) {
            addCriterion("trading_platform =", value, "tradingPlatform");
            return (Criteria) this;
        }

        public Criteria andTradingPlatformNotEqualTo(String value) {
            addCriterion("trading_platform <>", value, "tradingPlatform");
            return (Criteria) this;
        }

        public Criteria andTradingPlatformGreaterThan(String value) {
            addCriterion("trading_platform >", value, "tradingPlatform");
            return (Criteria) this;
        }

        public Criteria andTradingPlatformGreaterThanOrEqualTo(String value) {
            addCriterion("trading_platform >=", value, "tradingPlatform");
            return (Criteria) this;
        }

        public Criteria andTradingPlatformLessThan(String value) {
            addCriterion("trading_platform <", value, "tradingPlatform");
            return (Criteria) this;
        }

        public Criteria andTradingPlatformLessThanOrEqualTo(String value) {
            addCriterion("trading_platform <=", value, "tradingPlatform");
            return (Criteria) this;
        }

        public Criteria andTradingPlatformLike(String value) {
            addCriterion("trading_platform like", value, "tradingPlatform");
            return (Criteria) this;
        }

        public Criteria andTradingPlatformNotLike(String value) {
            addCriterion("trading_platform not like", value, "tradingPlatform");
            return (Criteria) this;
        }

        public Criteria andTradingPlatformIn(List<String> values) {
            addCriterion("trading_platform in", values, "tradingPlatform");
            return (Criteria) this;
        }

        public Criteria andTradingPlatformNotIn(List<String> values) {
            addCriterion("trading_platform not in", values, "tradingPlatform");
            return (Criteria) this;
        }

        public Criteria andTradingPlatformBetween(String value1, String value2) {
            addCriterion("trading_platform between", value1, value2, "tradingPlatform");
            return (Criteria) this;
        }

        public Criteria andTradingPlatformNotBetween(String value1, String value2) {
            addCriterion("trading_platform not between", value1, value2, "tradingPlatform");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}