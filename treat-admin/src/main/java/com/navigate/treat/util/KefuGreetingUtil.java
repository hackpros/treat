package com.navigate.treat.util;

import java.util.HashMap;
import java.util.Map;


public class KefuGreetingUtil {
	/**
	 * @author shanhe 
	 * 
	 * 客服问候
	 * 新曾用户问候   KefuGreeting4NewTaskMap  
	 * 多天一次问候   KefuGreeting4DaysTaskMap
	 * 一天多次问候   KefuGreeting4TimesTaskMap
	 * 某天定时问候   KefuGreeting4OnceTaskMap
	 */
	public static Map<String, Long> KefuGreeting4NewTaskMap = new HashMap<String, Long>();
	public static Map<String, Long> KefuGreeting4DaysTaskMap = new HashMap<String, Long>();
	public static Map<String, Long> KefuGreeting4TimesTaskMap = new HashMap<String, Long>();
	public static Map<String, Long> KefuGreeting4OnceTaskMap = new HashMap<String, Long>();
	public static Map<String, Long> KefuReply4DaysTaskMap = new HashMap<String, Long>();
//	static {
//		KefuGreeting4NewTaskMap.put("kg4ntFlag", 0L);//新曾用户问候任务状态，初始化为0，为0是程序判断数据库状态，并存入缓存  
//		KefuGreeting4NewTaskMap.put("kg4ntStartId", 700000L);//设置任务的起始用户id
//		KefuGreeting4NewTaskMap.put("kg4ntInterval", 15L);//每次执行间隔时间  单位：分钟
//		KefuGreeting4NewTaskMap.put("kg4ntStarTime", 0L);//每天任务起始时间  范围：0-23  不大于kg4ntEndTime
//		KefuGreeting4NewTaskMap.put("kg4ntEndTime", 12L);//每天任务截止时间  范围：0-23  不大于kg4ntStarTime
//		KefuGreeting4NewTaskMap.put("oldUserSendFlag", 0L);//是否扫描老用户表  0：不扫描  1：扫描
//		KefuGreeting4NewTaskMap.put("oldUserSendDays", 1L);//设置多少天前的老用户需要从老用户表删除
//	}
//	
//	static {
//		KefuGreeting4DaysTaskMap.put("kg4dtFlag", 0L);//初始化为0，为0是程序判断数据库状态，并存入缓存  
//		KefuGreeting4DaysTaskMap.put("kg4dtExecuteDay", 0L);//执行日期
//		KefuGreeting4DaysTaskMap.put("kg4dtExecuteHour", 0L);//执行那天的具体时间
//		KefuGreeting4DaysTaskMap.put("kg4dtInterval", 5L);//每次执行间隔时间  单位：天
//		KefuGreeting4DaysTaskMap.put("startDay", 1437148800000L);//用来设置获取用户的起始时间
//	}
//	
//	static {
//		KefuGreeting4TimesTaskMap.put("kg4ttFlag", 0L);//初始化为0，为0是程序判断数据库状态，并存入缓存  
//		KefuGreeting4TimesTaskMap.put("kg4ttInterval", 6L);//设置每次任务执行的时间间隔（单位：小时）
//		KefuGreeting4TimesTaskMap.put("kg4ttStarTime", 0L);//每天任务起始时间  范围：0-23  不大于kg4ntEndTime
//		KefuGreeting4TimesTaskMap.put("kg4ttEndTime", 12L);//每天任务截止时间  范围：0-23  不大于kg4ntStarTime
//	}
//	
//	static {
//		KefuGreeting4OnceTaskMap.put("kg4otFlag", 0L);//初始化为0，为0是程序判断数据库状态，并存入缓存  
//		KefuGreeting4OnceTaskMap.put("kg4otExecuteTime", Long.MAX_VALUE);//具体执行时间 
//	}
//	
//	static {
//		KefuReply4DaysTaskMap.put("kr4dtFlag", 0L);//初始化为0，为0是程序判断数据库状态，并存入缓存 
//		KefuReply4DaysTaskMap.put("kr4dtStarTime", 0L);//每天任务起始时间  范围：0-23  不大于kg4ntEndTime
//		KefuReply4DaysTaskMap.put("kr4dtEndTime", 12L);//每天任务截止时间  范围：0-23  不大于kg4ntStarTime
//		KefuReply4DaysTaskMap.put("replyStartDay", 3L);//设置期限，n天之内，最大值为7
//	}
}
