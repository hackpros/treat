package com.navigate.treat.timedtask;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.navigate.treat.dao.basicMapper.PointPraiseRankingMapper;
import com.navigate.treat.dao.basicMapper.ShowPraiseMapper;
import com.navigate.treat.po.basic.PointPraiseRanking;
import com.navigate.treat.po.basic.PointPraiseRankingExample;
@Service 
public class ShowPraiseTask {
	@Autowired
	public PointPraiseRankingMapper pointPraiseRankingMapper;
	@Autowired
	public ShowPraiseMapper showPraiseMapper;
	
	static Logger logger =  LogManager.getLogger(ShowPraiseTask.class.getName());
	
	public synchronized void countShowPraise4yesterday() {
		logger.info("----------------------执行秀场排名定时任务--------------------");
		//获取startDay和endDay
		Map<String,Object> map = getStartDayAndEndDay();
		//获取城市列表
		List<String> cityCodeList = showPraiseMapper.getCityCodesList(map);
		//循环获取各个城市的秀场排名前七名
		if(cityCodeList != null && cityCodeList.size()>0){
			for(int i=0;i<cityCodeList.size();i++){
				map.put("cityCode", cityCodeList.get(i));
				List<PointPraiseRanking> rankList = pointPraiseRankingMapper.getRankList(map);
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
//		pointPraiseRankingMapper.delete7daysAgo(limitDate);
		PointPraiseRankingExample example = new PointPraiseRankingExample();
		example.createCriteria().andCtimeLessThan(limitDate);
		pointPraiseRankingMapper.deleteByExample(example);
	}
	//向秀场排名表插入前一天各城市的秀场排名
	private void addRankList(List<PointPraiseRanking> rankList){
		if(rankList != null && rankList.size()>0){
			for(int i=0;i<rankList.size();i++){
//				pointPraiseRankingMapper.addRank(rankList.get(i));
				pointPraiseRankingMapper.insertSelective(rankList.get(i));
			}
		}
	}
	
}
