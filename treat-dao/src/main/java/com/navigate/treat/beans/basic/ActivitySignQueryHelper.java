/*
 * ActivitySignQueryHelper.java
 * Copyright(C) 20xx-2015 xxxxxx公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-04-20 Created
 */
package com.navigate.treat.beans.basic;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ActivitySignQueryHelper {

    protected String orderByClause;
    protected boolean distinct;
    protected List<Criteria> oredCriteria;

    public ActivitySignQueryHelper() {
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
     * 活动感应
     * 
     * @author 菠萝大象
     * @version 1.0 2016-04-20
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
        public Criteria andActivityIdIsNull() {
            addCriterion("activityId is null");
            return (Criteria) this;
        }
        public Criteria andActivityIdIsNotNull() {
            addCriterion("activityId is not null");
            return (Criteria) this;
        }
        public Criteria andActivityIdEqualTo(Long value) {
            addCriterion("activityId =", value, "activityId");
            return (Criteria) this;
        }
        public Criteria andActivityIdNotEqualTo(Long value) {
            addCriterion("activityId <>", value, "activityId");
            return (Criteria) this;
        }
        public Criteria andActivityIdGreaterThan(Long value) {
            addCriterion("activityId >", value, "activityId");
            return (Criteria) this;
        }
        public Criteria andActivityIdGreaterThanOrEqualTo(Long value) {
            addCriterion("activityId >=", value, "activityId");
            return (Criteria) this;
        }
        public Criteria andActivityIdLessThan(Long value) {
            addCriterion("activityId <", value, "activityId");
            return (Criteria) this;
        }
        public Criteria andActivityIdLessThanOrEqualTo(Long value) {
            addCriterion("activityId <=", value, "activityId");
            return (Criteria) this;
        }
        public Criteria andActivityIdIn(List<Long> values) {
            addCriterion("activityId in", values, "activityId");
            return (Criteria) this;
        }
        public Criteria andActivityIdNotIn(List<Long> values) {
            addCriterion("activityId not in", values, "activityId");
            return (Criteria) this;
        }
        public Criteria andActivityIdBetween(Long value1, Long value2) {
            addCriterion("activityId between", value1, value2, "activityId");
            return (Criteria) this;
        }
        public Criteria andActivityIdNotBetween(Long value1, Long value2) {
            addCriterion("activityId not between", value1, value2, "activityId");
            return (Criteria) this;
        }
        public Criteria andActivityTimeIsNull() {
            addCriterion("activityTime is null");
            return (Criteria) this;
        }
        public Criteria andActivityTimeIsNotNull() {
            addCriterion("activityTime is not null");
            return (Criteria) this;
        }
        public Criteria andActivityTimeEqualTo(Date value) {
            addCriterion("activityTime =", value, "activityTime");
            return (Criteria) this;
        }
        public Criteria andActivityTimeNotEqualTo(Date value) {
            addCriterion("activityTime <>", value, "activityTime");
            return (Criteria) this;
        }
        public Criteria andActivityTimeGreaterThan(Date value) {
            addCriterion("activityTime >", value, "activityTime");
            return (Criteria) this;
        }
        public Criteria andActivityTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("activityTime >=", value, "activityTime");
            return (Criteria) this;
        }
        public Criteria andActivityTimeLessThan(Date value) {
            addCriterion("activityTime <", value, "activityTime");
            return (Criteria) this;
        }
        public Criteria andActivityTimeLessThanOrEqualTo(Date value) {
            addCriterion("activityTime <=", value, "activityTime");
            return (Criteria) this;
        }
        public Criteria andActivityTimeIn(List<Date> values) {
            addCriterion("activityTime in", values, "activityTime");
            return (Criteria) this;
        }
        public Criteria andActivityTimeNotIn(List<Date> values) {
            addCriterion("activityTime not in", values, "activityTime");
            return (Criteria) this;
        }
        public Criteria andActivityTimeBetween(Date value1, Date value2) {
            addCriterion("activityTime between", value1, value2, "activityTime");
            return (Criteria) this;
        }
        public Criteria andActivityTimeNotBetween(Date value1, Date value2) {
            addCriterion("activityTime not between", value1, value2, "activityTime");
            return (Criteria) this;
        }
        public Criteria andLngIsNull() {
            addCriterion("lng is null");
            return (Criteria) this;
        }
        public Criteria andLngIsNotNull() {
            addCriterion("lng is not null");
            return (Criteria) this;
        }
        public Criteria andLngEqualTo(String value) {
            addCriterion("lng =", value, "lng");
            return (Criteria) this;
        }
        public Criteria andLngNotEqualTo(String value) {
            addCriterion("lng <>", value, "lng");
            return (Criteria) this;
        }
        public Criteria andLngGreaterThan(String value) {
            addCriterion("lng >", value, "lng");
            return (Criteria) this;
        }
        public Criteria andLngGreaterThanOrEqualTo(String value) {
            addCriterion("lng >=", value, "lng");
            return (Criteria) this;
        }
        public Criteria andLngLessThan(String value) {
            addCriterion("lng <", value, "lng");
            return (Criteria) this;
        }
        public Criteria andLngLessThanOrEqualTo(String value) {
            addCriterion("lng <=", value, "lng");
            return (Criteria) this;
        }
        public Criteria andLngLike(String value) {
            addCriterion("lng like", value, "lng");
            return (Criteria) this;
        }
        public Criteria andLngNotLike(String value) {
            addCriterion("lng not like", value, "lng");
            return (Criteria) this;
        }
        public Criteria andLngIn(List<String> values) {
            addCriterion("lng in", values, "lng");
            return (Criteria) this;
        }
        public Criteria andLngNotIn(List<String> values) {
            addCriterion("lng not in", values, "lng");
            return (Criteria) this;
        }
        public Criteria andLngBetween(String value1, String value2) {
            addCriterion("lng between", value1, value2, "lng");
            return (Criteria) this;
        }
        public Criteria andLngNotBetween(String value1, String value2) {
            addCriterion("lng not between", value1, value2, "lng");
            return (Criteria) this;
        }
        public Criteria andLatIsNull() {
            addCriterion("lat is null");
            return (Criteria) this;
        }
        public Criteria andLatIsNotNull() {
            addCriterion("lat is not null");
            return (Criteria) this;
        }
        public Criteria andLatEqualTo(String value) {
            addCriterion("lat =", value, "lat");
            return (Criteria) this;
        }
        public Criteria andLatNotEqualTo(String value) {
            addCriterion("lat <>", value, "lat");
            return (Criteria) this;
        }
        public Criteria andLatGreaterThan(String value) {
            addCriterion("lat >", value, "lat");
            return (Criteria) this;
        }
        public Criteria andLatGreaterThanOrEqualTo(String value) {
            addCriterion("lat >=", value, "lat");
            return (Criteria) this;
        }
        public Criteria andLatLessThan(String value) {
            addCriterion("lat <", value, "lat");
            return (Criteria) this;
        }
        public Criteria andLatLessThanOrEqualTo(String value) {
            addCriterion("lat <=", value, "lat");
            return (Criteria) this;
        }
        public Criteria andLatLike(String value) {
            addCriterion("lat like", value, "lat");
            return (Criteria) this;
        }
        public Criteria andLatNotLike(String value) {
            addCriterion("lat not like", value, "lat");
            return (Criteria) this;
        }
        public Criteria andLatIn(List<String> values) {
            addCriterion("lat in", values, "lat");
            return (Criteria) this;
        }
        public Criteria andLatNotIn(List<String> values) {
            addCriterion("lat not in", values, "lat");
            return (Criteria) this;
        }
        public Criteria andLatBetween(String value1, String value2) {
            addCriterion("lat between", value1, value2, "lat");
            return (Criteria) this;
        }
        public Criteria andLatNotBetween(String value1, String value2) {
            addCriterion("lat not between", value1, value2, "lat");
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
        public Criteria andRoleIsNull() {
            addCriterion("role is null");
            return (Criteria) this;
        }
        public Criteria andRoleIsNotNull() {
            addCriterion("role is not null");
            return (Criteria) this;
        }
        public Criteria andRoleEqualTo(Integer value) {
            addCriterion("role =", value, "role");
            return (Criteria) this;
        }
        public Criteria andRoleNotEqualTo(Integer value) {
            addCriterion("role <>", value, "role");
            return (Criteria) this;
        }
        public Criteria andRoleGreaterThan(Integer value) {
            addCriterion("role >", value, "role");
            return (Criteria) this;
        }
        public Criteria andRoleGreaterThanOrEqualTo(Integer value) {
            addCriterion("role >=", value, "role");
            return (Criteria) this;
        }
        public Criteria andRoleLessThan(Integer value) {
            addCriterion("role <", value, "role");
            return (Criteria) this;
        }
        public Criteria andRoleLessThanOrEqualTo(Integer value) {
            addCriterion("role <=", value, "role");
            return (Criteria) this;
        }
        public Criteria andRoleIn(List<Integer> values) {
            addCriterion("role in", values, "role");
            return (Criteria) this;
        }
        public Criteria andRoleNotIn(List<Integer> values) {
            addCriterion("role not in", values, "role");
            return (Criteria) this;
        }
        public Criteria andRoleBetween(Integer value1, Integer value2) {
            addCriterion("role between", value1, value2, "role");
            return (Criteria) this;
        }
        public Criteria andRoleNotBetween(Integer value1, Integer value2) {
            addCriterion("role not between", value1, value2, "role");
            return (Criteria) this;
        }
        public Criteria andSigninIsNull() {
            addCriterion("signin is null");
            return (Criteria) this;
        }
        public Criteria andSigninIsNotNull() {
            addCriterion("signin is not null");
            return (Criteria) this;
        }
        public Criteria andSigninEqualTo(Integer value) {
            addCriterion("signin =", value, "signin");
            return (Criteria) this;
        }
        public Criteria andSigninNotEqualTo(Integer value) {
            addCriterion("signin <>", value, "signin");
            return (Criteria) this;
        }
        public Criteria andSigninGreaterThan(Integer value) {
            addCriterion("signin >", value, "signin");
            return (Criteria) this;
        }
        public Criteria andSigninGreaterThanOrEqualTo(Integer value) {
            addCriterion("signin >=", value, "signin");
            return (Criteria) this;
        }
        public Criteria andSigninLessThan(Integer value) {
            addCriterion("signin <", value, "signin");
            return (Criteria) this;
        }
        public Criteria andSigninLessThanOrEqualTo(Integer value) {
            addCriterion("signin <=", value, "signin");
            return (Criteria) this;
        }
        public Criteria andSigninIn(List<Integer> values) {
            addCriterion("signin in", values, "signin");
            return (Criteria) this;
        }
        public Criteria andSigninNotIn(List<Integer> values) {
            addCriterion("signin not in", values, "signin");
            return (Criteria) this;
        }
        public Criteria andSigninBetween(Integer value1, Integer value2) {
            addCriterion("signin between", value1, value2, "signin");
            return (Criteria) this;
        }
        public Criteria andSigninNotBetween(Integer value1, Integer value2) {
            addCriterion("signin not between", value1, value2, "signin");
            return (Criteria) this;
        }
        public Criteria andSingTimeIsNull() {
            addCriterion("singTime is null");
            return (Criteria) this;
        }
        public Criteria andSingTimeIsNotNull() {
            addCriterion("singTime is not null");
            return (Criteria) this;
        }
        public Criteria andSingTimeEqualTo(Date value) {
            addCriterion("singTime =", value, "singTime");
            return (Criteria) this;
        }
        public Criteria andSingTimeNotEqualTo(Date value) {
            addCriterion("singTime <>", value, "singTime");
            return (Criteria) this;
        }
        public Criteria andSingTimeGreaterThan(Date value) {
            addCriterion("singTime >", value, "singTime");
            return (Criteria) this;
        }
        public Criteria andSingTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("singTime >=", value, "singTime");
            return (Criteria) this;
        }
        public Criteria andSingTimeLessThan(Date value) {
            addCriterion("singTime <", value, "singTime");
            return (Criteria) this;
        }
        public Criteria andSingTimeLessThanOrEqualTo(Date value) {
            addCriterion("singTime <=", value, "singTime");
            return (Criteria) this;
        }
        public Criteria andSingTimeIn(List<Date> values) {
            addCriterion("singTime in", values, "singTime");
            return (Criteria) this;
        }
        public Criteria andSingTimeNotIn(List<Date> values) {
            addCriterion("singTime not in", values, "singTime");
            return (Criteria) this;
        }
        public Criteria andSingTimeBetween(Date value1, Date value2) {
            addCriterion("singTime between", value1, value2, "singTime");
            return (Criteria) this;
        }
        public Criteria andSingTimeNotBetween(Date value1, Date value2) {
            addCriterion("singTime not between", value1, value2, "singTime");
            return (Criteria) this;
        }
        public Criteria andSupplyAmountIsNull() {
            addCriterion("supplyAmount is null");
            return (Criteria) this;
        }
        public Criteria andSupplyAmountIsNotNull() {
            addCriterion("supplyAmount is not null");
            return (Criteria) this;
        }
        public Criteria andSupplyAmountEqualTo(BigDecimal value) {
            addCriterion("supplyAmount =", value, "supplyAmount");
            return (Criteria) this;
        }
        public Criteria andSupplyAmountNotEqualTo(BigDecimal value) {
            addCriterion("supplyAmount <>", value, "supplyAmount");
            return (Criteria) this;
        }
        public Criteria andSupplyAmountGreaterThan(BigDecimal value) {
            addCriterion("supplyAmount >", value, "supplyAmount");
            return (Criteria) this;
        }
        public Criteria andSupplyAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("supplyAmount >=", value, "supplyAmount");
            return (Criteria) this;
        }
        public Criteria andSupplyAmountLessThan(BigDecimal value) {
            addCriterion("supplyAmount <", value, "supplyAmount");
            return (Criteria) this;
        }
        public Criteria andSupplyAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("supplyAmount <=", value, "supplyAmount");
            return (Criteria) this;
        }
        public Criteria andSupplyAmountIn(List<BigDecimal> values) {
            addCriterion("supplyAmount in", values, "supplyAmount");
            return (Criteria) this;
        }
        public Criteria andSupplyAmountNotIn(List<BigDecimal> values) {
            addCriterion("supplyAmount not in", values, "supplyAmount");
            return (Criteria) this;
        }
        public Criteria andSupplyAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("supplyAmount between", value1, value2, "supplyAmount");
            return (Criteria) this;
        }
        public Criteria andSupplyAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("supplyAmount not between", value1, value2, "supplyAmount");
            return (Criteria) this;
        }
        public Criteria andSupplyIsNull() {
            addCriterion("supply is null");
            return (Criteria) this;
        }
        public Criteria andSupplyIsNotNull() {
            addCriterion("supply is not null");
            return (Criteria) this;
        }
        public Criteria andSupplyEqualTo(Integer value) {
            addCriterion("supply =", value, "supply");
            return (Criteria) this;
        }
        public Criteria andSupplyNotEqualTo(Integer value) {
            addCriterion("supply <>", value, "supply");
            return (Criteria) this;
        }
        public Criteria andSupplyGreaterThan(Integer value) {
            addCriterion("supply >", value, "supply");
            return (Criteria) this;
        }
        public Criteria andSupplyGreaterThanOrEqualTo(Integer value) {
            addCriterion("supply >=", value, "supply");
            return (Criteria) this;
        }
        public Criteria andSupplyLessThan(Integer value) {
            addCriterion("supply <", value, "supply");
            return (Criteria) this;
        }
        public Criteria andSupplyLessThanOrEqualTo(Integer value) {
            addCriterion("supply <=", value, "supply");
            return (Criteria) this;
        }
        public Criteria andSupplyIn(List<Integer> values) {
            addCriterion("supply in", values, "supply");
            return (Criteria) this;
        }
        public Criteria andSupplyNotIn(List<Integer> values) {
            addCriterion("supply not in", values, "supply");
            return (Criteria) this;
        }
        public Criteria andSupplyBetween(Integer value1, Integer value2) {
            addCriterion("supply between", value1, value2, "supply");
            return (Criteria) this;
        }
        public Criteria andSupplyNotBetween(Integer value1, Integer value2) {
            addCriterion("supply not between", value1, value2, "supply");
            return (Criteria) this;
        }
        public Criteria andDepositAmountIsNull() {
            addCriterion("depositAmount is null");
            return (Criteria) this;
        }
        public Criteria andDepositAmountIsNotNull() {
            addCriterion("depositAmount is not null");
            return (Criteria) this;
        }
        public Criteria andDepositAmountEqualTo(BigDecimal value) {
            addCriterion("depositAmount =", value, "depositAmount");
            return (Criteria) this;
        }
        public Criteria andDepositAmountNotEqualTo(BigDecimal value) {
            addCriterion("depositAmount <>", value, "depositAmount");
            return (Criteria) this;
        }
        public Criteria andDepositAmountGreaterThan(BigDecimal value) {
            addCriterion("depositAmount >", value, "depositAmount");
            return (Criteria) this;
        }
        public Criteria andDepositAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("depositAmount >=", value, "depositAmount");
            return (Criteria) this;
        }
        public Criteria andDepositAmountLessThan(BigDecimal value) {
            addCriterion("depositAmount <", value, "depositAmount");
            return (Criteria) this;
        }
        public Criteria andDepositAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("depositAmount <=", value, "depositAmount");
            return (Criteria) this;
        }
        public Criteria andDepositAmountIn(List<BigDecimal> values) {
            addCriterion("depositAmount in", values, "depositAmount");
            return (Criteria) this;
        }
        public Criteria andDepositAmountNotIn(List<BigDecimal> values) {
            addCriterion("depositAmount not in", values, "depositAmount");
            return (Criteria) this;
        }
        public Criteria andDepositAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("depositAmount between", value1, value2, "depositAmount");
            return (Criteria) this;
        }
        public Criteria andDepositAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("depositAmount not between", value1, value2, "depositAmount");
            return (Criteria) this;
        }
        public Criteria andDepositIsNull() {
            addCriterion("deposit is null");
            return (Criteria) this;
        }
        public Criteria andDepositIsNotNull() {
            addCriterion("deposit is not null");
            return (Criteria) this;
        }
        public Criteria andDepositEqualTo(Integer value) {
            addCriterion("deposit =", value, "deposit");
            return (Criteria) this;
        }
        public Criteria andDepositNotEqualTo(Integer value) {
            addCriterion("deposit <>", value, "deposit");
            return (Criteria) this;
        }
        public Criteria andDepositGreaterThan(Integer value) {
            addCriterion("deposit >", value, "deposit");
            return (Criteria) this;
        }
        public Criteria andDepositGreaterThanOrEqualTo(Integer value) {
            addCriterion("deposit >=", value, "deposit");
            return (Criteria) this;
        }
        public Criteria andDepositLessThan(Integer value) {
            addCriterion("deposit <", value, "deposit");
            return (Criteria) this;
        }
        public Criteria andDepositLessThanOrEqualTo(Integer value) {
            addCriterion("deposit <=", value, "deposit");
            return (Criteria) this;
        }
        public Criteria andDepositIn(List<Integer> values) {
            addCriterion("deposit in", values, "deposit");
            return (Criteria) this;
        }
        public Criteria andDepositNotIn(List<Integer> values) {
            addCriterion("deposit not in", values, "deposit");
            return (Criteria) this;
        }
        public Criteria andDepositBetween(Integer value1, Integer value2) {
            addCriterion("deposit between", value1, value2, "deposit");
            return (Criteria) this;
        }
        public Criteria andDepositNotBetween(Integer value1, Integer value2) {
            addCriterion("deposit not between", value1, value2, "deposit");
            return (Criteria) this;
        }
        public Criteria andBePunishedIsNull() {
            addCriterion("bePunished is null");
            return (Criteria) this;
        }
        public Criteria andBePunishedIsNotNull() {
            addCriterion("bePunished is not null");
            return (Criteria) this;
        }
        public Criteria andBePunishedEqualTo(Integer value) {
            addCriterion("bePunished =", value, "bePunished");
            return (Criteria) this;
        }
        public Criteria andBePunishedNotEqualTo(Integer value) {
            addCriterion("bePunished <>", value, "bePunished");
            return (Criteria) this;
        }
        public Criteria andBePunishedGreaterThan(Integer value) {
            addCriterion("bePunished >", value, "bePunished");
            return (Criteria) this;
        }
        public Criteria andBePunishedGreaterThanOrEqualTo(Integer value) {
            addCriterion("bePunished >=", value, "bePunished");
            return (Criteria) this;
        }
        public Criteria andBePunishedLessThan(Integer value) {
            addCriterion("bePunished <", value, "bePunished");
            return (Criteria) this;
        }
        public Criteria andBePunishedLessThanOrEqualTo(Integer value) {
            addCriterion("bePunished <=", value, "bePunished");
            return (Criteria) this;
        }
        public Criteria andBePunishedIn(List<Integer> values) {
            addCriterion("bePunished in", values, "bePunished");
            return (Criteria) this;
        }
        public Criteria andBePunishedNotIn(List<Integer> values) {
            addCriterion("bePunished not in", values, "bePunished");
            return (Criteria) this;
        }
        public Criteria andBePunishedBetween(Integer value1, Integer value2) {
            addCriterion("bePunished between", value1, value2, "bePunished");
            return (Criteria) this;
        }
        public Criteria andBePunishedNotBetween(Integer value1, Integer value2) {
            addCriterion("bePunished not between", value1, value2, "bePunished");
            return (Criteria) this;
        }
        public Criteria andPunishedIsNull() {
            addCriterion("punished is null");
            return (Criteria) this;
        }
        public Criteria andPunishedIsNotNull() {
            addCriterion("punished is not null");
            return (Criteria) this;
        }
        public Criteria andPunishedEqualTo(Integer value) {
            addCriterion("punished =", value, "punished");
            return (Criteria) this;
        }
        public Criteria andPunishedNotEqualTo(Integer value) {
            addCriterion("punished <>", value, "punished");
            return (Criteria) this;
        }
        public Criteria andPunishedGreaterThan(Integer value) {
            addCriterion("punished >", value, "punished");
            return (Criteria) this;
        }
        public Criteria andPunishedGreaterThanOrEqualTo(Integer value) {
            addCriterion("punished >=", value, "punished");
            return (Criteria) this;
        }
        public Criteria andPunishedLessThan(Integer value) {
            addCriterion("punished <", value, "punished");
            return (Criteria) this;
        }
        public Criteria andPunishedLessThanOrEqualTo(Integer value) {
            addCriterion("punished <=", value, "punished");
            return (Criteria) this;
        }
        public Criteria andPunishedIn(List<Integer> values) {
            addCriterion("punished in", values, "punished");
            return (Criteria) this;
        }
        public Criteria andPunishedNotIn(List<Integer> values) {
            addCriterion("punished not in", values, "punished");
            return (Criteria) this;
        }
        public Criteria andPunishedBetween(Integer value1, Integer value2) {
            addCriterion("punished between", value1, value2, "punished");
            return (Criteria) this;
        }
        public Criteria andPunishedNotBetween(Integer value1, Integer value2) {
            addCriterion("punished not between", value1, value2, "punished");
            return (Criteria) this;
        }
        public Criteria andLngLikeInsensitive(String value) {
            addCriterion("upper(lng) like", value.toUpperCase(), "lng");
            return (Criteria) this;
        }
        public Criteria andLatLikeInsensitive(String value) {
            addCriterion("upper(lat) like", value.toUpperCase(), "lat");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {


        protected Criteria() {
            super();
        }
    }

    /**
     * 活动感应
     * 
     * @author 菠萝大象
     * @version 1.0 2016-04-20
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