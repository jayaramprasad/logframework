/**
 * 
 */
package com.demo.microservices.sample.controllers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jayaram
 *
 */
@RestController
public class SampleController {
	
	public static final Logger LOG=LogManager.getLogger(SampleController.class);
	
	@PostMapping("/sample")
	public Boolean getSample(@RequestBody String body) {
		
		//LOG.info("Request Body :" + body);

		
		
		return true;
	} 
	
	
	

}
