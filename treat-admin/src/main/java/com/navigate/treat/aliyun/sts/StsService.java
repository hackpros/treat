package com.navigate.treat.aliyun.sts;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.aliyun.oss.ClientException;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.ProtocolType;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import com.aliyuncs.sts.model.v20150401.AssumeRoleRequest;
import com.aliyuncs.sts.model.v20150401.AssumeRoleResponse;
import com.navigate.treat.aliyun.oss.OSSObjectSample;
import com.navigate.treat.util.Config;

public class StsService {
	private static final Logger logger = LogManager.getLogger(StsService.class.getName());
	
	// 目前只有"cn-hangzhou"这个region可用, 不要使用填写其他region的值
	public static final String REGION_CN_HANGZHOU = "cn-hangzhou";
//	// 当前 STS API 版本
	public static final String STS_API_VERSION = "2015-04-01";
//	public static final String accessKeyId = "o2gSSd0qzzriYYAv";
//	public static final String accessKeySecret = "AP6wFSm8tRMVfdVJeDuuKLXDZ4ruIp";
//	public static final String roleArn = "acs:ram::1865650772930441:role/tupianfangwen";
	public static final String accessKeyId = Config.getString("accessKeyId").trim();
	public static final String accessKeySecret = Config.getString("accessKeySecret").trim();
	public static final String roleArn = Config.getString("roleArn").trim();
	public static AssumeRoleResponse getAssumeRoleInfo() {
		// 只有 RAM用户（子账号）才能调用 AssumeRole 接口
		// 阿里云主账号的AccessKeys不能用于发起AssumeRole请求
		// 请首先在RAM控制台创建一个RAM用户，并为这个用户创建AccessKeys
//		String accessKeyId = "o************F";
//		String accessKeySecret = "y*******************U";

		// AssumeRole API 请求参数: RoleArn, RoleSessionName, Polciy, and
		// DurationSeconds

		// RoleArn 需要在 RAM 控制台上获取
//		String roleArn = "acs:ram::145883****900618:role/ossadminrole";

		// RoleSessionName 是临时Token的会话名称，自己指定用于标识你的用户，主要用于审计，或者用于区分Token颁发给谁
		// 但是注意RoleSessionName的长度和规则，不要有空格，只能有'-' '_' 字母和数字等字符
		// 具体规则请参考API文档中的格式要求
		String roleSessionName = "lzf";

		// 如何定制你的policy?
		String policy = "{\n" + "    \"Version\": \"1\", \n"
				+ "    \"Statement\": [\n" + "        {\n"
				+ "            \"Action\": [\n"
		        + "                 \"oss:*\"\n"				
//				+ "                \"oss:GetBucket\", \n"
//				+ "                \"oss:GetObject\" \n" 
				+ "            ], \n"
				+ "            \"Resource\": [\n"
				+ "                \"acs:oss:*:*:*\"\n" 
				+ "            ], \n"
				+ "            \"Effect\": \"Allow\"\n" + "        }\n"
				+ "    ]\n" + "}";
//全部权限		
//		 "    \"Version\": \"1\", \n" +
//         "    \"Statement\": [\n" +
//         "        {\n" +
//         "            \"Action\": [\n" +
//         "                \"oss:*\"\n" +
//         "            ], \n" +
//         "            \"Resource\": [\n" +
//         "                \"acs:oss:*:*:*\" \n" +
//         "            ], \n" +
//         "            \"Effect\": \"Allow\"\n" +
//         "        }\n" +
//         "    ]\n" +
//         "}";
		// 此处必须为 HTTPS
		ProtocolType protocolType = ProtocolType.HTTPS;
		AssumeRoleResponse response = null;
		try {
			response = assumeRole(accessKeyId,
					accessKeySecret, roleArn, roleSessionName, policy,
					protocolType);
			if(logger.isDebugEnabled()){
				logger.debug("Expiration: ", response.getCredentials().getExpiration());
				logger.debug("Access Key Id: ", response.getCredentials().getAccessKeyId());
				logger.debug("Access Key Secret: ", response.getCredentials().getAccessKeySecret());
				logger.debug("Security Token: ", response.getCredentials().getSecurityToken());
			}
		} catch (ClientException e) {
			logger.error("STS ERROR:", e);
//			System.out.println("Failed to get a token.");
//			System.out.println("Error code: " + e.getErrCode());
//			System.out.println("Error message: " + e.getErrMsg());
		}
		return response;
	}
	
