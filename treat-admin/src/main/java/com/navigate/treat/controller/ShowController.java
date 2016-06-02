package com.navigate.treat.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.navigate.treat.po.basic.PointPraiseRanking;
import com.navigate.treat.po.basic.Shows;
import com.navigate.treat.po.basic.ShowsVo;
import com.navigate.treat.po.multi.Users;
import com.navigate.treat.service.PointPraiseRankingService;
import com.navigate.treat.service.ShowPraiseService;
import com.navigate.treat.service.ShowService;
import com.navigate.treat.service.UserService;


@Controller
public class ShowController extends BaseController {

	@Autowired
	private ShowService showService;
	@Autowired
	private UserService userService;
	@Autowired
	private ShowPraiseService showPraiseService;
	@Autowired
	private PointPraiseRankingService pointPraiseRankingService;

	/**
	 * 获取秀场列表
	 * 
	 * @param req
	 * @param resp
	 * @return
	 */
	@RequestMapping(value = "show/getShowList.do")
	@ResponseBody
	public Map<String, Object> getShowList(HttpServletRequest req, HttpServletResponse resp, ShowsVo showsVo) {
		if(showsVo.getMobile() != null && !"".equals(showsVo.getMobile())){
			List<Users> UsersList = userService.getUserByMobile(showsVo.getMobile());
			if(UsersList != null && UsersList.size()>0){
				showsVo.setUserId(UsersList.get(0).getUserId());
			}else{
				Map<String, Object> map = new HashMap<String, Object>();
				List<Shows> showList = new ArrayList<Shows>();
				map.put("showList", showList);
				map.put("total", 0);
				return map;
			}
		}
		List<Shows> showList = showService.getShowList(showsVo);
		PageInfo<Shows> page = new PageInfo<Shows>(showList);
		
		Map<String, Object> mapMod = new HashMap<String, Object>();
		mapMod.put("showList", page.getList());
		mapMod.put("total", page.getTotal());
		return mapMod;
	}
	/**
	 * 更改秀场状态
	 * @param req
	 * @param resp
	 * @return
	 */
	@RequestMapping(value = "show/changeStatus.do")
	@ResponseBody
	public String changeStatus(HttpServletRequest req, HttpServletResponse resp) {
		String ids = req.getParameter("ids");
		int status = Integer.parseInt(req.getParameter("status"));
		String[] idList = ids.split(",");
		for(int i=0;i<idList.length;i++){
			showService.changeStatus(idList[i], status);
		}
		if(status == 3){
			for(int i=0;i<idList.length;i++){
				//MongoDB.delShows4Id(Long.parseLong(idList[i]));
			}
		}
//		Map<String, Object> mapMod = new HashMap<String, Object>();
		return "ok";
	}
	
	/**
	 * 获取前一天的秀场排名数据，一天跑一次该任务
	 * @param req
	 * @param resp
	 */
	@RequestMapping(value = "show/CountShowPraise4yesterday.do")
	@ResponseBody
	public void CountShowPraise4yesterday(HttpServletRequest req, HttpServletResponse resp) {
//		Calendar c = Calendar.getInstance();
//		c.set(Calendar.HOUR_OF_DAY, 0);
//		c.set(Calendar.MINUTE, 0);
//		c.set(Calendar.SECOND, 0);
//		c.set(Calendar.MILLISECOND, 0);
//		Date endDay = c.getTime();
//		c.add(Calendar.DAY_OF_YEAR, -1);
//		Date startDay = c.getTime();
//		Map<String,Object> map = new HashMap<String, Object>();
//		map.put("startDay", startDay);
//		map.put("endDay", endDay);
		//获取startDay和endDay
		Map<String,Object> map = getStartDayAndEndDay();
		//获取城市列表
		List<String> cityCodeList = showPraiseService.getCityCodesList(map);
		//循环获取各个城市的秀场排名前七名
		if(cityCodeList != null && cityCodeList.size()>0){
			for(int i=0;i<cityCodeList.size();i++){
				map.put("cityCode", cityCodeList.get(i));
				List<PointPraiseRanking> rankList = pointPraiseRankingService.getRankList(map);
				//向秀场排名表插入前一天各城市的秀场排名
				addRankList(rankList);
			}
		}
		//删除七天前的数据
		delete7daysAgo();
	}
	
	//获取startDay和endDay
	private Map<String,Object> getStartDayAndEndDay(){
		Calendar c = Calendar.getInstance();
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		c.set(Calendar.MILLISECOND, 0);
		Date endDay = c.getTime();
		c.add(Calendar.DAY_OF_YEAR, -1);
		Date startDay = c.getTime();
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("startDay", startDay);
		map.put("endDay", endDay);
		return map;
	}
	
	//删除其七天之前的数据
	private void delete7daysAgo(){
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DAY_OF_YEAR, -6);
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		c.set(Calendar.MILLISECOND, 0);
		Date limitDate = c.getTime();
//		Map<String,Object> map = new HashMap<String, Object>();
//		map.put("limitDate", limitDate);
		pointPraiseRankingService.delete7daysAgo(limitDate);
	}
	//向秀场排名表插入前一天各城市的秀场排名
	private void addRankList(List<PointPraiseRanking> rankList){
		if(rankList != null && rankList.size()>0){
			for(int i=0;i<rankList.size();i++){
				pointPraiseRankingService.addRank(rankList.get(i));
			}
		}
	}
	
}
