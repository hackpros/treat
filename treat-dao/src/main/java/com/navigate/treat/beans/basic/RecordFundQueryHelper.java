/*
 * RecordFundQueryHelper.java
 * Copyright(C) 20xx-2015 掌航科技网络公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-04-12 Created
 */
package com.navigate.treat.beans.basic;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RecordFundQueryHelper {

    protected String orderByClause;
    protected boolean distinct;
    protected List<Criteria> oredCriteria;

    public RecordFundQueryHelper() {
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

    /**
     * 资金记录表
     * 
     * @author 掌航
     * @version 1.0 2016-04-12
     */
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
        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }
        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }
        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }
        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }
        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }
        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }
        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }
        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }
        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }
        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }
        public Criteria andUserIdIsNull() {
            addCriterion("userId is null");
            return (Criteria) this;
        }
        public Criteria andUserIdIsNotNull() {
            addCriterion("userId is not null");
            return (Criteria) this;
        }
        public Criteria andUserIdEqualTo(Long value) {
            addCriterion("userId =", value, "userId");
            return (Criteria) this;
        }
        public Criteria andUserIdNotEqualTo(Long value) {
            addCriterion("userId <>", value, "userId");
            return (Criteria) this;
        }
        public Criteria andUserIdGreaterThan(Long value) {
            addCriterion("userId >", value, "userId");
            return (Criteria) this;
        }
        public Criteria andUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("userId >=", value, "userId");
            return (Criteria) this;
        }
        public Criteria andUserIdLessThan(Long value) {
            addCriterion("userId <", value, "userId");
            return (Criteria) this;
        }
        public Criteria andUserIdLessThanOrEqualTo(Long value) {
            addCriterion("userId <=", value, "userId");
            return (Criteria) this;
        }
        public Criteria andUserIdIn(List<Long> values) {
            addCriterion("userId in", values, "userId");
            return (Criteria) this;
        }
        public Criteria andUserIdNotIn(List<Long> values) {
            addCriterion("userId not in", values, "userId");
            return (Criteria) this;
        }
        public Criteria andUserIdBetween(Long value1, Long value2) {
            addCriterion("userId between", value1, value2, "userId");
            return (Criteria) this;
        }
        public Criteria andUserIdNotBetween(Long value1, Long value2) {
            addCriterion("userId not between", value1, value2, "userId");
            return (Criteria) this;
        }
        public Criteria andAmountIsNull() {
            addCriterion("amount is null");
            return (Criteria) this;
        }
        public Criteria andAmountIsNotNull() {
            addCriterion("amount is not null");
            return (Criteria) this;
        }
        public Criteria andAmountEqualTo(BigDecimal value) {
            addCriterion("amount =", value, "amount");
            return (Criteria) this;
        }
        public Criteria andAmountNotEqualTo(BigDecimal value) {
            addCriterion("amount <>", value, "amount");
            return (Criteria) this;
        }
        public Criteria andAmountGreaterThan(BigDecimal value) {
            addCriterion("amount >", value, "amount");
            return (Criteria) this;
        }
        public Criteria andAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("amount >=", value, "amount");
            return (Criteria) this;
        }
        public Criteria andAmountLessThan(BigDecimal value) {
            addCriterion("amount <", value, "amount");
            return (Criteria) this;
        }
        public Criteria andAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("amount <=", value, "amount");
            return (Criteria) this;
        }
        public Criteria andAmountIn(List<BigDecimal> values) {
            addCriterion("amount in", values, "amount");
            return (Criteria) this;
        }
        public Criteria andAmountNotIn(List<BigDecimal> values) {
            addCriterion("amount not in", values, "amount");
            return (Criteria) this;
        }
        public Criteria andAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("amount between", value1, value2, "amount");
            return (Criteria) this;
        }
        public Criteria andAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("amount not between", value1, value2, "amount");
            return (Criteria) this;
        }
        public Criteria andCtimeIsNull() {
            addCriterion("ctime is null");
            return (Criteria) this;
        }
        public Criteria andCtimeIsNotNull() {
            addCriterion("ctime is not null");
            return (Criteria) this;
        }
        public Criteria andCtimeEqualTo(Date value) {
            addCriterion("ctime =", value, "ctime");
            return (Criteria) this;
        }
        public Criteria andCtimeNotEqualTo(Date value) {
            addCriterion("ctime <>", value, "ctime");
            return (Criteria) this;
        }
        public Criteria andCtimeGreaterThan(Date value) {
            addCriterion("ctime >", value, "ctime");
            return (Criteria) this;
        }
        public Criteria andCtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("ctime >=", value, "ctime");
            return (Criteria) this;
        }
        public Criteria andCtimeLessThan(Date value) {
            addCriterion("ctime <", value, "ctime");
            return (Criteria) this;
        }
        public Criteria andCtimeLessThanOrEqualTo(Date value) {
            addCriterion("ctime <=", value, "ctime");
            return (Criteria) this;
        }
        public Criteria andCtimeIn(List<Date> values) {
            addCriterion("ctime in", values, "ctime");
            return (Criteria) this;
        }
        public Criteria andCtimeNotIn(List<Date> values) {
            addCriterion("ctime not in", values, "ctime");
            return (Criteria) this;
        }
        public Criteria andCtimeBetween(Date value1, Date value2) {
            addCriterion("ctime between", value1, value2, "ctime");
            return (Criteria) this;
        }
        public Criteria andCtimeNotBetween(Date value1, Date value2) {
            addCriterion("ctime not between", value1, value2, "ctime");
            return (Criteria) this;
        }
        public Criteria andPlusMinusIsNull() {
            addCriterion("plusMinus is null");
            return (Criteria) this;
        }
        public Criteria andPlusMinusIsNotNull() {
            addCriterion("plusMinus is not null");
            return (Criteria) this;
        }
        public Criteria andPlusMinusEqualTo(Integer value) {
            addCriterion("plusMinus =", value, "plusMinus");
            return (Criteria) this;
        }
        public Criteria andPlusMinusNotEqualTo(Integer value) {
            addCriterion("plusMinus <>", value, "plusMinus");
            return (Criteria) this;
        }
        public Criteria andPlusMinusGreaterThan(Integer value) {
            addCriterion("plusMinus >", value, "plusMinus");
            return (Criteria) this;
        }
        public Criteria andPlusMinusGreaterThanOrEqualTo(Integer value) {
            addCriterion("plusMinus >=", value, "plusMinus");
            return (Criteria) this;
        }
        public Criteria andPlusMinusLessThan(Integer value) {
            addCriterion("plusMinus <", value, "plusMinus");
            return (Criteria) this;
        }
        public Criteria andPlusMinusLessThanOrEqualTo(Integer value) {
            addCriterion("plusMinus <=", value, "plusMinus");
            return (Criteria) this;
        }
        public Criteria andPlusMinusIn(List<Integer> values) {
            addCriterion("plusMinus in", values, "plusMinus");
            return (Criteria) this;
        }
        public Criteria andPlusMinusNotIn(List<Integer> values) {
            addCriterion("plusMinus not in", values, "plusMinus");
            return (Criteria) this;
        }
        public Criteria andPlusMinusBetween(Integer value1, Integer value2) {
            addCriterion("plusMinus between", value1, value2, "plusMinus");
            return (Criteria) this;
        }
        public Criteria andPlusMinusNotBetween(Integer value1, Integer value2) {
            addCriterion("plusMinus not between", value1, value2, "plusMinus");
            return (Criteria) this;
        }
        public Criteria andOutTradeNoIsNull() {
            addCriterion("outTradeNo is null");
            return (Criteria) this;
        }
        public Criteria andOutTradeNoIsNotNull() {
            addCriterion("outTradeNo is not null");
            return (Criteria) this;
        }
        public Criteria andOutTradeNoEqualTo(String value) {
            addCriterion("outTradeNo =", value, "outTradeNo");
            return (Criteria) this;
        }
        public Criteria andOutTradeNoNotEqualTo(String value) {
            addCriterion("outTradeNo <>", value, "outTradeNo");
            return (Criteria) this;
        }
        public Criteria andOutTradeNoGreaterThan(String value) {
            addCriterion("outTradeNo >", value, "outTradeNo");
            return (Criteria) this;
        }
        public Criteria andOutTradeNoGreaterThanOrEqualTo(String value) {
            addCriterion("outTradeNo >=", value, "outTradeNo");
            return (Criteria) this;
        }
        public Criteria andOutTradeNoLessThan(String value) {
            addCriterion("outTradeNo <", value, "outTradeNo");
            return (Criteria) this;
        }
        public Criteria andOutTradeNoLessThanOrEqualTo(String value) {
            addCriterion("outTradeNo <=", value, "outTradeNo");
            return (Criteria) this;
        }
        public Criteria andOutTradeNoLike(String value) {
            addCriterion("outTradeNo like", value, "outTradeNo");
            return (Criteria) this;
        }
        public Criteria andOutTradeNoNotLike(String value) {
            addCriterion("outTradeNo not like", value, "outTradeNo");
            return (Criteria) this;
        }
        public Criteria andOutTradeNoIn(List<String> values) {
            addCriterion("outTradeNo in", values, "outTradeNo");
            return (Criteria) this;
        }
        public Criteria andOutTradeNoNotIn(List<String> values) {
            addCriterion("outTradeNo not in", values, "outTradeNo");
            return (Criteria) this;
        }
        public Criteria andOutTradeNoBetween(String value1, String value2) {
            addCriterion("outTradeNo between", value1, value2, "outTradeNo");
            return (Criteria) this;
        }
        public Criteria andOutTradeNoNotBetween(String value1, String value2) {
            addCriterion("outTradeNo not between", value1, value2, "outTradeNo");
            return (Criteria) this;
        }
        public Criteria andSellerIdIsNull() {
            addCriterion("sellerId is null");
            return (Criteria) this;
        }
        public Criteria andSellerIdIsNotNull() {
            addCriterion("sellerId is not null");
            return (Criteria) this;
        }
        public Criteria andSellerIdEqualTo(String value) {
            addCriterion("sellerId =", value, "sellerId");
            return (Criteria) this;
        }
        public Criteria andSellerIdNotEqualTo(String value) {
            addCriterion("sellerId <>", value, "sellerId");
            return (Criteria) this;
        }
        public Criteria andSellerIdGreaterThan(String value) {
            addCriterion("sellerId >", value, "sellerId");
            return (Criteria) this;
        }
        public Criteria andSellerIdGreaterThanOrEqualTo(String value) {
            addCriterion("sellerId >=", value, "sellerId");
            return (Criteria) this;
        }
        public Criteria andSellerIdLessThan(String value) {
            addCriterion("sellerId <", value, "sellerId");
            return (Criteria) this;
        }
        public Criteria andSellerIdLessThanOrEqualTo(String value) {
            addCriterion("sellerId <=", value, "sellerId");
            return (Criteria) this;
        }
        public Criteria andSellerIdLike(String value) {
            addCriterion("sellerId like", value, "sellerId");
            return (Criteria) this;
        }
        public Criteria andSellerIdNotLike(String value) {
            addCriterion("sellerId not like", value, "sellerId");
            return (Criteria) this;
        }
        public Criteria andSellerIdIn(List<String> values) {
            addCriterion("sellerId in", values, "sellerId");
            return (Criteria) this;
        }
        public Criteria andSellerIdNotIn(List<String> values) {
            addCriterion("sellerId not in", values, "sellerId");
            return (Criteria) this;
        }
        public Criteria andSellerIdBetween(String value1, String value2) {
            addCriterion("sellerId between", value1, value2, "sellerId");
            return (Criteria) this;
        }
        public Criteria andSellerIdNotBetween(String value1, String value2) {
            addCriterion("sellerId not between", value1, value2, "sellerId");
            return (Criteria) this;
        }
        public Criteria andDescriptionsIsNull() {
            addCriterion("descriptions is null");
            return (Criteria) this;
        }
        public Criteria andDescriptionsIsNotNull() {
            addCriterion("descriptions is not null");
            return (Criteria) this;
        }
        public Criteria andDescriptionsEqualTo(String value) {
            addCriterion("descriptions =", value, "descriptions");
            return (Criteria) this;
        }
        public Criteria andDescriptionsNotEqualTo(String value) {
            addCriterion("descriptions <>", value, "descriptions");
            return (Criteria) this;
        }
        public Criteria andDescriptionsGreaterThan(String value) {
            addCriterion("descriptions >", value, "descriptions");
            return (Criteria) this;
        }
        public Criteria andDescriptionsGreaterThanOrEqualTo(String value) {
            addCriterion("descriptions >=", value, "descriptions");
            return (Criteria) this;
        }
        public Criteria andDescriptionsLessThan(String value) {
            addCriterion("descriptions <", value, "descriptions");
            return (Criteria) this;
        }
        public Criteria andDescriptionsLessThanOrEqualTo(String value) {
            addCriterion("descriptions <=", value, "descriptions");
            return (Criteria) this;
        }
        public Criteria andDescriptionsLike(String value) {
            addCriterion("descriptions like", value, "descriptions");
            return (Criteria) this;
        }
        public Criteria andDescriptionsNotLike(String value) {
            addCriterion("descriptions not like", value, "descriptions");
            return (Criteria) this;
        }
        public Criteria andDescriptionsIn(List<String> values) {
            addCriterion("descriptions in", values, "descriptions");
            return (Criteria) this;
        }
        public Criteria andDescriptionsNotIn(List<String> values) {
            addCriterion("descriptions not in", values, "descriptions");
            return (Criteria) this;
        }
        public Criteria andDescriptionsBetween(String value1, String value2) {
            addCriterion("descriptions between", value1, value2, "descriptions");
            return (Criteria) this;
        }
        public Criteria andDescriptionsNotBetween(String value1, String value2) {
            addCriterion("descriptions not between", value1, value2, "descriptions");
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
        public Criteria andTypeEqualTo(Integer value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }
        public Criteria andTypeNotEqualTo(Integer value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }
        public Criteria andTypeGreaterThan(Integer value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }
        public Criteria andTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }
        public Criteria andTypeLessThan(Integer value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }
        public Criteria andTypeLessThanOrEqualTo(Integer value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }
        public Criteria andTypeIn(List<Integer> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }
        public Criteria andTypeNotIn(List<Integer> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }
        public Criteria andTypeBetween(Integer value1, Integer value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }
        public Criteria andTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("type not between", value1, value2, "type");
            return (Criteria) this;
        }
        public Criteria andOutTradeNoLikeInsensitive(String value) {
            addCriterion("upper(outTradeNo) like", value.toUpperCase(), "outTradeNo");
            return (Criteria) this;
        }
        public Criteria andSellerIdLikeInsensitive(String value) {
            addCriterion("upper(sellerId) like", value.toUpperCase(), "sellerId");
            return (Criteria) this;
        }
        public Criteria andDescriptionsLikeInsensitive(String value) {
            addCriterion("upper(descriptions) like", value.toUpperCase(), "descriptions");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {


        protected Criteria() {
            super();
        }
    }

    /**
     * 资金记录表
     * 
     * @author 掌航
     * @version 1.0 2016-04-12
     */
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