package com.navigate.treat.util;

import java.util.Map;
import java.util.Map.Entry;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.springframework.web.servlet.view.json.MappingJacksonJsonView;

import com.navigate.treat.base.io.RestBaseService;
import com.navigate.treat.base.io.request.IRequest;

/**
 *　复写以修改返回json　modelandview  包含modelname 的bug
 * @author fanwg
 * @date   2013-9-7 下午03:48:16 
 * @email  renntrabbit@foxmail.com
 */
public class SpringMappingJacksonJsonView extends  MappingJacksonJsonView {
	 @Override  
	    protected Object filterModel(Map<String, Object> model) { 
		 
		
		 
	        Map<?, ?> result = (Map<?, ?>) super.filterModel(model);  
	      
	        for (Entry<?, ?> entry : result.entrySet()) {
	        	Object obj=entry.getValue();
	        	//System.out.println(obj.getClass().isAssignableFrom(CnnctResponse.class));
	        	//System.out.println(obj.getClass().isInstance(CnnctResponse.class));
	        	//System.out.println(obj.getClass().isInstance(CnnctResponse.class));
	        	//ICResponse
	        	if (obj instanceof IRequest ||RestBaseService.RETURN_INTERFACE_KEY.equals(entry.getKey())){
	        		return obj;
	        	}
	        }

	        if (result.size() == 1) {   
	            return result.values().iterator().next();   
	        } else {   
	            return result;   
	        }   
	    }

	@Override
	public void setObjectMapper(ObjectMapper objectMapper) {
		objectMapper.setSerializationInclusion(JsonSerialize.Inclusion.NON_NULL);   
		super.setObjectMapper(objectMapper);
	}   
	   
}
