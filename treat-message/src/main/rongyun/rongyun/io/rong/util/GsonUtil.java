package rongyun.io.rong.util;

import java.lang.reflect.Type;

import com.alibaba.fastjson.JSON;

public class GsonUtil {
	public static String toJson(Object obj, Type type) {
		return JSON.toJSONString(obj);
	}
}