	static AssumeRoleResponse assumeRole(String accessKeyId,
			String accessKeySecret, String roleArn, String roleSessionName,
			String policy, ProtocolType protocolType) throws ClientException {
		try {
			// 创建一个 Aliyun Acs Client, 用于发起 OpenAPI 请求
			IClientProfile profile = DefaultProfile.getProfile(
					REGION_CN_HANGZHOU, accessKeyId, accessKeySecret);
			DefaultAcsClient client = new DefaultAcsClient(profile);

			// 创建一个 AssumeRoleRequest 并设置请求参数
			final AssumeRoleRequest request = new AssumeRoleRequest();
			request.setVersion(STS_API_VERSION);
			request.setMethod(com.aliyuncs.http.MethodType.POST);
			request.setProtocol(protocolType);

			request.setRoleArn(roleArn);
			request.setRoleSessionName(roleSessionName);
			request.setPolicy(policy);

			// 发起请求，并得到response
			final AssumeRoleResponse response = client.getAcsResponse(request);
			return response;
		} catch (ClientException e) {
			throw e;
		} catch (ServerException e) {
			e.printStackTrace();
			return null;
		} catch (com.aliyuncs.exceptions.ClientException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static void main(String[] args) {
		AssumeRoleResponse AssumeRole = getAssumeRoleInfo();
		try {
			OSSObjectSample.putObject("fengqingyang", 
					"/gift/", 
					AssumeRole.getCredentials().getAccessKeyId(), 
					AssumeRole.getCredentials().getAccessKeySecret(), 
					AssumeRole.getCredentials().getSecurityToken(),
					"http://oss-cn-hangzhou.aliyuncs.com",
					"D:\\20151124.png");
			System.out.println("图片上传完成");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		// 只有 RAM用户（子账号）才能调用 AssumeRole 接口
//		// 阿里云主账号的AccessKeys不能用于发起AssumeRole请求
//		// 请首先在RAM控制台创建一个RAM用户，并为这个用户创建AccessKeys
//		String accessKeyId = "o************F";
//		String accessKeySecret = "y*******************U";
//
//		// AssumeRole API 请求参数: RoleArn, RoleSessionName, Polciy, and
//		// DurationSeconds
//
//		// RoleArn 需要在 RAM 控制台上获取
//		String roleArn = "acs:ram::145883****900618:role/ossadminrole";
//
//		// RoleSessionName 是临时Token的会话名称，自己指定用于标识你的用户，主要用于审计，或者用于区分Token颁发给谁
//		// 但是注意RoleSessionName的长度和规则，不要有空格，只能有'-' '_' 字母和数字等字符
//		// 具体规则请参考API文档中的格式要求
//		String roleSessionName = "alice-001";
//
//		// 如何定制你的policy?
//		String policy = "{\n" + "    \"Version\": \"1\", \n"
//				+ "    \"Statement\": [\n" + "        {\n"
//				+ "            \"Action\": [\n"
//				+ "                \"oss:GetBucket\", \n"
//				+ "                \"oss:GetObject\" \n" + "            ], \n"
//				+ "            \"Resource\": [\n"
//				+ "                \"acs:oss:*:*:*\"\n" + "            ], \n"
//				+ "            \"Effect\": \"Allow\"\n" + "        }\n"
//				+ "    ]\n" + "}";
//
//		// 此处必须为 HTTPS
//		ProtocolType protocolType = ProtocolType.HTTPS;
//
//		try {
//			final AssumeRoleResponse response = assumeRole(accessKeyId,
//					accessKeySecret, roleArn, roleSessionName, policy,
//					protocolType);
//
//			System.out.println("Expiration: "
//					+ response.getCredentials().getExpiration());
//			System.out.println("Access Key Id: "
//					+ response.getCredentials().getAccessKeyId());
//			System.out.println("Access Key Secret: "
//					+ response.getCredentials().getAccessKeySecret());
//			System.out.println("Security Token: "
//					+ response.getCredentials().getSecurityToken());
//		} catch (ClientException e) {
//			System.out.println("Failed to get a token.");
//			System.out.println("Error code: " + e.getErrCode());
//			System.out.println("Error message: " + e.getErrMsg());
//		}
//
	}
}
