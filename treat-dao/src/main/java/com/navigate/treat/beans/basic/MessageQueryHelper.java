/*
 * MessageQueryHelper.java
 * Copyright(C) 20xx-2015 xxxxxx公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-04-18 Created
 */
package com.navigate.treat.beans.basic;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MessageQueryHelper {

    protected String orderByClause;
    protected boolean distinct;
    protected List<Criteria> oredCriteria;

    public MessageQueryHelper() {
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
     * @author 菠萝大象
     * @version 1.0 2016-04-18
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
        public Criteria andFuidIsNull() {
            addCriterion("fuid is null");
            return (Criteria) this;
        }
        public Criteria andFuidIsNotNull() {
            addCriterion("fuid is not null");
            return (Criteria) this;
        }
        public Criteria andFuidEqualTo(Long value) {
            addCriterion("fuid =", value, "fuid");
            return (Criteria) this;
        }
        public Criteria andFuidNotEqualTo(Long value) {
            addCriterion("fuid <>", value, "fuid");
            return (Criteria) this;
        }
        public Criteria andFuidGreaterThan(Long value) {
            addCriterion("fuid >", value, "fuid");
            return (Criteria) this;
        }
        public Criteria andFuidGreaterThanOrEqualTo(Long value) {
            addCriterion("fuid >=", value, "fuid");
            return (Criteria) this;
        }
        public Criteria andFuidLessThan(Long value) {
            addCriterion("fuid <", value, "fuid");
            return (Criteria) this;
        }
        public Criteria andFuidLessThanOrEqualTo(Long value) {
            addCriterion("fuid <=", value, "fuid");
            return (Criteria) this;
        }
        public Criteria andFuidIn(List<Long> values) {
            addCriterion("fuid in", values, "fuid");
            return (Criteria) this;
        }
        public Criteria andFuidNotIn(List<Long> values) {
            addCriterion("fuid not in", values, "fuid");
            return (Criteria) this;
        }
        public Criteria andFuidBetween(Long value1, Long value2) {
            addCriterion("fuid between", value1, value2, "fuid");
            return (Criteria) this;
        }
        public Criteria andFuidNotBetween(Long value1, Long value2) {
            addCriterion("fuid not between", value1, value2, "fuid");
            return (Criteria) this;
        }
        public Criteria andTuidIsNull() {
            addCriterion("tuid is null");
            return (Criteria) this;
        }
        public Criteria andTuidIsNotNull() {
            addCriterion("tuid is not null");
            return (Criteria) this;
        }
        public Criteria andTuidEqualTo(Long value) {
            addCriterion("tuid =", value, "tuid");
            return (Criteria) this;
        }
        public Criteria andTuidNotEqualTo(Long value) {
            addCriterion("tuid <>", value, "tuid");
            return (Criteria) this;
        }
        public Criteria andTuidGreaterThan(Long value) {
            addCriterion("tuid >", value, "tuid");
            return (Criteria) this;
        }
        public Criteria andTuidGreaterThanOrEqualTo(Long value) {
            addCriterion("tuid >=", value, "tuid");
            return (Criteria) this;
        }
        public Criteria andTuidLessThan(Long value) {
            addCriterion("tuid <", value, "tuid");
            return (Criteria) this;
        }
        public Criteria andTuidLessThanOrEqualTo(Long value) {
            addCriterion("tuid <=", value, "tuid");
            return (Criteria) this;
        }
        public Criteria andTuidIn(List<Long> values) {
            addCriterion("tuid in", values, "tuid");
            return (Criteria) this;
        }
        public Criteria andTuidNotIn(List<Long> values) {
            addCriterion("tuid not in", values, "tuid");
            return (Criteria) this;
        }
        public Criteria andTuidBetween(Long value1, Long value2) {
            addCriterion("tuid between", value1, value2, "tuid");
            return (Criteria) this;
        }
        public Criteria andTuidNotBetween(Long value1, Long value2) {
            addCriterion("tuid not between", value1, value2, "tuid");
            return (Criteria) this;
        }
        public Criteria andMtypeIsNull() {
            addCriterion("mtype is null");
            return (Criteria) this;
        }
        public Criteria andMtypeIsNotNull() {
            addCriterion("mtype is not null");
            return (Criteria) this;
        }
        public Criteria andMtypeEqualTo(Integer value) {
            addCriterion("mtype =", value, "mtype");
            return (Criteria) this;
        }
        public Criteria andMtypeNotEqualTo(Integer value) {
            addCriterion("mtype <>", value, "mtype");
            return (Criteria) this;
        }
        public Criteria andMtypeGreaterThan(Integer value) {
            addCriterion("mtype >", value, "mtype");
            return (Criteria) this;
        }
        public Criteria andMtypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("mtype >=", value, "mtype");
            return (Criteria) this;
        }
        public Criteria andMtypeLessThan(Integer value) {
            addCriterion("mtype <", value, "mtype");
            return (Criteria) this;
        }
        public Criteria andMtypeLessThanOrEqualTo(Integer value) {
            addCriterion("mtype <=", value, "mtype");
            return (Criteria) this;
        }
        public Criteria andMtypeIn(List<Integer> values) {
            addCriterion("mtype in", values, "mtype");
            return (Criteria) this;
        }
        public Criteria andMtypeNotIn(List<Integer> values) {
            addCriterion("mtype not in", values, "mtype");
            return (Criteria) this;
        }
        public Criteria andMtypeBetween(Integer value1, Integer value2) {
            addCriterion("mtype between", value1, value2, "mtype");
            return (Criteria) this;
        }
        public Criteria andMtypeNotBetween(Integer value1, Integer value2) {
            addCriterion("mtype not between", value1, value2, "mtype");
            return (Criteria) this;
        }
        public Criteria andBizCodeIsNull() {
            addCriterion("bizCode is null");
            return (Criteria) this;
        }
        public Criteria andBizCodeIsNotNull() {
            addCriterion("bizCode is not null");
            return (Criteria) this;
        }
        public Criteria andBizCodeEqualTo(Integer value) {
            addCriterion("bizCode =", value, "bizCode");
            return (Criteria) this;
        }
        public Criteria andBizCodeNotEqualTo(Integer value) {
            addCriterion("bizCode <>", value, "bizCode");
            return (Criteria) this;
        }
        public Criteria andBizCodeGreaterThan(Integer value) {
            addCriterion("bizCode >", value, "bizCode");
            return (Criteria) this;
        }
        public Criteria andBizCodeGreaterThanOrEqualTo(Integer value) {
            addCriterion("bizCode >=", value, "bizCode");
            return (Criteria) this;
        }
        public Criteria andBizCodeLessThan(Integer value) {
            addCriterion("bizCode <", value, "bizCode");
            return (Criteria) this;
        }
        public Criteria andBizCodeLessThanOrEqualTo(Integer value) {
            addCriterion("bizCode <=", value, "bizCode");
            return (Criteria) this;
        }
        public Criteria andBizCodeIn(List<Integer> values) {
            addCriterion("bizCode in", values, "bizCode");
            return (Criteria) this;
        }
        public Criteria andBizCodeNotIn(List<Integer> values) {
            addCriterion("bizCode not in", values, "bizCode");
            return (Criteria) this;
        }
        public Criteria andBizCodeBetween(Integer value1, Integer value2) {
            addCriterion("bizCode between", value1, value2, "bizCode");
            return (Criteria) this;
        }
        public Criteria andBizCodeNotBetween(Integer value1, Integer value2) {
            addCriterion("bizCode not between", value1, value2, "bizCode");
            return (Criteria) this;
        }
        public Criteria andTitleIsNull() {
            addCriterion("title is null");
            return (Criteria) this;
        }
        public Criteria andTitleIsNotNull() {
            addCriterion("title is not null");
            return (Criteria) this;
        }
        public Criteria andTitleEqualTo(String value) {
            addCriterion("title =", value, "title");
            return (Criteria) this;
        }
        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("title <>", value, "title");
            return (Criteria) this;
        }
        public Criteria andTitleGreaterThan(String value) {
            addCriterion("title >", value, "title");
            return (Criteria) this;
        }
        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("title >=", value, "title");
            return (Criteria) this;
        }
        public Criteria andTitleLessThan(String value) {
            addCriterion("title <", value, "title");
            return (Criteria) this;
        }
        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("title <=", value, "title");
            return (Criteria) this;
        }
        public Criteria andTitleLike(String value) {
            addCriterion("title like", value, "title");
            return (Criteria) this;
        }
        public Criteria andTitleNotLike(String value) {
            addCriterion("title not like", value, "title");
            return (Criteria) this;
        }
        public Criteria andTitleIn(List<String> values) {
            addCriterion("title in", values, "title");
            return (Criteria) this;
        }
        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("title not in", values, "title");
            return (Criteria) this;
        }
        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("title between", value1, value2, "title");
            return (Criteria) this;
        }
        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("title not between", value1, value2, "title");
            return (Criteria) this;
        }
        public Criteria andContentIsNull() {
            addCriterion("content is null");
            return (Criteria) this;
        }
        public Criteria andContentIsNotNull() {
            addCriterion("content is not null");
            return (Criteria) this;
        }
        public Criteria andContentEqualTo(String value) {
            addCriterion("content =", value, "content");
            return (Criteria) this;
        }
        public Criteria andContentNotEqualTo(String value) {
            addCriterion("content <>", value, "content");
            return (Criteria) this;
        }
        public Criteria andContentGreaterThan(String value) {
            addCriterion("content >", value, "content");
            return (Criteria) this;
        }
        public Criteria andContentGreaterThanOrEqualTo(String value) {
            addCriterion("content >=", value, "content");
            return (Criteria) this;
        }
        public Criteria andContentLessThan(String value) {
            addCriterion("content <", value, "content");
            return (Criteria) this;
        }
        public Criteria andContentLessThanOrEqualTo(String value) {
            addCriterion("content <=", value, "content");
            return (Criteria) this;
        }
        public Criteria andContentLike(String value) {
            addCriterion("content like", value, "content");
            return (Criteria) this;
        }
        public Criteria andContentNotLike(String value) {
            addCriterion("content not like", value, "content");
            return (Criteria) this;
        }
        public Criteria andContentIn(List<String> values) {
            addCriterion("content in", values, "content");
            return (Criteria) this;
        }
        public Criteria andContentNotIn(List<String> values) {
            addCriterion("content not in", values, "content");
            return (Criteria) this;
        }
        public Criteria andContentBetween(String value1, String value2) {
            addCriterion("content between", value1, value2, "content");
            return (Criteria) this;
        }
        public Criteria andContentNotBetween(String value1, String value2) {
            addCriterion("content not between", value1, value2, "content");
            return (Criteria) this;
        }
        public Criteria andOperationIsNull() {
            addCriterion("operation is null");
            return (Criteria) this;
        }
        public Criteria andOperationIsNotNull() {
            addCriterion("operation is not null");
            return (Criteria) this;
        }
        public Criteria andOperationEqualTo(Integer value) {
            addCriterion("operation =", value, "operation");
            return (Criteria) this;
        }
        public Criteria andOperationNotEqualTo(Integer value) {
            addCriterion("operation <>", value, "operation");
            return (Criteria) this;
        }
        public Criteria andOperationGreaterThan(Integer value) {
            addCriterion("operation >", value, "operation");
            return (Criteria) this;
        }
        public Criteria andOperationGreaterThanOrEqualTo(Integer value) {
            addCriterion("operation >=", value, "operation");
            return (Criteria) this;
        }
        public Criteria andOperationLessThan(Integer value) {
            addCriterion("operation <", value, "operation");
            return (Criteria) this;
        }
        public Criteria andOperationLessThanOrEqualTo(Integer value) {
            addCriterion("operation <=", value, "operation");
            return (Criteria) this;
        }
        public Criteria andOperationIn(List<Integer> values) {
            addCriterion("operation in", values, "operation");
            return (Criteria) this;
        }
        public Criteria andOperationNotIn(List<Integer> values) {
            addCriterion("operation not in", values, "operation");
            return (Criteria) this;
        }
        public Criteria andOperationBetween(Integer value1, Integer value2) {
            addCriterion("operation between", value1, value2, "operation");
            return (Criteria) this;
        }
        public Criteria andOperationNotBetween(Integer value1, Integer value2) {
            addCriterion("operation not between", value1, value2, "operation");
            return (Criteria) this;
        }
        public Criteria andTargetTypeIsNull() {
            addCriterion("targetType is null");
            return (Criteria) this;
        }
        public Criteria andTargetTypeIsNotNull() {
            addCriterion("targetType is not null");
            return (Criteria) this;
        }
        public Criteria andTargetTypeEqualTo(Integer value) {
            addCriterion("targetType =", value, "targetType");
            return (Criteria) this;
        }
        public Criteria andTargetTypeNotEqualTo(Integer value) {
            addCriterion("targetType <>", value, "targetType");
            return (Criteria) this;
        }
        public Criteria andTargetTypeGreaterThan(Integer value) {
            addCriterion("targetType >", value, "targetType");
            return (Criteria) this;
        }
        public Criteria andTargetTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("targetType >=", value, "targetType");
            return (Criteria) this;
        }
        public Criteria andTargetTypeLessThan(Integer value) {
            addCriterion("targetType <", value, "targetType");
            return (Criteria) this;
        }
        public Criteria andTargetTypeLessThanOrEqualTo(Integer value) {
            addCriterion("targetType <=", value, "targetType");
            return (Criteria) this;
        }
        public Criteria andTargetTypeIn(List<Integer> values) {
            addCriterion("targetType in", values, "targetType");
            return (Criteria) this;
        }
        public Criteria andTargetTypeNotIn(List<Integer> values) {
            addCriterion("targetType not in", values, "targetType");
            return (Criteria) this;
        }
        public Criteria andTargetTypeBetween(Integer value1, Integer value2) {
            addCriterion("targetType between", value1, value2, "targetType");
            return (Criteria) this;
        }
        public Criteria andTargetTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("targetType not between", value1, value2, "targetType");
            return (Criteria) this;
        }
        public Criteria andTargetUrlIsNull() {
            addCriterion("targetUrl is null");
            return (Criteria) this;
        }
        public Criteria andTargetUrlIsNotNull() {
            addCriterion("targetUrl is not null");
            return (Criteria) this;
        }
        public Criteria andTargetUrlEqualTo(String value) {
            addCriterion("targetUrl =", value, "targetUrl");
            return (Criteria) this;
        }
        public Criteria andTargetUrlNotEqualTo(String value) {
            addCriterion("targetUrl <>", value, "targetUrl");
            return (Criteria) this;
        }
        public Criteria andTargetUrlGreaterThan(String value) {
            addCriterion("targetUrl >", value, "targetUrl");
            return (Criteria) this;
        }
        public Criteria andTargetUrlGreaterThanOrEqualTo(String value) {
            addCriterion("targetUrl >=", value, "targetUrl");
            return (Criteria) this;
        }
        public Criteria andTargetUrlLessThan(String value) {
            addCriterion("targetUrl <", value, "targetUrl");
            return (Criteria) this;
        }
        public Criteria andTargetUrlLessThanOrEqualTo(String value) {
            addCriterion("targetUrl <=", value, "targetUrl");
            return (Criteria) this;
        }
        public Criteria andTargetUrlLike(String value) {
            addCriterion("targetUrl like", value, "targetUrl");
            return (Criteria) this;
        }
        public Criteria andTargetUrlNotLike(String value) {
            addCriterion("targetUrl not like", value, "targetUrl");
            return (Criteria) this;
        }
        public Criteria andTargetUrlIn(List<String> values) {
            addCriterion("targetUrl in", values, "targetUrl");
            return (Criteria) this;
        }
        public Criteria andTargetUrlNotIn(List<String> values) {
            addCriterion("targetUrl not in", values, "targetUrl");
            return (Criteria) this;
        }
        public Criteria andTargetUrlBetween(String value1, String value2) {
            addCriterion("targetUrl between", value1, value2, "targetUrl");
            return (Criteria) this;
        }
        public Criteria andTargetUrlNotBetween(String value1, String value2) {
            addCriterion("targetUrl not between", value1, value2, "targetUrl");
            return (Criteria) this;
        }
        public Criteria andArgsIsNull() {
            addCriterion("args is null");
            return (Criteria) this;
        }
        public Criteria andArgsIsNotNull() {
            addCriterion("args is not null");
            return (Criteria) this;
        }
        public Criteria andArgsEqualTo(String value) {
            addCriterion("args =", value, "args");
            return (Criteria) this;
        }
        public Criteria andArgsNotEqualTo(String value) {
            addCriterion("args <>", value, "args");
            return (Criteria) this;
        }
        public Criteria andArgsGreaterThan(String value) {
            addCriterion("args >", value, "args");
            return (Criteria) this;
        }
        public Criteria andArgsGreaterThanOrEqualTo(String value) {
            addCriterion("args >=", value, "args");
            return (Criteria) this;
        }
        public Criteria andArgsLessThan(String value) {
            addCriterion("args <", value, "args");
            return (Criteria) this;
        }
        public Criteria andArgsLessThanOrEqualTo(String value) {
            addCriterion("args <=", value, "args");
            return (Criteria) this;
        }
        public Criteria andArgsLike(String value) {
            addCriterion("args like", value, "args");
            return (Criteria) this;
        }
        public Criteria andArgsNotLike(String value) {
            addCriterion("args not like", value, "args");
            return (Criteria) this;
        }
        public Criteria andArgsIn(List<String> values) {
            addCriterion("args in", values, "args");
            return (Criteria) this;
        }
        public Criteria andArgsNotIn(List<String> values) {
            addCriterion("args not in", values, "args");
            return (Criteria) this;
        }
        public Criteria andArgsBetween(String value1, String value2) {
            addCriterion("args between", value1, value2, "args");
            return (Criteria) this;
        }
        public Criteria andArgsNotBetween(String value1, String value2) {
            addCriterion("args not between", value1, value2, "args");
            return (Criteria) this;
        }
        public Criteria andRunIsNull() {
            addCriterion("run is null");
            return (Criteria) this;
        }
        public Criteria andRunIsNotNull() {
            addCriterion("run is not null");
            return (Criteria) this;
        }
        public Criteria andRunEqualTo(Boolean value) {
            addCriterion("run =", value, "run");
            return (Criteria) this;
        }
        public Criteria andRunNotEqualTo(Boolean value) {
            addCriterion("run <>", value, "run");
            return (Criteria) this;
        }
        public Criteria andRunGreaterThan(Boolean value) {
            addCriterion("run >", value, "run");
            return (Criteria) this;
        }
        public Criteria andRunGreaterThanOrEqualTo(Boolean value) {
            addCriterion("run >=", value, "run");
            return (Criteria) this;
        }
        public Criteria andRunLessThan(Boolean value) {
            addCriterion("run <", value, "run");
            return (Criteria) this;
        }
        public Criteria andRunLessThanOrEqualTo(Boolean value) {
            addCriterion("run <=", value, "run");
            return (Criteria) this;
        }
        public Criteria andRunIn(List<Boolean> values) {
            addCriterion("run in", values, "run");
            return (Criteria) this;
        }
        public Criteria andRunNotIn(List<Boolean> values) {
            addCriterion("run not in", values, "run");
            return (Criteria) this;
        }
        public Criteria andRunBetween(Boolean value1, Boolean value2) {
            addCriterion("run between", value1, value2, "run");
            return (Criteria) this;
        }
        public Criteria andRunNotBetween(Boolean value1, Boolean value2) {
            addCriterion("run not between", value1, value2, "run");
            return (Criteria) this;
        }
        public Criteria andIreadIsNull() {
            addCriterion("iread is null");
            return (Criteria) this;
        }
        public Criteria andIreadIsNotNull() {
            addCriterion("iread is not null");
            return (Criteria) this;
        }
        public Criteria andIreadEqualTo(Boolean value) {
            addCriterion("iread =", value, "iread");
            return (Criteria) this;
        }
        public Criteria andIreadNotEqualTo(Boolean value) {
            addCriterion("iread <>", value, "iread");
            return (Criteria) this;
        }
        public Criteria andIreadGreaterThan(Boolean value) {
            addCriterion("iread >", value, "iread");
            return (Criteria) this;
        }
        public Criteria andIreadGreaterThanOrEqualTo(Boolean value) {
            addCriterion("iread >=", value, "iread");
            return (Criteria) this;
        }
        public Criteria andIreadLessThan(Boolean value) {
            addCriterion("iread <", value, "iread");
            return (Criteria) this;
        }
        public Criteria andIreadLessThanOrEqualTo(Boolean value) {
            addCriterion("iread <=", value, "iread");
            return (Criteria) this;
        }
        public Criteria andIreadIn(List<Boolean> values) {
            addCriterion("iread in", values, "iread");
            return (Criteria) this;
        }
        public Criteria andIreadNotIn(List<Boolean> values) {
            addCriterion("iread not in", values, "iread");
            return (Criteria) this;
        }
        public Criteria andIreadBetween(Boolean value1, Boolean value2) {
            addCriterion("iread between", value1, value2, "iread");
            return (Criteria) this;
        }
        public Criteria andIreadNotBetween(Boolean value1, Boolean value2) {
            addCriterion("iread not between", value1, value2, "iread");
            return (Criteria) this;
        }
        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }
        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }
        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }
        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }
        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }
        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }
        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }
        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }
        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }
        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }
        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }
        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
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
        public Criteria andOverdueTimeIsNull() {
            addCriterion("overdueTime is null");
            return (Criteria) this;
        }
        public Criteria andOverdueTimeIsNotNull() {
            addCriterion("overdueTime is not null");
            return (Criteria) this;
        }
        public Criteria andOverdueTimeEqualTo(Date value) {
            addCriterion("overdueTime =", value, "overdueTime");
            return (Criteria) this;
        }
        public Criteria andOverdueTimeNotEqualTo(Date value) {
            addCriterion("overdueTime <>", value, "overdueTime");
            return (Criteria) this;
        }
        public Criteria andOverdueTimeGreaterThan(Date value) {
            addCriterion("overdueTime >", value, "overdueTime");
            return (Criteria) this;
        }
        public Criteria andOverdueTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("overdueTime >=", value, "overdueTime");
            return (Criteria) this;
        }
        public Criteria andOverdueTimeLessThan(Date value) {
            addCriterion("overdueTime <", value, "overdueTime");
            return (Criteria) this;
        }
        public Criteria andOverdueTimeLessThanOrEqualTo(Date value) {
            addCriterion("overdueTime <=", value, "overdueTime");
            return (Criteria) this;
        }
        public Criteria andOverdueTimeIn(List<Date> values) {
            addCriterion("overdueTime in", values, "overdueTime");
            return (Criteria) this;
        }
        public Criteria andOverdueTimeNotIn(List<Date> values) {
            addCriterion("overdueTime not in", values, "overdueTime");
            return (Criteria) this;
        }
        public Criteria andOverdueTimeBetween(Date value1, Date value2) {
            addCriterion("overdueTime between", value1, value2, "overdueTime");
            return (Criteria) this;
        }
        public Criteria andOverdueTimeNotBetween(Date value1, Date value2) {
            addCriterion("overdueTime not between", value1, value2, "overdueTime");
            return (Criteria) this;
        }
        public Criteria andJavaBeanIsNull() {
            addCriterion("javaBean is null");
            return (Criteria) this;
        }
        public Criteria andJavaBeanIsNotNull() {
            addCriterion("javaBean is not null");
            return (Criteria) this;
        }
        public Criteria andJavaBeanEqualTo(String value) {
            addCriterion("javaBean =", value, "javaBean");
            return (Criteria) this;
        }
        public Criteria andJavaBeanNotEqualTo(String value) {
            addCriterion("javaBean <>", value, "javaBean");
            return (Criteria) this;
        }
        public Criteria andJavaBeanGreaterThan(String value) {
            addCriterion("javaBean >", value, "javaBean");
            return (Criteria) this;
        }
        public Criteria andJavaBeanGreaterThanOrEqualTo(String value) {
            addCriterion("javaBean >=", value, "javaBean");
            return (Criteria) this;
        }
        public Criteria andJavaBeanLessThan(String value) {
            addCriterion("javaBean <", value, "javaBean");
            return (Criteria) this;
        }
        public Criteria andJavaBeanLessThanOrEqualTo(String value) {
            addCriterion("javaBean <=", value, "javaBean");
            return (Criteria) this;
        }
        public Criteria andJavaBeanLike(String value) {
            addCriterion("javaBean like", value, "javaBean");
            return (Criteria) this;
        }
        public Criteria andJavaBeanNotLike(String value) {
            addCriterion("javaBean not like", value, "javaBean");
            return (Criteria) this;
        }
        public Criteria andJavaBeanIn(List<String> values) {
            addCriterion("javaBean in", values, "javaBean");
            return (Criteria) this;
        }
        public Criteria andJavaBeanNotIn(List<String> values) {
            addCriterion("javaBean not in", values, "javaBean");
            return (Criteria) this;
        }
        public Criteria andJavaBeanBetween(String value1, String value2) {
            addCriterion("javaBean between", value1, value2, "javaBean");
            return (Criteria) this;
        }
        public Criteria andJavaBeanNotBetween(String value1, String value2) {
            addCriterion("javaBean not between", value1, value2, "javaBean");
            return (Criteria) this;
        }
        public Criteria andTitleLikeInsensitive(String value) {
            addCriterion("upper(title) like", value.toUpperCase(), "title");
            return (Criteria) this;
        }
        public Criteria andContentLikeInsensitive(String value) {
            addCriterion("upper(content) like", value.toUpperCase(), "content");
            return (Criteria) this;
        }
        public Criteria andTargetUrlLikeInsensitive(String value) {
            addCriterion("upper(targetUrl) like", value.toUpperCase(), "targetUrl");
            return (Criteria) this;
        }
        public Criteria andArgsLikeInsensitive(String value) {
            addCriterion("upper(args) like", value.toUpperCase(), "args");
            return (Criteria) this;
        }
        public Criteria andJavaBeanLikeInsensitive(String value) {
            addCriterion("upper(javaBean) like", value.toUpperCase(), "javaBean");
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
     * @author 菠萝大象
     * @version 1.0 2016-04-18
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