/*
 * ActivitysQueryHelper.java
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

public class ActivitysQueryHelper {

    protected String orderByClause;
    protected boolean distinct;
    protected List<Criteria> oredCriteria;

    public ActivitysQueryHelper() {
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
     * 
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
        public Criteria andThemeIsNull() {
            addCriterion("theme is null");
            return (Criteria) this;
        }
        public Criteria andThemeIsNotNull() {
            addCriterion("theme is not null");
            return (Criteria) this;
        }
        public Criteria andThemeEqualTo(String value) {
            addCriterion("theme =", value, "theme");
            return (Criteria) this;
        }
        public Criteria andThemeNotEqualTo(String value) {
            addCriterion("theme <>", value, "theme");
            return (Criteria) this;
        }
        public Criteria andThemeGreaterThan(String value) {
            addCriterion("theme >", value, "theme");
            return (Criteria) this;
        }
        public Criteria andThemeGreaterThanOrEqualTo(String value) {
            addCriterion("theme >=", value, "theme");
            return (Criteria) this;
        }
        public Criteria andThemeLessThan(String value) {
            addCriterion("theme <", value, "theme");
            return (Criteria) this;
        }
        public Criteria andThemeLessThanOrEqualTo(String value) {
            addCriterion("theme <=", value, "theme");
            return (Criteria) this;
        }
        public Criteria andThemeLike(String value) {
            addCriterion("theme like", value, "theme");
            return (Criteria) this;
        }
        public Criteria andThemeNotLike(String value) {
            addCriterion("theme not like", value, "theme");
            return (Criteria) this;
        }
        public Criteria andThemeIn(List<String> values) {
            addCriterion("theme in", values, "theme");
            return (Criteria) this;
        }
        public Criteria andThemeNotIn(List<String> values) {
            addCriterion("theme not in", values, "theme");
            return (Criteria) this;
        }
        public Criteria andThemeBetween(String value1, String value2) {
            addCriterion("theme between", value1, value2, "theme");
            return (Criteria) this;
        }
        public Criteria andThemeNotBetween(String value1, String value2) {
            addCriterion("theme not between", value1, value2, "theme");
            return (Criteria) this;
        }
        public Criteria andTreatWayIsNull() {
            addCriterion("treatWay is null");
            return (Criteria) this;
        }
        public Criteria andTreatWayIsNotNull() {
            addCriterion("treatWay is not null");
            return (Criteria) this;
        }
        public Criteria andTreatWayEqualTo(Integer value) {
            addCriterion("treatWay =", value, "treatWay");
            return (Criteria) this;
        }
        public Criteria andTreatWayNotEqualTo(Integer value) {
            addCriterion("treatWay <>", value, "treatWay");
            return (Criteria) this;
        }
        public Criteria andTreatWayGreaterThan(Integer value) {
            addCriterion("treatWay >", value, "treatWay");
            return (Criteria) this;
        }
        public Criteria andTreatWayGreaterThanOrEqualTo(Integer value) {
            addCriterion("treatWay >=", value, "treatWay");
            return (Criteria) this;
        }
        public Criteria andTreatWayLessThan(Integer value) {
            addCriterion("treatWay <", value, "treatWay");
            return (Criteria) this;
        }
        public Criteria andTreatWayLessThanOrEqualTo(Integer value) {
            addCriterion("treatWay <=", value, "treatWay");
            return (Criteria) this;
        }
        public Criteria andTreatWayIn(List<Integer> values) {
            addCriterion("treatWay in", values, "treatWay");
            return (Criteria) this;
        }
        public Criteria andTreatWayNotIn(List<Integer> values) {
            addCriterion("treatWay not in", values, "treatWay");
            return (Criteria) this;
        }
        public Criteria andTreatWayBetween(Integer value1, Integer value2) {
            addCriterion("treatWay between", value1, value2, "treatWay");
            return (Criteria) this;
        }
        public Criteria andTreatWayNotBetween(Integer value1, Integer value2) {
            addCriterion("treatWay not between", value1, value2, "treatWay");
            return (Criteria) this;
        }
        public Criteria andActTimeIsNull() {
            addCriterion("actTime is null");
            return (Criteria) this;
        }
        public Criteria andActTimeIsNotNull() {
            addCriterion("actTime is not null");
            return (Criteria) this;
        }
        public Criteria andActTimeEqualTo(Date value) {
            addCriterion("actTime =", value, "actTime");
            return (Criteria) this;
        }
        public Criteria andActTimeNotEqualTo(Date value) {
            addCriterion("actTime <>", value, "actTime");
            return (Criteria) this;
        }
        public Criteria andActTimeGreaterThan(Date value) {
            addCriterion("actTime >", value, "actTime");
            return (Criteria) this;
        }
        public Criteria andActTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("actTime >=", value, "actTime");
            return (Criteria) this;
        }
        public Criteria andActTimeLessThan(Date value) {
            addCriterion("actTime <", value, "actTime");
            return (Criteria) this;
        }
        public Criteria andActTimeLessThanOrEqualTo(Date value) {
            addCriterion("actTime <=", value, "actTime");
            return (Criteria) this;
        }
        public Criteria andActTimeIn(List<Date> values) {
            addCriterion("actTime in", values, "actTime");
            return (Criteria) this;
        }
        public Criteria andActTimeNotIn(List<Date> values) {
            addCriterion("actTime not in", values, "actTime");
            return (Criteria) this;
        }
        public Criteria andActTimeBetween(Date value1, Date value2) {
            addCriterion("actTime between", value1, value2, "actTime");
            return (Criteria) this;
        }
        public Criteria andActTimeNotBetween(Date value1, Date value2) {
            addCriterion("actTime not between", value1, value2, "actTime");
            return (Criteria) this;
        }
        public Criteria andAmountSecuredIsNull() {
            addCriterion("amountSecured is null");
            return (Criteria) this;
        }
        public Criteria andAmountSecuredIsNotNull() {
            addCriterion("amountSecured is not null");
            return (Criteria) this;
        }
        public Criteria andAmountSecuredEqualTo(BigDecimal value) {
            addCriterion("amountSecured =", value, "amountSecured");
            return (Criteria) this;
        }
        public Criteria andAmountSecuredNotEqualTo(BigDecimal value) {
            addCriterion("amountSecured <>", value, "amountSecured");
            return (Criteria) this;
        }
        public Criteria andAmountSecuredGreaterThan(BigDecimal value) {
            addCriterion("amountSecured >", value, "amountSecured");
            return (Criteria) this;
        }
        public Criteria andAmountSecuredGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("amountSecured >=", value, "amountSecured");
            return (Criteria) this;
        }
        public Criteria andAmountSecuredLessThan(BigDecimal value) {
            addCriterion("amountSecured <", value, "amountSecured");
            return (Criteria) this;
        }
        public Criteria andAmountSecuredLessThanOrEqualTo(BigDecimal value) {
            addCriterion("amountSecured <=", value, "amountSecured");
            return (Criteria) this;
        }
        public Criteria andAmountSecuredIn(List<BigDecimal> values) {
            addCriterion("amountSecured in", values, "amountSecured");
            return (Criteria) this;
        }
        public Criteria andAmountSecuredNotIn(List<BigDecimal> values) {
            addCriterion("amountSecured not in", values, "amountSecured");
            return (Criteria) this;
        }
        public Criteria andAmountSecuredBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("amountSecured between", value1, value2, "amountSecured");
            return (Criteria) this;
        }
        public Criteria andAmountSecuredNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("amountSecured not between", value1, value2, "amountSecured");
            return (Criteria) this;
        }
        public Criteria andSubsidiesIsNull() {
            addCriterion("subsidies is null");
            return (Criteria) this;
        }
        public Criteria andSubsidiesIsNotNull() {
            addCriterion("subsidies is not null");
            return (Criteria) this;
        }
        public Criteria andSubsidiesEqualTo(BigDecimal value) {
            addCriterion("subsidies =", value, "subsidies");
            return (Criteria) this;
        }
        public Criteria andSubsidiesNotEqualTo(BigDecimal value) {
            addCriterion("subsidies <>", value, "subsidies");
            return (Criteria) this;
        }
        public Criteria andSubsidiesGreaterThan(BigDecimal value) {
            addCriterion("subsidies >", value, "subsidies");
            return (Criteria) this;
        }
        public Criteria andSubsidiesGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("subsidies >=", value, "subsidies");
            return (Criteria) this;
        }
        public Criteria andSubsidiesLessThan(BigDecimal value) {
            addCriterion("subsidies <", value, "subsidies");
            return (Criteria) this;
        }
        public Criteria andSubsidiesLessThanOrEqualTo(BigDecimal value) {
            addCriterion("subsidies <=", value, "subsidies");
            return (Criteria) this;
        }
        public Criteria andSubsidiesIn(List<BigDecimal> values) {
            addCriterion("subsidies in", values, "subsidies");
            return (Criteria) this;
        }
        public Criteria andSubsidiesNotIn(List<BigDecimal> values) {
            addCriterion("subsidies not in", values, "subsidies");
            return (Criteria) this;
        }
        public Criteria andSubsidiesBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("subsidies between", value1, value2, "subsidies");
            return (Criteria) this;
        }
        public Criteria andSubsidiesNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("subsidies not between", value1, value2, "subsidies");
            return (Criteria) this;
        }
        public Criteria andBriefDescIsNull() {
            addCriterion("briefDesc is null");
            return (Criteria) this;
        }
        public Criteria andBriefDescIsNotNull() {
            addCriterion("briefDesc is not null");
            return (Criteria) this;
        }
        public Criteria andBriefDescEqualTo(String value) {
            addCriterion("briefDesc =", value, "briefDesc");
            return (Criteria) this;
        }
        public Criteria andBriefDescNotEqualTo(String value) {
            addCriterion("briefDesc <>", value, "briefDesc");
            return (Criteria) this;
        }
        public Criteria andBriefDescGreaterThan(String value) {
            addCriterion("briefDesc >", value, "briefDesc");
            return (Criteria) this;
        }
        public Criteria andBriefDescGreaterThanOrEqualTo(String value) {
            addCriterion("briefDesc >=", value, "briefDesc");
            return (Criteria) this;
        }
        public Criteria andBriefDescLessThan(String value) {
            addCriterion("briefDesc <", value, "briefDesc");
            return (Criteria) this;
        }
        public Criteria andBriefDescLessThanOrEqualTo(String value) {
            addCriterion("briefDesc <=", value, "briefDesc");
            return (Criteria) this;
        }
        public Criteria andBriefDescLike(String value) {
            addCriterion("briefDesc like", value, "briefDesc");
            return (Criteria) this;
        }
        public Criteria andBriefDescNotLike(String value) {
            addCriterion("briefDesc not like", value, "briefDesc");
            return (Criteria) this;
        }
        public Criteria andBriefDescIn(List<String> values) {
            addCriterion("briefDesc in", values, "briefDesc");
            return (Criteria) this;
        }
        public Criteria andBriefDescNotIn(List<String> values) {
            addCriterion("briefDesc not in", values, "briefDesc");
            return (Criteria) this;
        }
        public Criteria andBriefDescBetween(String value1, String value2) {
            addCriterion("briefDesc between", value1, value2, "briefDesc");
            return (Criteria) this;
        }
        public Criteria andBriefDescNotBetween(String value1, String value2) {
            addCriterion("briefDesc not between", value1, value2, "briefDesc");
            return (Criteria) this;
        }
        public Criteria andMtimeIsNull() {
            addCriterion("mtime is null");
            return (Criteria) this;
        }
        public Criteria andMtimeIsNotNull() {
            addCriterion("mtime is not null");
            return (Criteria) this;
        }
        public Criteria andMtimeEqualTo(Date value) {
            addCriterion("mtime =", value, "mtime");
            return (Criteria) this;
        }
        public Criteria andMtimeNotEqualTo(Date value) {
            addCriterion("mtime <>", value, "mtime");
            return (Criteria) this;
        }
        public Criteria andMtimeGreaterThan(Date value) {
            addCriterion("mtime >", value, "mtime");
            return (Criteria) this;
        }
        public Criteria andMtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("mtime >=", value, "mtime");
            return (Criteria) this;
        }
        public Criteria andMtimeLessThan(Date value) {
            addCriterion("mtime <", value, "mtime");
            return (Criteria) this;
        }
        public Criteria andMtimeLessThanOrEqualTo(Date value) {
            addCriterion("mtime <=", value, "mtime");
            return (Criteria) this;
        }
        public Criteria andMtimeIn(List<Date> values) {
            addCriterion("mtime in", values, "mtime");
            return (Criteria) this;
        }
        public Criteria andMtimeNotIn(List<Date> values) {
            addCriterion("mtime not in", values, "mtime");
            return (Criteria) this;
        }
        public Criteria andMtimeBetween(Date value1, Date value2) {
            addCriterion("mtime between", value1, value2, "mtime");
            return (Criteria) this;
        }
        public Criteria andMtimeNotBetween(Date value1, Date value2) {
            addCriterion("mtime not between", value1, value2, "mtime");
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
        public Criteria andActStatusIsNull() {
            addCriterion("actStatus is null");
            return (Criteria) this;
        }
        public Criteria andActStatusIsNotNull() {
            addCriterion("actStatus is not null");
            return (Criteria) this;
        }
        public Criteria andActStatusEqualTo(Integer value) {
            addCriterion("actStatus =", value, "actStatus");
            return (Criteria) this;
        }
        public Criteria andActStatusNotEqualTo(Integer value) {
            addCriterion("actStatus <>", value, "actStatus");
            return (Criteria) this;
        }
        public Criteria andActStatusGreaterThan(Integer value) {
            addCriterion("actStatus >", value, "actStatus");
            return (Criteria) this;
        }
        public Criteria andActStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("actStatus >=", value, "actStatus");
            return (Criteria) this;
        }
        public Criteria andActStatusLessThan(Integer value) {
            addCriterion("actStatus <", value, "actStatus");
            return (Criteria) this;
        }
        public Criteria andActStatusLessThanOrEqualTo(Integer value) {
            addCriterion("actStatus <=", value, "actStatus");
            return (Criteria) this;
        }
        public Criteria andActStatusIn(List<Integer> values) {
            addCriterion("actStatus in", values, "actStatus");
            return (Criteria) this;
        }
        public Criteria andActStatusNotIn(List<Integer> values) {
            addCriterion("actStatus not in", values, "actStatus");
            return (Criteria) this;
        }
        public Criteria andActStatusBetween(Integer value1, Integer value2) {
            addCriterion("actStatus between", value1, value2, "actStatus");
            return (Criteria) this;
        }
        public Criteria andActStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("actStatus not between", value1, value2, "actStatus");
            return (Criteria) this;
        }
        public Criteria andBizIdIsNull() {
            addCriterion("bizId is null");
            return (Criteria) this;
        }
        public Criteria andBizIdIsNotNull() {
            addCriterion("bizId is not null");
            return (Criteria) this;
        }
        public Criteria andBizIdEqualTo(Long value) {
            addCriterion("bizId =", value, "bizId");
            return (Criteria) this;
        }
        public Criteria andBizIdNotEqualTo(Long value) {
            addCriterion("bizId <>", value, "bizId");
            return (Criteria) this;
        }
        public Criteria andBizIdGreaterThan(Long value) {
            addCriterion("bizId >", value, "bizId");
            return (Criteria) this;
        }
        public Criteria andBizIdGreaterThanOrEqualTo(Long value) {
            addCriterion("bizId >=", value, "bizId");
            return (Criteria) this;
        }
        public Criteria andBizIdLessThan(Long value) {
            addCriterion("bizId <", value, "bizId");
            return (Criteria) this;
        }
        public Criteria andBizIdLessThanOrEqualTo(Long value) {
            addCriterion("bizId <=", value, "bizId");
            return (Criteria) this;
        }
        public Criteria andBizIdIn(List<Long> values) {
            addCriterion("bizId in", values, "bizId");
            return (Criteria) this;
        }
        public Criteria andBizIdNotIn(List<Long> values) {
            addCriterion("bizId not in", values, "bizId");
            return (Criteria) this;
        }
        public Criteria andBizIdBetween(Long value1, Long value2) {
            addCriterion("bizId between", value1, value2, "bizId");
            return (Criteria) this;
        }
        public Criteria andBizIdNotBetween(Long value1, Long value2) {
            addCriterion("bizId not between", value1, value2, "bizId");
            return (Criteria) this;
        }
        public Criteria andBizNameIsNull() {
            addCriterion("bizName is null");
            return (Criteria) this;
        }
        public Criteria andBizNameIsNotNull() {
            addCriterion("bizName is not null");
            return (Criteria) this;
        }
        public Criteria andBizNameEqualTo(String value) {
            addCriterion("bizName =", value, "bizName");
            return (Criteria) this;
        }
        public Criteria andBizNameNotEqualTo(String value) {
            addCriterion("bizName <>", value, "bizName");
            return (Criteria) this;
        }
        public Criteria andBizNameGreaterThan(String value) {
            addCriterion("bizName >", value, "bizName");
            return (Criteria) this;
        }
        public Criteria andBizNameGreaterThanOrEqualTo(String value) {
            addCriterion("bizName >=", value, "bizName");
            return (Criteria) this;
        }
        public Criteria andBizNameLessThan(String value) {
            addCriterion("bizName <", value, "bizName");
            return (Criteria) this;
        }
        public Criteria andBizNameLessThanOrEqualTo(String value) {
            addCriterion("bizName <=", value, "bizName");
            return (Criteria) this;
        }
        public Criteria andBizNameLike(String value) {
            addCriterion("bizName like", value, "bizName");
            return (Criteria) this;
        }
        public Criteria andBizNameNotLike(String value) {
            addCriterion("bizName not like", value, "bizName");
            return (Criteria) this;
        }
        public Criteria andBizNameIn(List<String> values) {
            addCriterion("bizName in", values, "bizName");
            return (Criteria) this;
        }
        public Criteria andBizNameNotIn(List<String> values) {
            addCriterion("bizName not in", values, "bizName");
            return (Criteria) this;
        }
        public Criteria andBizNameBetween(String value1, String value2) {
            addCriterion("bizName between", value1, value2, "bizName");
            return (Criteria) this;
        }
        public Criteria andBizNameNotBetween(String value1, String value2) {
            addCriterion("bizName not between", value1, value2, "bizName");
            return (Criteria) this;
        }
        public Criteria andBizAddrIsNull() {
            addCriterion("bizAddr is null");
            return (Criteria) this;
        }
        public Criteria andBizAddrIsNotNull() {
            addCriterion("bizAddr is not null");
            return (Criteria) this;
        }
        public Criteria andBizAddrEqualTo(String value) {
            addCriterion("bizAddr =", value, "bizAddr");
            return (Criteria) this;
        }
        public Criteria andBizAddrNotEqualTo(String value) {
            addCriterion("bizAddr <>", value, "bizAddr");
            return (Criteria) this;
        }
        public Criteria andBizAddrGreaterThan(String value) {
            addCriterion("bizAddr >", value, "bizAddr");
            return (Criteria) this;
        }
        public Criteria andBizAddrGreaterThanOrEqualTo(String value) {
            addCriterion("bizAddr >=", value, "bizAddr");
            return (Criteria) this;
        }
        public Criteria andBizAddrLessThan(String value) {
            addCriterion("bizAddr <", value, "bizAddr");
            return (Criteria) this;
        }
        public Criteria andBizAddrLessThanOrEqualTo(String value) {
            addCriterion("bizAddr <=", value, "bizAddr");
            return (Criteria) this;
        }
        public Criteria andBizAddrLike(String value) {
            addCriterion("bizAddr like", value, "bizAddr");
            return (Criteria) this;
        }
        public Criteria andBizAddrNotLike(String value) {
            addCriterion("bizAddr not like", value, "bizAddr");
            return (Criteria) this;
        }
        public Criteria andBizAddrIn(List<String> values) {
            addCriterion("bizAddr in", values, "bizAddr");
            return (Criteria) this;
        }
        public Criteria andBizAddrNotIn(List<String> values) {
            addCriterion("bizAddr not in", values, "bizAddr");
            return (Criteria) this;
        }
        public Criteria andBizAddrBetween(String value1, String value2) {
            addCriterion("bizAddr between", value1, value2, "bizAddr");
            return (Criteria) this;
        }
        public Criteria andBizAddrNotBetween(String value1, String value2) {
            addCriterion("bizAddr not between", value1, value2, "bizAddr");
            return (Criteria) this;
        }
        public Criteria andBizIconIsNull() {
            addCriterion("bizIcon is null");
            return (Criteria) this;
        }
        public Criteria andBizIconIsNotNull() {
            addCriterion("bizIcon is not null");
            return (Criteria) this;
        }
        public Criteria andBizIconEqualTo(String value) {
            addCriterion("bizIcon =", value, "bizIcon");
            return (Criteria) this;
        }
        public Criteria andBizIconNotEqualTo(String value) {
            addCriterion("bizIcon <>", value, "bizIcon");
            return (Criteria) this;
        }
        public Criteria andBizIconGreaterThan(String value) {
            addCriterion("bizIcon >", value, "bizIcon");
            return (Criteria) this;
        }
        public Criteria andBizIconGreaterThanOrEqualTo(String value) {
            addCriterion("bizIcon >=", value, "bizIcon");
            return (Criteria) this;
        }
        public Criteria andBizIconLessThan(String value) {
            addCriterion("bizIcon <", value, "bizIcon");
            return (Criteria) this;
        }
        public Criteria andBizIconLessThanOrEqualTo(String value) {
            addCriterion("bizIcon <=", value, "bizIcon");
            return (Criteria) this;
        }
        public Criteria andBizIconLike(String value) {
            addCriterion("bizIcon like", value, "bizIcon");
            return (Criteria) this;
        }
        public Criteria andBizIconNotLike(String value) {
            addCriterion("bizIcon not like", value, "bizIcon");
            return (Criteria) this;
        }
        public Criteria andBizIconIn(List<String> values) {
            addCriterion("bizIcon in", values, "bizIcon");
            return (Criteria) this;
        }
        public Criteria andBizIconNotIn(List<String> values) {
            addCriterion("bizIcon not in", values, "bizIcon");
            return (Criteria) this;
        }
        public Criteria andBizIconBetween(String value1, String value2) {
            addCriterion("bizIcon between", value1, value2, "bizIcon");
            return (Criteria) this;
        }
        public Criteria andBizIconNotBetween(String value1, String value2) {
            addCriterion("bizIcon not between", value1, value2, "bizIcon");
            return (Criteria) this;
        }
        public Criteria andBizCategoryIsNull() {
            addCriterion("bizCategory is null");
            return (Criteria) this;
        }
        public Criteria andBizCategoryIsNotNull() {
            addCriterion("bizCategory is not null");
            return (Criteria) this;
        }
        public Criteria andBizCategoryEqualTo(String value) {
            addCriterion("bizCategory =", value, "bizCategory");
            return (Criteria) this;
        }
        public Criteria andBizCategoryNotEqualTo(String value) {
            addCriterion("bizCategory <>", value, "bizCategory");
            return (Criteria) this;
        }
        public Criteria andBizCategoryGreaterThan(String value) {
            addCriterion("bizCategory >", value, "bizCategory");
            return (Criteria) this;
        }
        public Criteria andBizCategoryGreaterThanOrEqualTo(String value) {
            addCriterion("bizCategory >=", value, "bizCategory");
            return (Criteria) this;
        }
        public Criteria andBizCategoryLessThan(String value) {
            addCriterion("bizCategory <", value, "bizCategory");
            return (Criteria) this;
        }
        public Criteria andBizCategoryLessThanOrEqualTo(String value) {
            addCriterion("bizCategory <=", value, "bizCategory");
            return (Criteria) this;
        }
        public Criteria andBizCategoryLike(String value) {
            addCriterion("bizCategory like", value, "bizCategory");
            return (Criteria) this;
        }
        public Criteria andBizCategoryNotLike(String value) {
            addCriterion("bizCategory not like", value, "bizCategory");
            return (Criteria) this;
        }
        public Criteria andBizCategoryIn(List<String> values) {
            addCriterion("bizCategory in", values, "bizCategory");
            return (Criteria) this;
        }
        public Criteria andBizCategoryNotIn(List<String> values) {
            addCriterion("bizCategory not in", values, "bizCategory");
            return (Criteria) this;
        }
        public Criteria andBizCategoryBetween(String value1, String value2) {
            addCriterion("bizCategory between", value1, value2, "bizCategory");
            return (Criteria) this;
        }
        public Criteria andBizCategoryNotBetween(String value1, String value2) {
            addCriterion("bizCategory not between", value1, value2, "bizCategory");
            return (Criteria) this;
        }
        public Criteria andBizLngIsNull() {
            addCriterion("bizLng is null");
            return (Criteria) this;
        }
        public Criteria andBizLngIsNotNull() {
            addCriterion("bizLng is not null");
            return (Criteria) this;
        }
        public Criteria andBizLngEqualTo(String value) {
            addCriterion("bizLng =", value, "bizLng");
            return (Criteria) this;
        }
        public Criteria andBizLngNotEqualTo(String value) {
            addCriterion("bizLng <>", value, "bizLng");
            return (Criteria) this;
        }
        public Criteria andBizLngGreaterThan(String value) {
            addCriterion("bizLng >", value, "bizLng");
            return (Criteria) this;
        }
        public Criteria andBizLngGreaterThanOrEqualTo(String value) {
            addCriterion("bizLng >=", value, "bizLng");
            return (Criteria) this;
        }
        public Criteria andBizLngLessThan(String value) {
            addCriterion("bizLng <", value, "bizLng");
            return (Criteria) this;
        }
        public Criteria andBizLngLessThanOrEqualTo(String value) {
            addCriterion("bizLng <=", value, "bizLng");
            return (Criteria) this;
        }
        public Criteria andBizLngLike(String value) {
            addCriterion("bizLng like", value, "bizLng");
            return (Criteria) this;
        }
        public Criteria andBizLngNotLike(String value) {
            addCriterion("bizLng not like", value, "bizLng");
            return (Criteria) this;
        }
        public Criteria andBizLngIn(List<String> values) {
            addCriterion("bizLng in", values, "bizLng");
            return (Criteria) this;
        }
        public Criteria andBizLngNotIn(List<String> values) {
            addCriterion("bizLng not in", values, "bizLng");
            return (Criteria) this;
        }
        public Criteria andBizLngBetween(String value1, String value2) {
            addCriterion("bizLng between", value1, value2, "bizLng");
            return (Criteria) this;
        }
        public Criteria andBizLngNotBetween(String value1, String value2) {
            addCriterion("bizLng not between", value1, value2, "bizLng");
            return (Criteria) this;
        }
        public Criteria andBizLatIsNull() {
            addCriterion("bizLat is null");
            return (Criteria) this;
        }
        public Criteria andBizLatIsNotNull() {
            addCriterion("bizLat is not null");
            return (Criteria) this;
        }
        public Criteria andBizLatEqualTo(String value) {
            addCriterion("bizLat =", value, "bizLat");
            return (Criteria) this;
        }
        public Criteria andBizLatNotEqualTo(String value) {
            addCriterion("bizLat <>", value, "bizLat");
            return (Criteria) this;
        }
        public Criteria andBizLatGreaterThan(String value) {
            addCriterion("bizLat >", value, "bizLat");
            return (Criteria) this;
        }
        public Criteria andBizLatGreaterThanOrEqualTo(String value) {
            addCriterion("bizLat >=", value, "bizLat");
            return (Criteria) this;
        }
        public Criteria andBizLatLessThan(String value) {
            addCriterion("bizLat <", value, "bizLat");
            return (Criteria) this;
        }
        public Criteria andBizLatLessThanOrEqualTo(String value) {
            addCriterion("bizLat <=", value, "bizLat");
            return (Criteria) this;
        }
        public Criteria andBizLatLike(String value) {
            addCriterion("bizLat like", value, "bizLat");
            return (Criteria) this;
        }
        public Criteria andBizLatNotLike(String value) {
            addCriterion("bizLat not like", value, "bizLat");
            return (Criteria) this;
        }
        public Criteria andBizLatIn(List<String> values) {
            addCriterion("bizLat in", values, "bizLat");
            return (Criteria) this;
        }
        public Criteria andBizLatNotIn(List<String> values) {
            addCriterion("bizLat not in", values, "bizLat");
            return (Criteria) this;
        }
        public Criteria andBizLatBetween(String value1, String value2) {
            addCriterion("bizLat between", value1, value2, "bizLat");
            return (Criteria) this;
        }
        public Criteria andBizLatNotBetween(String value1, String value2) {
            addCriterion("bizLat not between", value1, value2, "bizLat");
            return (Criteria) this;
        }
        public Criteria andBizRateIsNull() {
            addCriterion("bizRate is null");
            return (Criteria) this;
        }
        public Criteria andBizRateIsNotNull() {
            addCriterion("bizRate is not null");
            return (Criteria) this;
        }
        public Criteria andBizRateEqualTo(String value) {
            addCriterion("bizRate =", value, "bizRate");
            return (Criteria) this;
        }
        public Criteria andBizRateNotEqualTo(String value) {
            addCriterion("bizRate <>", value, "bizRate");
            return (Criteria) this;
        }
        public Criteria andBizRateGreaterThan(String value) {
            addCriterion("bizRate >", value, "bizRate");
            return (Criteria) this;
        }
        public Criteria andBizRateGreaterThanOrEqualTo(String value) {
            addCriterion("bizRate >=", value, "bizRate");
            return (Criteria) this;
        }
        public Criteria andBizRateLessThan(String value) {
            addCriterion("bizRate <", value, "bizRate");
            return (Criteria) this;
        }
        public Criteria andBizRateLessThanOrEqualTo(String value) {
            addCriterion("bizRate <=", value, "bizRate");
            return (Criteria) this;
        }
        public Criteria andBizRateLike(String value) {
            addCriterion("bizRate like", value, "bizRate");
            return (Criteria) this;
        }
        public Criteria andBizRateNotLike(String value) {
            addCriterion("bizRate not like", value, "bizRate");
            return (Criteria) this;
        }
        public Criteria andBizRateIn(List<String> values) {
            addCriterion("bizRate in", values, "bizRate");
            return (Criteria) this;
        }
        public Criteria andBizRateNotIn(List<String> values) {
            addCriterion("bizRate not in", values, "bizRate");
            return (Criteria) this;
        }
        public Criteria andBizRateBetween(String value1, String value2) {
            addCriterion("bizRate between", value1, value2, "bizRate");
            return (Criteria) this;
        }
        public Criteria andBizRateNotBetween(String value1, String value2) {
            addCriterion("bizRate not between", value1, value2, "bizRate");
            return (Criteria) this;
        }
        public Criteria andBizAvgIsNull() {
            addCriterion("bizAvg is null");
            return (Criteria) this;
        }
        public Criteria andBizAvgIsNotNull() {
            addCriterion("bizAvg is not null");
            return (Criteria) this;
        }
        public Criteria andBizAvgEqualTo(String value) {
            addCriterion("bizAvg =", value, "bizAvg");
            return (Criteria) this;
        }
        public Criteria andBizAvgNotEqualTo(String value) {
            addCriterion("bizAvg <>", value, "bizAvg");
            return (Criteria) this;
        }
        public Criteria andBizAvgGreaterThan(String value) {
            addCriterion("bizAvg >", value, "bizAvg");
            return (Criteria) this;
        }
        public Criteria andBizAvgGreaterThanOrEqualTo(String value) {
            addCriterion("bizAvg >=", value, "bizAvg");
            return (Criteria) this;
        }
        public Criteria andBizAvgLessThan(String value) {
            addCriterion("bizAvg <", value, "bizAvg");
            return (Criteria) this;
        }
        public Criteria andBizAvgLessThanOrEqualTo(String value) {
            addCriterion("bizAvg <=", value, "bizAvg");
            return (Criteria) this;
        }
        public Criteria andBizAvgLike(String value) {
            addCriterion("bizAvg like", value, "bizAvg");
            return (Criteria) this;
        }
        public Criteria andBizAvgNotLike(String value) {
            addCriterion("bizAvg not like", value, "bizAvg");
            return (Criteria) this;
        }
        public Criteria andBizAvgIn(List<String> values) {
            addCriterion("bizAvg in", values, "bizAvg");
            return (Criteria) this;
        }
        public Criteria andBizAvgNotIn(List<String> values) {
            addCriterion("bizAvg not in", values, "bizAvg");
            return (Criteria) this;
        }
        public Criteria andBizAvgBetween(String value1, String value2) {
            addCriterion("bizAvg between", value1, value2, "bizAvg");
            return (Criteria) this;
        }
        public Criteria andBizAvgNotBetween(String value1, String value2) {
            addCriterion("bizAvg not between", value1, value2, "bizAvg");
            return (Criteria) this;
        }
        public Criteria andBrowseNumIsNull() {
            addCriterion("browseNum is null");
            return (Criteria) this;
        }
        public Criteria andBrowseNumIsNotNull() {
            addCriterion("browseNum is not null");
            return (Criteria) this;
        }
        public Criteria andBrowseNumEqualTo(Long value) {
            addCriterion("browseNum =", value, "browseNum");
            return (Criteria) this;
        }
        public Criteria andBrowseNumNotEqualTo(Long value) {
            addCriterion("browseNum <>", value, "browseNum");
            return (Criteria) this;
        }
        public Criteria andBrowseNumGreaterThan(Long value) {
            addCriterion("browseNum >", value, "browseNum");
            return (Criteria) this;
        }
        public Criteria andBrowseNumGreaterThanOrEqualTo(Long value) {
            addCriterion("browseNum >=", value, "browseNum");
            return (Criteria) this;
        }
        public Criteria andBrowseNumLessThan(Long value) {
            addCriterion("browseNum <", value, "browseNum");
            return (Criteria) this;
        }
        public Criteria andBrowseNumLessThanOrEqualTo(Long value) {
            addCriterion("browseNum <=", value, "browseNum");
            return (Criteria) this;
        }
        public Criteria andBrowseNumIn(List<Long> values) {
            addCriterion("browseNum in", values, "browseNum");
            return (Criteria) this;
        }
        public Criteria andBrowseNumNotIn(List<Long> values) {
            addCriterion("browseNum not in", values, "browseNum");
            return (Criteria) this;
        }
        public Criteria andBrowseNumBetween(Long value1, Long value2) {
            addCriterion("browseNum between", value1, value2, "browseNum");
            return (Criteria) this;
        }
        public Criteria andBrowseNumNotBetween(Long value1, Long value2) {
            addCriterion("browseNum not between", value1, value2, "browseNum");
            return (Criteria) this;
        }
        public Criteria andOrderNumIsNull() {
            addCriterion("orderNum is null");
            return (Criteria) this;
        }
        public Criteria andOrderNumIsNotNull() {
            addCriterion("orderNum is not null");
            return (Criteria) this;
        }
        public Criteria andOrderNumEqualTo(String value) {
            addCriterion("orderNum =", value, "orderNum");
            return (Criteria) this;
        }
        public Criteria andOrderNumNotEqualTo(String value) {
            addCriterion("orderNum <>", value, "orderNum");
            return (Criteria) this;
        }
        public Criteria andOrderNumGreaterThan(String value) {
            addCriterion("orderNum >", value, "orderNum");
            return (Criteria) this;
        }
        public Criteria andOrderNumGreaterThanOrEqualTo(String value) {
            addCriterion("orderNum >=", value, "orderNum");
            return (Criteria) this;
        }
        public Criteria andOrderNumLessThan(String value) {
            addCriterion("orderNum <", value, "orderNum");
            return (Criteria) this;
        }
        public Criteria andOrderNumLessThanOrEqualTo(String value) {
            addCriterion("orderNum <=", value, "orderNum");
            return (Criteria) this;
        }
        public Criteria andOrderNumLike(String value) {
            addCriterion("orderNum like", value, "orderNum");
            return (Criteria) this;
        }
        public Criteria andOrderNumNotLike(String value) {
            addCriterion("orderNum not like", value, "orderNum");
            return (Criteria) this;
        }
        public Criteria andOrderNumIn(List<String> values) {
            addCriterion("orderNum in", values, "orderNum");
            return (Criteria) this;
        }
        public Criteria andOrderNumNotIn(List<String> values) {
            addCriterion("orderNum not in", values, "orderNum");
            return (Criteria) this;
        }
        public Criteria andOrderNumBetween(String value1, String value2) {
            addCriterion("orderNum between", value1, value2, "orderNum");
            return (Criteria) this;
        }
        public Criteria andOrderNumNotBetween(String value1, String value2) {
            addCriterion("orderNum not between", value1, value2, "orderNum");
            return (Criteria) this;
        }
        public Criteria andUserLngIsNull() {
            addCriterion("userLng is null");
            return (Criteria) this;
        }
        public Criteria andUserLngIsNotNull() {
            addCriterion("userLng is not null");
            return (Criteria) this;
        }
        public Criteria andUserLngEqualTo(String value) {
            addCriterion("userLng =", value, "userLng");
            return (Criteria) this;
        }
        public Criteria andUserLngNotEqualTo(String value) {
            addCriterion("userLng <>", value, "userLng");
            return (Criteria) this;
        }
        public Criteria andUserLngGreaterThan(String value) {
            addCriterion("userLng >", value, "userLng");
            return (Criteria) this;
        }
        public Criteria andUserLngGreaterThanOrEqualTo(String value) {
            addCriterion("userLng >=", value, "userLng");
            return (Criteria) this;
        }
        public Criteria andUserLngLessThan(String value) {
            addCriterion("userLng <", value, "userLng");
            return (Criteria) this;
        }
        public Criteria andUserLngLessThanOrEqualTo(String value) {
            addCriterion("userLng <=", value, "userLng");
            return (Criteria) this;
        }
        public Criteria andUserLngLike(String value) {
            addCriterion("userLng like", value, "userLng");
            return (Criteria) this;
        }
        public Criteria andUserLngNotLike(String value) {
            addCriterion("userLng not like", value, "userLng");
            return (Criteria) this;
        }
        public Criteria andUserLngIn(List<String> values) {
            addCriterion("userLng in", values, "userLng");
            return (Criteria) this;
        }
        public Criteria andUserLngNotIn(List<String> values) {
            addCriterion("userLng not in", values, "userLng");
            return (Criteria) this;
        }
        public Criteria andUserLngBetween(String value1, String value2) {
            addCriterion("userLng between", value1, value2, "userLng");
            return (Criteria) this;
        }
        public Criteria andUserLngNotBetween(String value1, String value2) {
            addCriterion("userLng not between", value1, value2, "userLng");
            return (Criteria) this;
        }
        public Criteria andUserLatIsNull() {
            addCriterion("userLat is null");
            return (Criteria) this;
        }
        public Criteria andUserLatIsNotNull() {
            addCriterion("userLat is not null");
            return (Criteria) this;
        }
        public Criteria andUserLatEqualTo(String value) {
            addCriterion("userLat =", value, "userLat");
            return (Criteria) this;
        }
        public Criteria andUserLatNotEqualTo(String value) {
            addCriterion("userLat <>", value, "userLat");
            return (Criteria) this;
        }
        public Criteria andUserLatGreaterThan(String value) {
            addCriterion("userLat >", value, "userLat");
            return (Criteria) this;
        }
        public Criteria andUserLatGreaterThanOrEqualTo(String value) {
            addCriterion("userLat >=", value, "userLat");
            return (Criteria) this;
        }
        public Criteria andUserLatLessThan(String value) {
            addCriterion("userLat <", value, "userLat");
            return (Criteria) this;
        }
        public Criteria andUserLatLessThanOrEqualTo(String value) {
            addCriterion("userLat <=", value, "userLat");
            return (Criteria) this;
        }
        public Criteria andUserLatLike(String value) {
            addCriterion("userLat like", value, "userLat");
            return (Criteria) this;
        }
        public Criteria andUserLatNotLike(String value) {
            addCriterion("userLat not like", value, "userLat");
            return (Criteria) this;
        }
        public Criteria andUserLatIn(List<String> values) {
            addCriterion("userLat in", values, "userLat");
            return (Criteria) this;
        }
        public Criteria andUserLatNotIn(List<String> values) {
            addCriterion("userLat not in", values, "userLat");
            return (Criteria) this;
        }
        public Criteria andUserLatBetween(String value1, String value2) {
            addCriterion("userLat between", value1, value2, "userLat");
            return (Criteria) this;
        }
        public Criteria andUserLatNotBetween(String value1, String value2) {
            addCriterion("userLat not between", value1, value2, "userLat");
            return (Criteria) this;
        }
        public Criteria andThemeLikeInsensitive(String value) {
            addCriterion("upper(theme) like", value.toUpperCase(), "theme");
            return (Criteria) this;
        }
        public Criteria andBriefDescLikeInsensitive(String value) {
            addCriterion("upper(briefDesc) like", value.toUpperCase(), "briefDesc");
            return (Criteria) this;
        }
        public Criteria andBizNameLikeInsensitive(String value) {
            addCriterion("upper(bizName) like", value.toUpperCase(), "bizName");
            return (Criteria) this;
        }
        public Criteria andBizAddrLikeInsensitive(String value) {
            addCriterion("upper(bizAddr) like", value.toUpperCase(), "bizAddr");
            return (Criteria) this;
        }
        public Criteria andBizIconLikeInsensitive(String value) {
            addCriterion("upper(bizIcon) like", value.toUpperCase(), "bizIcon");
            return (Criteria) this;
        }
        public Criteria andBizCategoryLikeInsensitive(String value) {
            addCriterion("upper(bizCategory) like", value.toUpperCase(), "bizCategory");
            return (Criteria) this;
        }
        public Criteria andBizLngLikeInsensitive(String value) {
            addCriterion("upper(bizLng) like", value.toUpperCase(), "bizLng");
            return (Criteria) this;
        }
        public Criteria andBizLatLikeInsensitive(String value) {
            addCriterion("upper(bizLat) like", value.toUpperCase(), "bizLat");
            return (Criteria) this;
        }
        public Criteria andBizRateLikeInsensitive(String value) {
            addCriterion("upper(bizRate) like", value.toUpperCase(), "bizRate");
            return (Criteria) this;
        }
        public Criteria andBizAvgLikeInsensitive(String value) {
            addCriterion("upper(bizAvg) like", value.toUpperCase(), "bizAvg");
            return (Criteria) this;
        }
        public Criteria andOrderNumLikeInsensitive(String value) {
            addCriterion("upper(orderNum) like", value.toUpperCase(), "orderNum");
            return (Criteria) this;
        }
        public Criteria andUserLngLikeInsensitive(String value) {
            addCriterion("upper(userLng) like", value.toUpperCase(), "userLng");
            return (Criteria) this;
        }
        public Criteria andUserLatLikeInsensitive(String value) {
            addCriterion("upper(userLat) like", value.toUpperCase(), "userLat");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {


        protected Criteria() {
            super();
        }
    }

    /**
     * 
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