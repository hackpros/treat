package com.navigate.treat.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;

/**
 * @author hsp
 * @version 1.0.0
 * @version 创建时间：Dec 22, 2014 5:52:21 PM
 * 
 */
public class SendSms {

	public static void main(String[] args)  {
		sendSms("13020264566", StringUtil.getSmsContent("1226"));
	}

	public static JSONObject sendSms(String mobile, String content) throws JSONException {

		Map<String, String> params = new HashMap<String, String>();
		params.put("apikey", Constants.API_KEY_SMS);
		params.put("text", content);
		params.put("mobile", mobile);
		String res = post(Constants.URI_SEND_SMS, params);
		
        JSONObject json =  JSONObject.parseObject(res);
        if(json.get("code").equals(0)){
        	System.out.println(res);
        }
		return json;
	}

	public static String post(String url, Map<String, String> paramsMap) {
		CloseableHttpClient client = HttpClients.createDefault();
		String responseText = "";
		CloseableHttpResponse response = null;
		try {
			HttpPost method = new HttpPost(url);
			if (paramsMap != null) {
				List<NameValuePair> paramList = new ArrayList<NameValuePair>();
				for (Map.Entry<String, String> param : paramsMap.entrySet()) {
					NameValuePair pair = new BasicNameValuePair(param.getKey(), param.getValue());
					paramList.add(pair);
				}
				method.setEntity(new UrlEncodedFormEntity(paramList, Constants.ENCODING));
			}
			response = client.execute(method);
			HttpEntity entity = response.getEntity();
			if (entity != null) {
				responseText = EntityUtils.toString(entity);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				response.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return responseText;
	}

}
