/**
 * 
 */
package com.demo.microservices.sample.utils;

import java.util.Map;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.demo.microservices.constants.SamplePropertyLoader;

/**
 * @author jayaram
 *
 */
@Component
public class SampleUtils {
	
	@Autowired
	SamplePropertyLoader propLoader;

	
	public String maskLog(String json) {
		
		//System.out.println("Property Map ::" + propLoader.maskingProps);
		
		for (Map.Entry<String, String> entry : propLoader.maskingProps.entrySet())
		{
			json=Pattern.compile(entry.getKey()).matcher(json).replaceAll(entry.getValue());
		}
		
		
		/*if(Pattern.compile("(\"mobile\"\\s*:)\\s*(\"[0-9]*\")").matcher(json).find())
			json=Pattern.compile("(\"mobile\"\\s*:)\\s*(\"[0-9]*\")").matcher(json).replaceAll("\"mobile\" : \"*********\"");
		if(Pattern.compile("(\"email\"\\s*:)\\s*(\"[a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]{2,5}\")").matcher(json).find())
			json=Pattern.compile("(\"email\"\\s*:)\\s*(\"[a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]{2,5}\")").matcher(json).replaceAll("\"email\" : \"*********\"");
		*/
		
		return json;
	}
	
	
}
