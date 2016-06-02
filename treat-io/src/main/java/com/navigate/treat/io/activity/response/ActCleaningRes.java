package com.navigate.treat.io.activity.response;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 
 * 活动清算完成返回对象
 * 
 *         
 */
public class ActCleaningRes implements Serializable {
	
	//担保金流向
	public enum  EsecuredFlow {
			
		ReM,//退发起者担保金
		ReF,//退参与者担保金
		ReMGetF,//退发起者收者担保金
		ReFGetM,//退参与者收发起者
		ReBoth,//退双方单保金
		
		
	}
	//补贴流向
	public enum  EsubsidieFlow {
		
		M,//退发起补贴
		F,//领取发起者补贴
	}
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	private  EsecuredFlow securedFlow;
	/**
	 * 退发起者担保金用户ID
	 */
	private String masterUid;
	/**
	 * 发起者担保金
	 */
	private BigDecimal masterAmountSecured;
	
	
	/**
	 * 退参与者担保金用户ID
	 */
	private String[] followerUid;
	/**
	 * 退参与者担保金
	 */
	private BigDecimal[] followerAmountSecured;
	
	
	/**
	 * 赴约补贴用户
	 */
	private String[] subsidiesUid;
	/**
	 * 退赴约补贴
	 */
	private BigDecimal  subsidies;
	/**
	 * 赴约补贴.１：退发，２参领
	 * @return
	 */
	private EsubsidieFlow subsidieFlow;
	
	public EsecuredFlow getSecuredFlow() {
		return securedFlow;
	}
	public void setSecuredFlow(EsecuredFlow securedFlow) {
		this.securedFlow = securedFlow;
	}
	public String getMasterUid() {
		return masterUid;
	}
	public void setMasterUid(String masterUid) {
		this.masterUid = masterUid;
	}
	public BigDecimal getMasterAmountSecured() {
		return masterAmountSecured;
	}
	public void setMasterAmountSecured(BigDecimal masterAmountSecured) {
		this.masterAmountSecured = masterAmountSecured;
	}
	public String[] getFollowerUid() {
		return followerUid;
	}
	public void setFollowerUid(String[] followerUid) {
		this.followerUid = followerUid;
	}
	public BigDecimal[] getFollowerAmountSecured() {
		return followerAmountSecured;
	}
	public void setFollowerAmountSecured(BigDecimal[] followerAmountSecured) {
		this.followerAmountSecured = followerAmountSecured;
	}
	public String[] getSubsidiesUid() {
		return subsidiesUid;
	}
	public void setSubsidiesUid(String[] subsidiesUid) {
		this.subsidiesUid = subsidiesUid;
	}
	public BigDecimal getSubsidies() {
		return subsidies;
	}
	public void setSubsidies(BigDecimal subsidies) {
		this.subsidies = subsidies;
	}
	public EsubsidieFlow getSubsidieFlow() {
		return subsidieFlow;
	}
	public void setSubsidieFlow(EsubsidieFlow subsidieFlow) {
		this.subsidieFlow = subsidieFlow;
	}
	
	
	
	
	
}
