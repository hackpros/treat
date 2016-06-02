package rongyun.io.rong;

import org.apache.http.HttpStatus;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import rongyun.io.rong.models.FormatType;
import rongyun.io.rong.models.SdkHttpResult;

import com.alibaba.fastjson.JSONObject;
import com.navigate.treat.io.user.response.UsersLoginRes;
import com.navigate.treat.up.GlobalPropertiesUtil;
import com.navigate.treat.up.HeadVo;
import com.navigate.treat.util.ResponseCode;

/**
 * 
 * @author ShanHe 获取token
 * 
 */
public class RongYunTokenUtil implements IToken {

	static Logger log = LogManager.getLogger(RongYunTokenUtil.class);

	private final static String RONG_YUN_KEY = "rongyun.key";
	private final static String RONG_YUN_SERCET = "rongyun.secret";

	public static String getToken(String userId) {

		try {
			String key = GlobalPropertiesUtil.get(RONG_YUN_KEY);
			String secret = GlobalPropertiesUtil.get(RONG_YUN_SERCET);
			String userName = "";
			String portraitUri = "";
			String token = "";
			SdkHttpResult result = ApiHttpClient.getToken(key, secret, userId, userName, portraitUri, FormatType.json);
			// 将result.getResult()转为json后获取token
			if (result.getHttpCode() == HttpStatus.SC_OK) {
				JSONObject resultJson = JSONObject.parseObject(result.getResult());
				token = resultJson.getString("token");
				return token;
			} else {
				log.error("请求融去接口数异常，httpcode{}", result.getHttpCode());
				return "";
			}
		} catch (Exception e) {
			log.error(ResponseCode.FAIL_TOKEN_ERROR);
			return "";
		}

	}

	public static String getToken(HeadVo vo, UsersLoginRes sessionUser) {

		try {
			String key = GlobalPropertiesUtil.get(RONG_YUN_KEY);
			String secret = GlobalPropertiesUtil.get(RONG_YUN_SERCET);

			String userName = "";
			String portraitUri = "";
			String token = "";

			SdkHttpResult result = ApiHttpClient.getToken(key, secret, sessionUser.getUserId().toString(), userName, portraitUri,
					FormatType.json);

			// 将result.getResult()转为json后获取token
			if (result.getHttpCode() == HttpStatus.SC_OK) {
				JSONObject resultJson = JSONObject.parseObject(result.getResult());
				token = resultJson.getString("token");
				return token;
			} else {
				vo.setResponseUtil(ResponseCode.FAIL_TOKEN_ERROR);
				log.error("请求融去接口数异常，httpcode{}", result.toString());
			}
		} catch (Exception e) {
			vo.setResponseUtil(ResponseCode.FAIL_TOKEN_ERROR);
			log.error(ResponseCode.FAIL_TOKEN_ERROR);
		}
		return null;
	}
}
