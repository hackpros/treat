package com.navigate.treat.rest.control;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.navigate.treat.api.IReportServiceFront;
import com.navigate.treat.base.contorl.BaseController;
import com.navigate.treat.io.report.request.ReportReq;

@Controller
@RequestMapping(value = "/report")
public class ReportController extends BaseController {
	@Resource
	IReportServiceFront reportServiceFront;

	@RequestMapping(value = "/reported", method = RequestMethod.POST)
	@ResponseBody
	public Object reported(@RequestBody @Validated ReportReq reportReq) {
		return reportServiceFront.saveReport(reportReq);
	}
}
