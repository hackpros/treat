package com.navigate.treat.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.navigate.treat.po.basic.FundRecord;
import com.navigate.treat.po.basic.FundRecordVo;
import com.navigate.treat.po.multi.Users;
import com.navigate.treat.service.FundRecordService;
import com.navigate.treat.service.UserService;
import com.navigate.treat.util.SpringBeanUtils;


@Controller
public class FundController extends BaseController {
	private static final Logger logger =  LogManager.getLogger(FundController.class.getName());
	@Autowired
	private UserService userService;
	@Autowired
	private FundRecordService fundRecordService;

	/**
	 * 获取资金记录
	 * @param req
	 * @param resp
	 * @param fundRecordVo
	 * @return
	 */
	@RequestMapping(value = "fund/getFundRecordList.do")
	@ResponseBody
	public Map<String, Object> getFundRecordList(HttpServletRequest req, HttpServletResponse resp, FundRecordVo fundRecordVo) {
		logger.debug(fundRecordVo.toString());
		if(fundRecordVo.getMobile() != null && !"".equals(fundRecordVo.getMobile())){
			List<Users> UsersList = userService.getUserByMobile(fundRecordVo.getMobile());
			if(UsersList != null && UsersList.size()>0){
				fundRecordVo.setUserId(UsersList.get(0).getUserId());
			}else{
				Map<String, Object> map = new HashMap<String, Object>();
				List<FundRecord> fundRecordList = new ArrayList<FundRecord>();
				map.put("fundRecordList", fundRecordList);
				map.put("total", 0);
				return map;
			}
		}
		
		List<FundRecord> fundRecordList = fundRecordService.getFsundRecordList(fundRecordVo);
		PageInfo<FundRecord> page = new PageInfo<FundRecord>(fundRecordList);
		
		Map<String, Object> mapMod = new HashMap<String, Object>();
		mapMod.put("fundRecordList", page.getList());
		mapMod.put("total", page.getTotal());
		return mapMod;
	}
	
	//获取提现列表
	@RequestMapping(value = "fund/getWithdrawList.do")
	@ResponseBody
	public Map<String, Object> getWithdrawList(HttpServletRequest req, HttpServletResponse resp, FundRecordVo fundRecordVo) {
		fundRecordVo.setPlusMinus(3);
		if(fundRecordVo.getMobile() != null && !"".equals(fundRecordVo.getMobile())){
			List<Users> UsersList = userService.getUserByMobile(fundRecordVo.getMobile());
			if(UsersList != null && UsersList.size()>0){
				fundRecordVo.setUserId(UsersList.get(0).getUserId());
			}else{
				Map<String, Object> map = new HashMap<String, Object>();
				List<FundRecord> withdrawList = new ArrayList<FundRecord>();
				map.put("withdrawList", withdrawList);
				map.put("total", 0);
				return map;
			}
		}
		
		List<FundRecord> withdrawList = fundRecordService.getWithdrawList(fundRecordVo);
		PageInfo<FundRecord> page = new PageInfo<FundRecord>(withdrawList);
		
		List<FundRecordVo> withdrawInfoList = new ArrayList<FundRecordVo>();
		for(int i=0;i<withdrawList.size();i++){
			List<Users> userList = userService.getUserByUserId(withdrawList.get(i).getUserId());
			if(userList != null && userList.size()>0){
				FundRecordVo withdrawInfo = new FundRecordVo();
				SpringBeanUtils.copyProperties(withdrawList.get(i), withdrawInfo);
				withdrawInfo.setMobile(userList.get(0).getMobile());
				withdrawInfo.setNickName(userList.get(0).getNickName());
				withdrawInfoList.add(withdrawInfo);
			}
		}
		
		Map<String, Object> mapMod = new HashMap<String, Object>();
		mapMod.put("withdrawList", withdrawInfoList);
		mapMod.put("total", page.getTotal());
		return mapMod;
	}
	
	/**
	 * 更改提现状态
	 */
	@RequestMapping(value = "fund/updateWithdrawStatus.do")
	@ResponseBody
	public String getWithdrawList(HttpServletRequest req, HttpServletResponse resp) {
		String ids = req.getParameter("ids");
		String withdrawStatus = req.getParameter("withdrawStatus");
		String[] idArr = ids.split(",");
		FundRecord fundRecord = new FundRecord();
		for(int i=0;i<idArr.length;i++){
			fundRecord.setId(Long.parseLong(idArr[i]));
			fundRecord.setWithdrawStatus(Integer.parseInt(withdrawStatus));
			fundRecordService.updateFundRecordByPrimaryKeySelective(fundRecord);
		}
		return "ok";
	}
}
