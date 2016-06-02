package com.navigate.treat.io.report.request;

import java.util.Date;

public class ReportReq {

	private Long id;
	/**
	 * 举报类型 1 举报人 2 举报活动 3 举报秀场
	 */
	private Integer type;
	/**
	 * 举报ID
	 */
	private Long reportId;
	/**
	 * 描述
	 */
	private String desc;
	/**
	 * 处理结果 1 未处理 2 已经处理 3 举报被驳回
	 */
	private Integer result;
	/**
	 * 创建时间
	 */
	private Date ctime;
	/**
	 * 处理时间
	 */
	private Date mtime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Long getReportId() {
		return reportId;
	}

	public void setReportId(Long reportId) {
		this.reportId = reportId;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Integer getResult() {
		return result;
	}

	public void setResult(Integer result) {
		this.result = result;
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

}
