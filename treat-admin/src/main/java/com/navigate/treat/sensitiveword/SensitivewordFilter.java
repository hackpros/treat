package com.navigate.treat.sensitiveword;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
/**
 * @Description: 敏感词过滤
 * @Author : ShanHe
 */
public class SensitivewordFilter {
	static Logger logger =  LogManager.getLogger(SensitivewordFilter.class.getName());
	public Map<Object, Object> sensitiveWordMap = null;
	public static int minMatchTYpe = 1;      //最小匹配规则
	public static int maxMatchType = 2;      //最大匹配规则
	
	/**
	 * 构造函数，初始化敏感词库
	 */
	public SensitivewordFilter(){
		long beginTime = System.currentTimeMillis();
		//初始化敏感词库
		sensitiveWordMap = new SensitiveWordInit().initKeyWord();
		long endTime = System.currentTimeMillis();
		if(sensitiveWordMap != null){
			if(logger.isInfoEnabled()){
				logger.info("初始化敏感词库，敏感词大小：" + sensitiveWordMap.size() + "    耗时" + (endTime - beginTime) + "ms");
			}
		}
//		System.out.println(sensitiveWordMap);
//		for (Map.Entry<Object, Object> entry : sensitiveWordMap.entrySet()) {
//	        System.out.println(entry.getValue());
//	    }
	}
	
	/**
	 * 判断文字是否包含敏感字符
	 */
	public boolean isContaintSensitiveWord(String txt,int matchType){
		boolean flag = false;
		for(int i = 0 ; i < txt.length() ; i++){
			int matchFlag = this.CheckSensitiveWord(txt, i, matchType); //判断是否包含敏感字符
			if(matchFlag > 0){    //大于0存在，返回true
				flag = true;
			}
		}
		return flag;
	}
	
	/**
	 * 获取文字中的敏感词
	 */
	public Set<String> getSensitiveWord(String txt , int matchType){
		Set<String> sensitiveWordList = new HashSet<String>();
		
		for(int i = 0 ; i < txt.length() ; i++){
			int length = CheckSensitiveWord(txt, i, matchType);    //判断是否包含敏感字符
			if(length > 0){    //存在,加入list中
				sensitiveWordList.add(txt.substring(i, i+length));
				i = i + length - 1;    //减1的原因，是因为for会自增
			}
		}
		
		return sensitiveWordList;
	}
	
	/**
	 * 替换敏感字字符
	 */
	public String replaceSensitiveWord(String txt,int matchType,String replaceChar){
		String resultTxt = txt;
		Set<String> set = getSensitiveWord(txt, matchType);     //获取所有的敏感词
		Iterator<String> iterator = set.iterator();
		String word = null;
		String replaceString = null;
		while (iterator.hasNext()) {
			word = iterator.next();
			replaceString = getReplaceChars(replaceChar, word.length());
			resultTxt = resultTxt.replaceAll(word, replaceString);
		}
		
		return resultTxt;
	}
	
	/**
	 * 获取替换字符串
	 */
	private String getReplaceChars(String replaceChar,int length){
		String resultReplace = replaceChar;
		for(int i = 1 ; i < length ; i++){
			resultReplace += replaceChar;
		}
		
		return resultReplace;
	}
	
	/**
	 * 检查文字中是否包含敏感字符，检查规则如下：<br>
	 */
	@SuppressWarnings({ "rawtypes"})
	public int CheckSensitiveWord(String txt,int beginIndex,int matchType){
		boolean  flag = false;    //敏感词结束标识位：用于敏感词只有1位的情况
		int matchFlag = 0;     //匹配标识数默认为0
		char word = 0;
		Map nowMap = sensitiveWordMap;
		for(int i = beginIndex; i < txt.length() ; i++){
			word = txt.charAt(i);
			nowMap = (Map) nowMap.get(word);     //获取指定key
			if(nowMap != null){     //存在，则判断是否为最后一个
				matchFlag++;     //找到相应key，匹配标识+1 
				if("1".equals(nowMap.get("isEnd"))){       //如果为最后一个匹配规则,结束循环，返回匹配标识数
					flag = true;       //结束标志位为true   
					if(SensitivewordFilter.minMatchTYpe == matchType){    //最小规则，直接返回,最大规则还需继续查找
						break;
					}
				}
			}
			else{     //不存在，直接返回
				break;
			}
		}
		if(matchFlag < 2 || !flag){        //长度必须大于等于1，为词 
			matchFlag = 0;
		}
		return matchFlag;
	}
	
//	public static void main(String[] args) {
//		SensitivewordFilter filter = new SensitivewordFilter();
//		if(filter.sensitiveWordMap != null){
//			System.out.println("敏感词的数量：" + filter.sensitiveWordMap.size());
//			String string = "太多的伤感情怀也许只局限于饲养基地 荧幕中的情节，主人公尝试着去用某种方式渐渐的很潇洒地释自杀指南怀那些自己经历的伤感。"
//					+ "然后法轮功 我们的扮演的角色就是跟随着主人公的喜红客联盟 怒哀乐而过于牵强的把自己的情感也附加于银幕情节中，然后感动就流泪，"
//					+ "难过就躺在某一个人的怀里尽情的阐述心扉或者手机卡复制器一个人一杯红酒一部电影在夜三级片 深人静的晚上，关上电话静静的发呆着。";
//			System.out.println("待检测语句字数：" + string.length());
//			long beginTime = System.currentTimeMillis();
//			Set<String> set1 = filter.getSensitiveWord(string, 1);
//			System.out.println("语句中包含敏感词的个数为：" + set1.size() + "。包含：" + set1);
////		System.out.println();
////		Set<String> set2 = filter.getSensitiveWord(string, 2);
////		System.out.println("语句中包含敏感词的个数为：" + set2.size() + "。包含：" + set2);
//			long endTime = System.currentTimeMillis();
//			System.out.println("总共消耗时间为：" + (endTime - beginTime) + "ms");
//		}
//	}
}
