package com.navigate.treat.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.LogManager;import org.apache.logging.log4j.Logger;
import org.springframework.ui.ModelMap;

import com.navigate.treat.up.HeadVo;

public class JsonExecutor {
	
	private static final Logger logger = LogManager.getLogger("JsonExecutor");

	public static ModelMap execute(Object object, HeadVo vo) {
		try {
			logger.error(object.toString());
			return transfer(object, vo);
		} catch (Exception e) {
			logger.error("object exception !" + e.getMessage());
			return transfer(object, vo);
		}

	}

	private static ModelMap transfer(Object object, HeadVo vo) {
		ModelMap model = new ModelMap();

		model.addAttribute(Constants.API, vo.getApi());
		model.addAttribute(Constants.V, Constants.VERSION);
		model.addAttribute(Constants.RESULT, vo.getResponseUtil().getResult());
		model.addAttribute(Constants.MSG, vo.getResponseUtil().getMsg());
		model.addAttribute(Constants.DESC, vo.getResponseUtil().getDesc());
		if(object != null){
			model.addAttribute(Constants.DATA, object);
		}

		if (vo.getsId() != null) {
			model.addAttribute(Constants.SID, vo.getsId());
		}

		if (vo.getResponseUtil().getResult() == 205) {
			model.put(Constants.SYSTIME, DateUtil.getSysTime());
		}

		logger.debug(model);
		return model;
	}

}
