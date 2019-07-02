package com.spdb.common;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.ValueFilter;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class WebUtils {
	    public static void writeObjectToClient(Object obj,HttpServletResponse response) throws JsonGenerationException, JsonMappingException, IOException{
	        ObjectMapper mapper = new ObjectMapper();
	        String jsonStr=mapper.writeValueAsString(obj);
	        response.setCharacterEncoding("UTF-8");
	        response.setContentType("text/html;charset=UTF-8");  
	        response.getWriter().print(jsonStr); 
	    }
	    
	    public static void writeObjectJsonToClient(Object obj,HttpServletResponse response) throws JsonGenerationException, JsonMappingException, IOException{
	    	if(obj != null){
	    		response.setCharacterEncoding("UTF-8");
		        response.setContentType("text/html;charset=UTF-8");  
		        response.getWriter().print(obj.toString()); 
	    	}	        
	    }
	    
	    public static void writeObjectJsonToClientNotNull(HttpServletResponse response, Map<String, Object> maps) throws JsonGenerationException, JsonMappingException, IOException {
			ValueFilter valueFilter = new ValueFilter(){
				@Override
				public Object process(Object obj, String name, Object value) {
					if(value == null){
						value = "";
					}
					return value;
				}
			};
			String str = JSONObject.toJSONString(maps,valueFilter); 
			writeObjectJsonToClient(str, response);
		}

}
