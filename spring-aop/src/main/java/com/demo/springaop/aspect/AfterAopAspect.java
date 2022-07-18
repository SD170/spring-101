package com.demo.springaop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class AfterAopAspect {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	

	@AfterReturning(
			value = "execution(* com.demo.springaop.business.*.*(..))", 
			returning = "result" // the 2nd parameter name
			// the value returned will be mapped to this "result"
			)
	public void afterReturn(JoinPoint joinPoint, Object result) {

		logger.info("Checking some user access");
		logger.info("{} returned with value {}", joinPoint, result);
	}
	
	@AfterThrowing(
			value = "execution(* com.demo.springaop.business.*.*(..))", 
			throwing = "exception" // the 2nd parameter name
			// the value returned will be mapped to this "exception"
			)
	public void afterException(JoinPoint joinPoint, Object exception) {

		logger.info("{} returned with error {}", joinPoint, exception);
	}
	
	// it's called in both cases: exception and value also
	@After(value = "execution(* com.demo.springaop.business.*.*(..))")
	public void after(JoinPoint joinPoint) {

		logger.info("after execution of {}", joinPoint);
	}

}
