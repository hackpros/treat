package com.navigate.treat.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;




public class IpUtil {
	
	private static Log log = LogFactory.getLog(IpUtil.class);
	
	public static String getIp(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		try {
			ip = ip.split(",")[0];
		} catch (Exception e) {
		}
		return ip;
	}
	

	/**
	 * 根据ID生成文件
	 * 并建立目录
	 * @param rootPath
	 * @param type
	 * @param id
	 * @return
	 */
	public static String getFileStr(String filePath){
		File file = new File(filePath);
		StringBuffer sb = new StringBuffer();
		if(file.isFile()){
			  try {
				  BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(file),"UTF-8")); 		
				  String line = in.readLine();   
				  while   (line   !=   null)   {   
					  sb.append(line);
                      line = in.readLine();   
              }   
			} catch (Exception e) {
				log.error(e.getMessage());
			}
		}else{
			log.error("file : "+ filePath + " is not exist!");
		}
		return sb.toString();
	}
	
	/**
	 * 根据IP库文件路径生成数组
	 * @param filePath
	 * @return
	 */
	public static List<String[]> getIpListFromFile(String filePath){
		File file = new File(filePath);
		List<String[]> list=new ArrayList<String[]>();
		if(file.isFile()){
			  try {
				  BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(file),"UTF-8"));   
				  String line = in.readLine();  
				  long count=0;
				  while   (line   !=   null  )   { 
					  count++;
					  line=line.replaceAll( "\"", "");
					  String[] ipinfo=line.split(",");
					  if(ipinfo!=null && ipinfo.length==9){
						  if(ipinfo[4].equals("中国") || ipinfo[4].equals("香港") || ipinfo[4].equals("台湾")){
							  list.add(ipinfo);
						  }
					  }
                      line = in.readLine();   
              }   
			} catch (Exception e) {
				e.printStackTrace();
				log.error(e.getMessage());
			}
		}else{
			log.error("file : "+ filePath + " is not exist!");
		}
		return list;
	}
	
public static String[] search(String ip){
		
		//List<String[]> iplist=(List<String[]>) DBBuffer.get(DBBuffer.IP);
		List<String[]> iplist=null;
		long fromIpNum=ipStrToIpNum(ip);
		
		String fromIpNumStr = String.valueOf(fromIpNum);
		int index=-1;
		if(fromIpNum!=-1  && iplist !=null){
			//使用折半查找法优先查找
			index=BinarySearch(iplist,fromIpNum,0,iplist.size());
		}
		//如果折半查找查不到就用遍历法查找
		if(index==-1 && iplist !=null){
			for(int j=0;j<iplist.size();j++){
				String[] obj=iplist.get(j);
				if(fromIpNumStr.compareTo(obj[0])>=0 && fromIpNumStr.compareTo(obj[1])<=0){
					index=j;
					break;
				}
			}
		}
		if(index>-1){
			return iplist.get(index);
		}else{
			String[] a=new String[]{"","","","","国外","","","",""};
			return a;
		}
	}
	
	/**
	 * 根据IP获取IP详细信息
	 * @param ip
	 * @return
	 */
	public static String[] search(long fromIpNum){
		
		//已下部分有用，勿删
		//List<String[]> iplist=(List<String[]>) DBBuffer.get(DBBuffer.IP);
		List<String[]> iplist=null;
		String fromIpNumStr = String.valueOf(fromIpNum);
		int index=-1;
		if(fromIpNum!=-1  && iplist !=null){
			//使用折半查找法优先查找
			index=BinarySearch(iplist,fromIpNum,0,iplist.size());
		}
		//如果折半查找查不到就用遍历法查找
		if(index==-1 && iplist !=null){
			for(int j=0;j<iplist.size();j++){
				String[] obj=iplist.get(j);
				if(fromIpNumStr.compareTo(obj[0])>=0 && fromIpNumStr.compareTo(obj[1])<=0){
					index=j;
					break;
				}
			}
		}
		if(index>-1){
			return iplist.get(index);
		}else{
			String[] a=new String[]{"","","","","国外","","","",""};
			return a;
		}
	}
	
	
	/**
     * @param data 从小到大排好序的数组
     * @param goal 要查找的数
     * @param left 
     * @param right 
     * @return 目标数的数组下标，没有找到为-1 ;
     */
	public static int BinarySearch(List<String[]> data,long goal,int left,int right){
        int mid = (left+right)/2 ;   
        if(left>right){    
            return -1 ;     
        }   
        try {
        	//范围查找
            if(goal>=Long.parseLong(data.get(mid)[0]) && goal<=Long.parseLong(data.get(mid)[1])){   
                return mid ;
            }else if(goal<Long.parseLong(data.get(mid)[0])){ 
                //注意right = mid -1 ; 
                return BinarySearch(data,goal,left,mid-1);
            }else if(goal>Long.parseLong(data.get(mid)[0])){        
                return BinarySearch(data,goal,mid+1,right);
            }  
		} catch (Exception e) {
			return -1 ;
		}
		return -1 ;        
    }  
    /**
     * 把IP转换成数字
     * @param ipstr
     * @return
     */
	public static long ipStrToIpNum(String ipstr){
		String[] fileds=ipstr.split("[.]");
		long ipnum=-1;
		try {
			if(fileds.length==4){
				ipnum=Long.parseLong(fileds[0])*256*256*256+Long.parseLong(fileds[1])*256*256
					+Long.parseLong(fileds[2])*256+Long.parseLong(fileds[3]);
			}
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return ipnum;
	}
	
	
}
