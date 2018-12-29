/**
 * 
 */
package com.demo.microservices.aspect;

import java.lang.annotation.Annotation;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import com.demo.microservices.sample.utils.SampleUtils;



/**
 * @author jayaram
 */
@Component
@Aspect
public class LogHandlerAspect {
	
	public static final Logger LOG=LogManager.getLogger(LogHandlerAspect.class);
	
	@Autowired
	SampleUtils utils;
	
	//What kind of method calls I would intercept
	//execution(* PACKAGE.*.*(..))
	//Weaving & Weaver
	
	@Before(value="(execution(* com.demo.microservices.*.*controller*.*.*(..)))")
	public void before(JoinPoint joinPoint){
		//Advice
		LOG.info("Before Entering Method");
		LOG.info("Execution Started for for :"+joinPoint.getSignature().getName());
		 MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
		    Annotation[][] annotationMatrix = methodSignature.getMethod().getParameterAnnotations();
		    int index = -1;
		    for (Annotation[] annotations : annotationMatrix) {
		      index++;
		      for (Annotation annotation : annotations) {
		        if (!(annotation instanceof RequestBody))
		          continue;
		        Object requestBody = joinPoint.getArgs()[index];
		        LOG.info(joinPoint);
		        LOG.info("  Request body = " + utils.maskLog(requestBody+""));
		      }
		    }
	
		//LOG.info("Request Parameters :"+ joinPoint.getArgs() );
	}

	
	@AfterReturning(value="(execution(* com.demo.microservices.*.*controller*.*.*(..)))" ,returning = "result")
	public void afterReturning(JoinPoint joinPoint, Object result) {
		LOG.info("Returned with value  :"+ joinPoint +" Response :: " + result);
	}
	
	
	
	/*
	@After(value = "execution(* com.example.demo.controller.*.*(..))")
	public void after(JoinPoint joinPoint) {
		LOG.info("after execution of :"+ joinPoint);
	}
	*/


}
