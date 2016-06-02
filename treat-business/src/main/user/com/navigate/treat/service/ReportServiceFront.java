package com.navigate.treat.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.navigate.treat.api.IReportServiceFront;
import com.navigate.treat.beans.basic.Report;
import com.navigate.treat.io.report.request.ReportReq;
import com.navigate.treat.service.basic.impl.ReportService;
import com.navigate.treat.util.SpringBeanUtils;

@Service
public class ReportServiceFront implements IReportServiceFront {

	@Resource
	ReportService reportService;

	@Override
	public Object saveReport(ReportReq reportReq) {
		Report report = new Report();
		SpringBeanUtils.copyProperties(reportReq, report);
		return new ModelMap().addAttribute("status", reportService.insertSelective(report) > 0);
	}

}
