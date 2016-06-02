/*
 * UserInfoQueryHelper.java
 * Copyright(C) 20xx-2015 xxxxxx公司
 * All rights reserved.
 * -----------------------------------------------
 * 2015-12-02 Created
 */
package com.navigate.treat.beans.multi;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserInfoQueryHelper {

    protected String orderByClause;
    protected boolean distinct;
    protected List<Criteria> oredCriteria;

    public UserInfoQueryHelper() {
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
     * @version 1.0 2015-12-02
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
        public Criteria andVocationIsNull() {
            addCriterion("vocation is null");
            return (Criteria) this;
        }
        public Criteria andVocationIsNotNull() {
            addCriterion("vocation is not null");
            return (Criteria) this;
        }
        public Criteria andVocationEqualTo(Integer value) {
            addCriterion("vocation =", value, "vocation");
            return (Criteria) this;
        }
        public Criteria andVocationNotEqualTo(Integer value) {
            addCriterion("vocation <>", value, "vocation");
            return (Criteria) this;
        }
        public Criteria andVocationGreaterThan(Integer value) {
            addCriterion("vocation >", value, "vocation");
            return (Criteria) this;
        }
        public Criteria andVocationGreaterThanOrEqualTo(Integer value) {
            addCriterion("vocation >=", value, "vocation");
            return (Criteria) this;
        }
        public Criteria andVocationLessThan(Integer value) {
            addCriterion("vocation <", value, "vocation");
            return (Criteria) this;
        }
        public Criteria andVocationLessThanOrEqualTo(Integer value) {
            addCriterion("vocation <=", value, "vocation");
            return (Criteria) this;
        }
        public Criteria andVocationIn(List<Integer> values) {
            addCriterion("vocation in", values, "vocation");
            return (Criteria) this;
        }
        public Criteria andVocationNotIn(List<Integer> values) {
            addCriterion("vocation not in", values, "vocation");
            return (Criteria) this;
        }
        public Criteria andVocationBetween(Integer value1, Integer value2) {
            addCriterion("vocation between", value1, value2, "vocation");
            return (Criteria) this;
        }
        public Criteria andVocationNotBetween(Integer value1, Integer value2) {
            addCriterion("vocation not between", value1, value2, "vocation");
            return (Criteria) this;
        }
        public Criteria andCorpNameIsNull() {
            addCriterion("corpName is null");
            return (Criteria) this;
        }
        public Criteria andCorpNameIsNotNull() {
            addCriterion("corpName is not null");
            return (Criteria) this;
        }
        public Criteria andCorpNameEqualTo(String value) {
            addCriterion("corpName =", value, "corpName");
            return (Criteria) this;
        }
        public Criteria andCorpNameNotEqualTo(String value) {
            addCriterion("corpName <>", value, "corpName");
            return (Criteria) this;
        }
        public Criteria andCorpNameGreaterThan(String value) {
            addCriterion("corpName >", value, "corpName");
            return (Criteria) this;
        }
        public Criteria andCorpNameGreaterThanOrEqualTo(String value) {
            addCriterion("corpName >=", value, "corpName");
            return (Criteria) this;
        }
        public Criteria andCorpNameLessThan(String value) {
            addCriterion("corpName <", value, "corpName");
            return (Criteria) this;
        }
        public Criteria andCorpNameLessThanOrEqualTo(String value) {
            addCriterion("corpName <=", value, "corpName");
            return (Criteria) this;
        }
        public Criteria andCorpNameLike(String value) {
            addCriterion("corpName like", value, "corpName");
            return (Criteria) this;
        }
        public Criteria andCorpNameNotLike(String value) {
            addCriterion("corpName not like", value, "corpName");
            return (Criteria) this;
        }
        public Criteria andCorpNameIn(List<String> values) {
            addCriterion("corpName in", values, "corpName");
            return (Criteria) this;
        }
        public Criteria andCorpNameNotIn(List<String> values) {
            addCriterion("corpName not in", values, "corpName");
            return (Criteria) this;
        }
        public Criteria andCorpNameBetween(String value1, String value2) {
            addCriterion("corpName between", value1, value2, "corpName");
            return (Criteria) this;
        }
        public Criteria andCorpNameNotBetween(String value1, String value2) {
            addCriterion("corpName not between", value1, value2, "corpName");
            return (Criteria) this;
        }
        public Criteria andSchoolIsNull() {
            addCriterion("school is null");
            return (Criteria) this;
        }
        public Criteria andSchoolIsNotNull() {
            addCriterion("school is not null");
            return (Criteria) this;
        }
        public Criteria andSchoolEqualTo(String value) {
            addCriterion("school =", value, "school");
            return (Criteria) this;
        }
        public Criteria andSchoolNotEqualTo(String value) {
            addCriterion("school <>", value, "school");
            return (Criteria) this;
        }
        public Criteria andSchoolGreaterThan(String value) {
            addCriterion("school >", value, "school");
            return (Criteria) this;
        }
        public Criteria andSchoolGreaterThanOrEqualTo(String value) {
            addCriterion("school >=", value, "school");
            return (Criteria) this;
        }
        public Criteria andSchoolLessThan(String value) {
            addCriterion("school <", value, "school");
            return (Criteria) this;
        }
        public Criteria andSchoolLessThanOrEqualTo(String value) {
            addCriterion("school <=", value, "school");
            return (Criteria) this;
        }
        public Criteria andSchoolLike(String value) {
            addCriterion("school like", value, "school");
            return (Criteria) this;
        }
        public Criteria andSchoolNotLike(String value) {
            addCriterion("school not like", value, "school");
            return (Criteria) this;
        }
        public Criteria andSchoolIn(List<String> values) {
            addCriterion("school in", values, "school");
            return (Criteria) this;
        }
        public Criteria andSchoolNotIn(List<String> values) {
            addCriterion("school not in", values, "school");
            return (Criteria) this;
        }
        public Criteria andSchoolBetween(String value1, String value2) {
            addCriterion("school between", value1, value2, "school");
            return (Criteria) this;
        }
        public Criteria andSchoolNotBetween(String value1, String value2) {
            addCriterion("school not between", value1, value2, "school");
            return (Criteria) this;
        }
        public Criteria andSignatureIsNull() {
            addCriterion("signature is null");
            return (Criteria) this;
        }
        public Criteria andSignatureIsNotNull() {
            addCriterion("signature is not null");
            return (Criteria) this;
        }
        public Criteria andSignatureEqualTo(String value) {
            addCriterion("signature =", value, "signature");
            return (Criteria) this;
        }
        public Criteria andSignatureNotEqualTo(String value) {
            addCriterion("signature <>", value, "signature");
            return (Criteria) this;
        }
        public Criteria andSignatureGreaterThan(String value) {
            addCriterion("signature >", value, "signature");
            return (Criteria) this;
        }
        public Criteria andSignatureGreaterThanOrEqualTo(String value) {
            addCriterion("signature >=", value, "signature");
            return (Criteria) this;
        }
        public Criteria andSignatureLessThan(String value) {
            addCriterion("signature <", value, "signature");
            return (Criteria) this;
        }
        public Criteria andSignatureLessThanOrEqualTo(String value) {
            addCriterion("signature <=", value, "signature");
            return (Criteria) this;
        }
        public Criteria andSignatureLike(String value) {
            addCriterion("signature like", value, "signature");
            return (Criteria) this;
        }
        public Criteria andSignatureNotLike(String value) {
            addCriterion("signature not like", value, "signature");
            return (Criteria) this;
        }
        public Criteria andSignatureIn(List<String> values) {
            addCriterion("signature in", values, "signature");
            return (Criteria) this;
        }
        public Criteria andSignatureNotIn(List<String> values) {
            addCriterion("signature not in", values, "signature");
            return (Criteria) this;
        }
        public Criteria andSignatureBetween(String value1, String value2) {
            addCriterion("signature between", value1, value2, "signature");
            return (Criteria) this;
        }
        public Criteria andSignatureNotBetween(String value1, String value2) {
            addCriterion("signature not between", value1, value2, "signature");
            return (Criteria) this;
        }
        public Criteria andInterestIsNull() {
            addCriterion("interest is null");
            return (Criteria) this;
        }
        public Criteria andInterestIsNotNull() {
            addCriterion("interest is not null");
            return (Criteria) this;
        }
        public Criteria andInterestEqualTo(Integer value) {
            addCriterion("interest =", value, "interest");
            return (Criteria) this;
        }
        public Criteria andInterestNotEqualTo(Integer value) {
            addCriterion("interest <>", value, "interest");
            return (Criteria) this;
        }
        public Criteria andInterestGreaterThan(Integer value) {
            addCriterion("interest >", value, "interest");
            return (Criteria) this;
        }
        public Criteria andInterestGreaterThanOrEqualTo(Integer value) {
            addCriterion("interest >=", value, "interest");
            return (Criteria) this;
        }
        public Criteria andInterestLessThan(Integer value) {
            addCriterion("interest <", value, "interest");
            return (Criteria) this;
        }
        public Criteria andInterestLessThanOrEqualTo(Integer value) {
            addCriterion("interest <=", value, "interest");
            return (Criteria) this;
        }
        public Criteria andInterestIn(List<Integer> values) {
            addCriterion("interest in", values, "interest");
            return (Criteria) this;
        }
        public Criteria andInterestNotIn(List<Integer> values) {
            addCriterion("interest not in", values, "interest");
            return (Criteria) this;
        }
        public Criteria andInterestBetween(Integer value1, Integer value2) {
            addCriterion("interest between", value1, value2, "interest");
            return (Criteria) this;
        }
        public Criteria andInterestNotBetween(Integer value1, Integer value2) {
            addCriterion("interest not between", value1, value2, "interest");
            return (Criteria) this;
        }
        public Criteria andCityCodeIsNull() {
            addCriterion("cityCode is null");
            return (Criteria) this;
        }
        public Criteria andCityCodeIsNotNull() {
            addCriterion("cityCode is not null");
            return (Criteria) this;
        }
        public Criteria andCityCodeEqualTo(String value) {
            addCriterion("cityCode =", value, "cityCode");
            return (Criteria) this;
        }
        public Criteria andCityCodeNotEqualTo(String value) {
            addCriterion("cityCode <>", value, "cityCode");
            return (Criteria) this;
        }
        public Criteria andCityCodeGreaterThan(String value) {
            addCriterion("cityCode >", value, "cityCode");
            return (Criteria) this;
        }
        public Criteria andCityCodeGreaterThanOrEqualTo(String value) {
            addCriterion("cityCode >=", value, "cityCode");
            return (Criteria) this;
        }
        public Criteria andCityCodeLessThan(String value) {
            addCriterion("cityCode <", value, "cityCode");
            return (Criteria) this;
        }
        public Criteria andCityCodeLessThanOrEqualTo(String value) {
            addCriterion("cityCode <=", value, "cityCode");
            return (Criteria) this;
        }
        public Criteria andCityCodeLike(String value) {
            addCriterion("cityCode like", value, "cityCode");
            return (Criteria) this;
        }
        public Criteria andCityCodeNotLike(String value) {
            addCriterion("cityCode not like", value, "cityCode");
            return (Criteria) this;
        }
        public Criteria andCityCodeIn(List<String> values) {
            addCriterion("cityCode in", values, "cityCode");
            return (Criteria) this;
        }
        public Criteria andCityCodeNotIn(List<String> values) {
            addCriterion("cityCode not in", values, "cityCode");
            return (Criteria) this;
        }
        public Criteria andCityCodeBetween(String value1, String value2) {
            addCriterion("cityCode between", value1, value2, "cityCode");
            return (Criteria) this;
        }
        public Criteria andCityCodeNotBetween(String value1, String value2) {
            addCriterion("cityCode not between", value1, value2, "cityCode");
            return (Criteria) this;
        }
        public Criteria andProvinceCodeIsNull() {
            addCriterion("provinceCode is null");
            return (Criteria) this;
        }
        public Criteria andProvinceCodeIsNotNull() {
            addCriterion("provinceCode is not null");
            return (Criteria) this;
        }
        public Criteria andProvinceCodeEqualTo(String value) {
            addCriterion("provinceCode =", value, "provinceCode");
            return (Criteria) this;
        }
        public Criteria andProvinceCodeNotEqualTo(String value) {
            addCriterion("provinceCode <>", value, "provinceCode");
            return (Criteria) this;
        }
        public Criteria andProvinceCodeGreaterThan(String value) {
            addCriterion("provinceCode >", value, "provinceCode");
            return (Criteria) this;
        }
        public Criteria andProvinceCodeGreaterThanOrEqualTo(String value) {
            addCriterion("provinceCode >=", value, "provinceCode");
            return (Criteria) this;
        }
        public Criteria andProvinceCodeLessThan(String value) {
            addCriterion("provinceCode <", value, "provinceCode");
            return (Criteria) this;
        }
        public Criteria andProvinceCodeLessThanOrEqualTo(String value) {
            addCriterion("provinceCode <=", value, "provinceCode");
            return (Criteria) this;
        }
        public Criteria andProvinceCodeLike(String value) {
            addCriterion("provinceCode like", value, "provinceCode");
            return (Criteria) this;
        }
        public Criteria andProvinceCodeNotLike(String value) {
            addCriterion("provinceCode not like", value, "provinceCode");
            return (Criteria) this;
        }
        public Criteria andProvinceCodeIn(List<String> values) {
            addCriterion("provinceCode in", values, "provinceCode");
            return (Criteria) this;
        }
        public Criteria andProvinceCodeNotIn(List<String> values) {
            addCriterion("provinceCode not in", values, "provinceCode");
            return (Criteria) this;
        }
        public Criteria andProvinceCodeBetween(String value1, String value2) {
            addCriterion("provinceCode between", value1, value2, "provinceCode");
            return (Criteria) this;
        }
        public Criteria andProvinceCodeNotBetween(String value1, String value2) {
            addCriterion("provinceCode not between", value1, value2, "provinceCode");
            return (Criteria) this;
        }
        public Criteria andAllureValueIsNull() {
            addCriterion("allureValue is null");
            return (Criteria) this;
        }
        public Criteria andAllureValueIsNotNull() {
            addCriterion("allureValue is not null");
            return (Criteria) this;
        }
        public Criteria andAllureValueEqualTo(Integer value) {
            addCriterion("allureValue =", value, "allureValue");
            return (Criteria) this;
        }
        public Criteria andAllureValueNotEqualTo(Integer value) {
            addCriterion("allureValue <>", value, "allureValue");
            return (Criteria) this;
        }
        public Criteria andAllureValueGreaterThan(Integer value) {
            addCriterion("allureValue >", value, "allureValue");
            return (Criteria) this;
        }
        public Criteria andAllureValueGreaterThanOrEqualTo(Integer value) {
            addCriterion("allureValue >=", value, "allureValue");
            return (Criteria) this;
        }
        public Criteria andAllureValueLessThan(Integer value) {
            addCriterion("allureValue <", value, "allureValue");
            return (Criteria) this;
        }
        public Criteria andAllureValueLessThanOrEqualTo(Integer value) {
            addCriterion("allureValue <=", value, "allureValue");
            return (Criteria) this;
        }
        public Criteria andAllureValueIn(List<Integer> values) {
            addCriterion("allureValue in", values, "allureValue");
            return (Criteria) this;
        }
        public Criteria andAllureValueNotIn(List<Integer> values) {
            addCriterion("allureValue not in", values, "allureValue");
            return (Criteria) this;
        }
        public Criteria andAllureValueBetween(Integer value1, Integer value2) {
            addCriterion("allureValue between", value1, value2, "allureValue");
            return (Criteria) this;
        }
        public Criteria andAllureValueNotBetween(Integer value1, Integer value2) {
            addCriterion("allureValue not between", value1, value2, "allureValue");
            return (Criteria) this;
        }
        public Criteria andTechniqueValueIsNull() {
            addCriterion("techniqueValue is null");
            return (Criteria) this;
        }
        public Criteria andTechniqueValueIsNotNull() {
            addCriterion("techniqueValue is not null");
            return (Criteria) this;
        }
        public Criteria andTechniqueValueEqualTo(Integer value) {
            addCriterion("techniqueValue =", value, "techniqueValue");
            return (Criteria) this;
        }
        public Criteria andTechniqueValueNotEqualTo(Integer value) {
            addCriterion("techniqueValue <>", value, "techniqueValue");
            return (Criteria) this;
        }
        public Criteria andTechniqueValueGreaterThan(Integer value) {
            addCriterion("techniqueValue >", value, "techniqueValue");
            return (Criteria) this;
        }
        public Criteria andTechniqueValueGreaterThanOrEqualTo(Integer value) {
            addCriterion("techniqueValue >=", value, "techniqueValue");
            return (Criteria) this;
        }
        public Criteria andTechniqueValueLessThan(Integer value) {
            addCriterion("techniqueValue <", value, "techniqueValue");
            return (Criteria) this;
        }
        public Criteria andTechniqueValueLessThanOrEqualTo(Integer value) {
            addCriterion("techniqueValue <=", value, "techniqueValue");
            return (Criteria) this;
        }
        public Criteria andTechniqueValueIn(List<Integer> values) {
            addCriterion("techniqueValue in", values, "techniqueValue");
            return (Criteria) this;
        }
        public Criteria andTechniqueValueNotIn(List<Integer> values) {
            addCriterion("techniqueValue not in", values, "techniqueValue");
            return (Criteria) this;
        }
        public Criteria andTechniqueValueBetween(Integer value1, Integer value2) {
            addCriterion("techniqueValue between", value1, value2, "techniqueValue");
            return (Criteria) this;
        }
        public Criteria andTechniqueValueNotBetween(Integer value1, Integer value2) {
            addCriterion("techniqueValue not between", value1, value2, "techniqueValue");
            return (Criteria) this;
        }
        public Criteria andBalanceIsNull() {
            addCriterion("balance is null");
            return (Criteria) this;
        }
        public Criteria andBalanceIsNotNull() {
            addCriterion("balance is not null");
            return (Criteria) this;
        }
        public Criteria andBalanceEqualTo(BigDecimal value) {
            addCriterion("balance =", value, "balance");
            return (Criteria) this;
        }
        public Criteria andBalanceNotEqualTo(BigDecimal value) {
            addCriterion("balance <>", value, "balance");
            return (Criteria) this;
        }
        public Criteria andBalanceGreaterThan(BigDecimal value) {
            addCriterion("balance >", value, "balance");
            return (Criteria) this;
        }
        public Criteria andBalanceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("balance >=", value, "balance");
            return (Criteria) this;
        }
        public Criteria andBalanceLessThan(BigDecimal value) {
            addCriterion("balance <", value, "balance");
            return (Criteria) this;
        }
        public Criteria andBalanceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("balance <=", value, "balance");
            return (Criteria) this;
        }
        public Criteria andBalanceIn(List<BigDecimal> values) {
            addCriterion("balance in", values, "balance");
            return (Criteria) this;
        }
        public Criteria andBalanceNotIn(List<BigDecimal> values) {
            addCriterion("balance not in", values, "balance");
            return (Criteria) this;
        }
        public Criteria andBalanceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("balance between", value1, value2, "balance");
            return (Criteria) this;
        }
        public Criteria andBalanceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("balance not between", value1, value2, "balance");
            return (Criteria) this;
        }
        public Criteria andTechniqueIsNull() {
            addCriterion("technique is null");
            return (Criteria) this;
        }
        public Criteria andTechniqueIsNotNull() {
            addCriterion("technique is not null");
            return (Criteria) this;
        }
        public Criteria andTechniqueEqualTo(Integer value) {
            addCriterion("technique =", value, "technique");
            return (Criteria) this;
        }
        public Criteria andTechniqueNotEqualTo(Integer value) {
            addCriterion("technique <>", value, "technique");
            return (Criteria) this;
        }
        public Criteria andTechniqueGreaterThan(Integer value) {
            addCriterion("technique >", value, "technique");
            return (Criteria) this;
        }
        public Criteria andTechniqueGreaterThanOrEqualTo(Integer value) {
            addCriterion("technique >=", value, "technique");
            return (Criteria) this;
        }
        public Criteria andTechniqueLessThan(Integer value) {
            addCriterion("technique <", value, "technique");
            return (Criteria) this;
        }
        public Criteria andTechniqueLessThanOrEqualTo(Integer value) {
            addCriterion("technique <=", value, "technique");
            return (Criteria) this;
        }
        public Criteria andTechniqueIn(List<Integer> values) {
            addCriterion("technique in", values, "technique");
            return (Criteria) this;
        }
        public Criteria andTechniqueNotIn(List<Integer> values) {
            addCriterion("technique not in", values, "technique");
            return (Criteria) this;
        }
        public Criteria andTechniqueBetween(Integer value1, Integer value2) {
            addCriterion("technique between", value1, value2, "technique");
            return (Criteria) this;
        }
        public Criteria andTechniqueNotBetween(Integer value1, Integer value2) {
            addCriterion("technique not between", value1, value2, "technique");
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
        public Criteria andCorpNameLikeInsensitive(String value) {
            addCriterion("upper(corpName) like", value.toUpperCase(), "corpName");
            return (Criteria) this;
        }
        public Criteria andSchoolLikeInsensitive(String value) {
            addCriterion("upper(school) like", value.toUpperCase(), "school");
            return (Criteria) this;
        }
        public Criteria andSignatureLikeInsensitive(String value) {
            addCriterion("upper(signature) like", value.toUpperCase(), "signature");
            return (Criteria) this;
        }
        public Criteria andCityCodeLikeInsensitive(String value) {
            addCriterion("upper(cityCode) like", value.toUpperCase(), "cityCode");
            return (Criteria) this;
        }
        public Criteria andProvinceCodeLikeInsensitive(String value) {
            addCriterion("upper(provinceCode) like", value.toUpperCase(), "provinceCode");
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
     * @version 1.0 2015-12-02
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