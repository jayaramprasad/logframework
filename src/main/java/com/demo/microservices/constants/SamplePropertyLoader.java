/**
 * 
 */
package com.demo.microservices.constants;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author jayaram
 *
 */
@Component
public class SamplePropertyLoader {
	
	@Value("${masking.pattrens.values}")
	private String validationQueries;
	
	
	public Map<String,String> maskingProps;
	
	@PostConstruct
	private void loadPropsMap() {
		
		String[] maskPropsValues=validationQueries.split("~");
		maskingProps = new HashMap<String,String>();
		
		for (String value:maskPropsValues) {
			String[] maskRegExp = value.split("\\|");
			maskingProps.put(maskRegExp[0], maskRegExp[1]);
			
		}
		
		
	}
	
	

}
