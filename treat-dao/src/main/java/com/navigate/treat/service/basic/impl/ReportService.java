package com.navigate.treat.service.basic.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.navigate.treat.base.service.single.BaseServiceImp;
import com.navigate.treat.beans.basic.Report;
import com.navigate.treat.beans.basic.ReportQueryHelper;
import com.navigate.treat.dao.basic.ReportMapper;
import com.navigate.treat.service.basic.IReportService;

@Service
public class ReportService extends BaseServiceImp<Report, ReportQueryHelper>
		implements IReportService {
	ReportMapper ReportMapper;

	@Autowired
	public void setReportMapper(ReportMapper ReportMapper) {
		this.ReportMapper = ReportMapper;
		super.setBaseMapper(baseMapper);
	}
	
	
}
