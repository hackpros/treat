package com.navigate.treat.io.report.helper;

/**
 * 
 * @author huangshiping
 * 
 */
public class ReportHelper {

	/**
	 * 
	 * 举报类型
	 */
	public enum ReportType {
		OCCUPY, // 占位符
		REPORT_PERSON, // 举报人
		REPORT_ACT, // 举报活动
		REPORT_SHOWS;// 举报动态
	}

	/**
	 * 
	 * 举报处理结果
	 */
	public enum ReportResult {
		OCCUPY, // 占位符
		UNTREATED, // 未处理
		PROCESSED, // 已处理
		DISMISSED;// 驳回
	}
}
