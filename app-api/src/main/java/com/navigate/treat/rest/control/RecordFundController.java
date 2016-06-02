package com.navigate.treat.rest.control;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.navigate.treat.api.IRecordFundServiceFront;
import com.navigate.treat.base.Pages;

/**
 * 资金记录接口
 * @author fwg create by 2016年4月19日 下午3:08:54
 */
@Controller
@RequestMapping(value = "/recordFund")
public class RecordFundController {
	@Resource
	IRecordFundServiceFront recordFundServiceFront;

	/**
	 * 资金记录列表
	 * @param pages
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public Object browser( Pages<?> pages) {
		return recordFundServiceFront.select(pages);
	}
}
