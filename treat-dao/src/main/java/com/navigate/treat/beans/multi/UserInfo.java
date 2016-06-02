/*
 * UserInfo.java
 * Copyright(C) 20xx-2015 xxxxxx公司
 * All rights reserved.
 * -----------------------------------------------
 * 2015-12-02 Created
 */
package com.navigate.treat.beans.multi;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 
 * 
 * @author 菠萝大象
 * @version 1.0 2015-12-02
 */
public class UserInfo implements Serializable {

    private Long id;
    /**
     * ҵ
     */
    private Long userId;
    private Integer vocation;
    private String corpName;
    /**
     * ѧУ
     */
    private String school;
    private String signature;
    private Long interest;
    private String cityCode;
    /**
     * ʡ
     */
    private String provinceCode;
    private Integer allureValue;
    private Integer techniqueValue;
    private BigDecimal balance;
    private Integer technique;
    private Date ctime;
    private Date mtime;
    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Long getUserId() {
        return userId;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
    }
    public Integer getVocation() {
        return vocation;
    }
    public void setVocation(Integer vocation) {
        this.vocation = vocation;
    }
    public String getCorpName() {
        return corpName;
    }
    public void setCorpName(String corpName) {
        this.corpName = corpName == null ? null : corpName.trim();
    }
    public String getSchool() {
        return school;
    }
    public void setSchool(String school) {
        this.school = school == null ? null : school.trim();
    }
    public String getSignature() {
        return signature;
    }
    public void setSignature(String signature) {
        this.signature = signature == null ? null : signature.trim();
    }
    public Long getInterest() {
        return interest;
    }
    public void setInterest(Long interest) {
        this.interest = interest;
    }
    public String getCityCode() {
        return cityCode;
    }
    public void setCityCode(String cityCode) {
        this.cityCode = cityCode == null ? null : cityCode.trim();
    }
    public String getProvinceCode() {
        return provinceCode;
    }
    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode == null ? null : provinceCode.trim();
    }
    public Integer getAllureValue() {
        return allureValue;
    }
    public void setAllureValue(Integer allureValue) {
        this.allureValue = allureValue;
    }
    public Integer getTechniqueValue() {
        return techniqueValue;
    }
    public void setTechniqueValue(Integer techniqueValue) {
        this.techniqueValue = techniqueValue;
    }
    public BigDecimal getBalance() {
        return balance;
    }
    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
    public Integer getTechnique() {
        return technique;
    }
    public void setTechnique(Integer technique) {
        this.technique = technique;
    }
    public Date getCtime() {
        return ctime;
    }
    public void setCtime(Date ctime) {
        this.ctime = ctime;
    }
    public Date getMtime() {
        return mtime;
    }
    public void setMtime(Date mtime) {
        this.mtime = mtime;
    }
    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        UserInfo other = (UserInfo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getVocation() == null ? other.getVocation() == null : this.getVocation().equals(other.getVocation()))
            && (this.getCorpName() == null ? other.getCorpName() == null : this.getCorpName().equals(other.getCorpName()))
            && (this.getSchool() == null ? other.getSchool() == null : this.getSchool().equals(other.getSchool()))
            && (this.getSignature() == null ? other.getSignature() == null : this.getSignature().equals(other.getSignature()))
            && (this.getInterest() == null ? other.getInterest() == null : this.getInterest().equals(other.getInterest()))
            && (this.getCityCode() == null ? other.getCityCode() == null : this.getCityCode().equals(other.getCityCode()))
            && (this.getProvinceCode() == null ? other.getProvinceCode() == null : this.getProvinceCode().equals(other.getProvinceCode()))
            && (this.getAllureValue() == null ? other.getAllureValue() == null : this.getAllureValue().equals(other.getAllureValue()))
            && (this.getTechniqueValue() == null ? other.getTechniqueValue() == null : this.getTechniqueValue().equals(other.getTechniqueValue()))
            && (this.getBalance() == null ? other.getBalance() == null : this.getBalance().equals(other.getBalance()))
            && (this.getTechnique() == null ? other.getTechnique() == null : this.getTechnique().equals(other.getTechnique()))
            && (this.getCtime() == null ? other.getCtime() == null : this.getCtime().equals(other.getCtime()))
            && (this.getMtime() == null ? other.getMtime() == null : this.getMtime().equals(other.getMtime()));
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getVocation() == null) ? 0 : getVocation().hashCode());
        result = prime * result + ((getCorpName() == null) ? 0 : getCorpName().hashCode());
        result = prime * result + ((getSchool() == null) ? 0 : getSchool().hashCode());
        result = prime * result + ((getSignature() == null) ? 0 : getSignature().hashCode());
        result = prime * result + ((getInterest() == null) ? 0 : getInterest().hashCode());
        result = prime * result + ((getCityCode() == null) ? 0 : getCityCode().hashCode());
        result = prime * result + ((getProvinceCode() == null) ? 0 : getProvinceCode().hashCode());
        result = prime * result + ((getAllureValue() == null) ? 0 : getAllureValue().hashCode());
        result = prime * result + ((getTechniqueValue() == null) ? 0 : getTechniqueValue().hashCode());
        result = prime * result + ((getBalance() == null) ? 0 : getBalance().hashCode());
        result = prime * result + ((getTechnique() == null) ? 0 : getTechnique().hashCode());
        result = prime * result + ((getCtime() == null) ? 0 : getCtime().hashCode());
        result = prime * result + ((getMtime() == null) ? 0 : getMtime().hashCode());
        return result;
    }
}