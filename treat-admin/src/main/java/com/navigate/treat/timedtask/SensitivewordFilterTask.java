package com.navigate.treat.timedtask;

import java.util.Date;
import java.util.List;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.navigate.treat.dao.basicMapper.SensitiveWordAuditMapper;
import com.navigate.treat.dao.basicMapper.SensitiveWordMapper;
import com.navigate.treat.dao.basicMapper.ShowsMapper;
import com.navigate.treat.dao.basicMapper.UserActivitiesMapper;
import com.navigate.treat.po.basic.SensitiveWordAudit;
import com.navigate.treat.po.basic.Shows;
import com.navigate.treat.po.basic.UserActivities;
import com.navigate.treat.sensitiveword.SensitivewordFilter;
@Service 
public class SensitivewordFilterTask {
	static Logger logger =  LogManager.getLogger(ShowPraiseTask.class.getName());
	
	@Autowired
	SensitiveWordMapper sensitiveWordMapper;
	@Autowired
	SensitiveWordAuditMapper sensitiveWordAuditMapper;
	@Autowired
	ShowsMapper showsMapper;
	@Autowired
	UserActivitiesMapper userActivitiesMapper;
	
	public static List<String> sensitiveWordList = null;
	public static Date ctime = new Date();
	
	public synchronized void sensitivewordFilterTask() {
		ctime  = new Date();
		logger.info("----------------------" + ctime + ":敏感词定时任务--------------------");
		
		if(sensitiveWordList == null){
			sensitiveWordList = sensitiveWordMapper.getSensitiveWordList();
		}
		if(sensitiveWordList != null && sensitiveWordList.size()>0){
			SensitivewordFilter filter = new SensitivewordFilter();
			logger.info("敏感词的数量：" + filter.sensitiveWordMap.size());
			//秀场及活动过滤
			showAndActivityFilter(filter);
			filter = null;
		}else{
			logger.info("sensitiveWordList为空或初始化失败!");
		}
	}
	
	public void showAndActivityFilter(SensitivewordFilter filter){
		
		
		Date lastFilterTime = sensitiveWordAuditMapper.getLastFilterTime();
//		Calendar c = Calendar.getInstance();
//		c.setTime(ctime);
//		c.add(Calendar.MINUTE, -15);
//		Date lastFilterTime = c.getTime();
		
		List<Shows> showList = showsMapper.getShowList(lastFilterTime);
		String string = "";
		long beginTime = System.currentTimeMillis();
		if(showList != null && showList.size()>0){
			for(int i=0;i<showList.size();i++){
				string = showList.get(i).getSignature();
				if(string != null && !"".equals(string)){
//					logger.info("待检测语句字数：" + string.length());
					Set<String> set1 = filter.getSensitiveWord(string, 1);
					if(set1 != null && set1.size()>0){
						logger.info(showList.get(i).getId() + "语句中包含敏感词的个数为：" + set1.size() + "。包含：" + set1);
						SensitiveWordAudit sensitiveWordAudit = new SensitiveWordAudit();
						//秀场为3
						sensitiveWordAudit.setSceneType(3);
						sensitiveWordAudit.setSceneId(showList.get(i).getId());
						sensitiveWordAudit.setUserId(showList.get(i).getUserId());
						sensitiveWordAudit.setTheme(showList.get(i).getSignature());
						sensitiveWordAudit.setSensitiveWord(set1.toString());
						sensitiveWordAudit.setSceneTime(showList.get(i).getCtime());
						sensitiveWordAudit.setCtime(ctime);
						sensitiveWordAudit.setReview(1);
						sensitiveWordAuditMapper.insertSelective(sensitiveWordAudit);
					}
//					if(filter.isContaintSensitiveWord(string, 1)){
//						logger.info("第" + showList.get(i).getId() + "秀场存在敏感词");
//					}
				}
			}
		}
		
		List<UserActivities> activityList = userActivitiesMapper.getActivityList(lastFilterTime);
		if(activityList != null && activityList.size()>0){
			for(int i=0;i<activityList.size();i++){
				string = activityList.get(i).getTheme();
				if(string != null && !"".equals(string)){
//					logger.info("待检测语句字数：" + string.length());
					Set<String> set1 = filter.getSensitiveWord(string, 1);
					if(set1 != null && set1.size()>0){
						logger.info(activityList.get(i).getId() + "语句中包含敏感词的个数为：" + set1.size() + "。包含：" + set1);
						SensitiveWordAudit sensitiveWordAudit = new SensitiveWordAudit();
						//和活动一样，1线上   2线下
						sensitiveWordAudit.setSceneType(activityList.get(i).getTreatWay());
						sensitiveWordAudit.setSceneId(activityList.get(i).getId());
						sensitiveWordAudit.setUserId(activityList.get(i).getUserId());
						sensitiveWordAudit.setTheme(activityList.get(i).getTheme());
						sensitiveWordAudit.setSensitiveWord(set1.toString());
						sensitiveWordAudit.setSceneTime(activityList.get(i).getCtime());
						sensitiveWordAudit.setCtime(ctime);
						sensitiveWordAudit.setReview(1);
						sensitiveWordAuditMapper.insertSelective(sensitiveWordAudit);
					}
//					if(filter.isContaintSensitiveWord(string, 1)){
//						logger.info("第" + activityList.get(i).getId() + "活动存在敏感词");
//					}
				}
			}
		}
		long endTime = System.currentTimeMillis();
		logger.info("总共消耗时间为：" + (endTime - beginTime) + "ms");
	}
}
