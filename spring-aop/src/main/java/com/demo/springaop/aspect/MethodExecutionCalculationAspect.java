package com.demo.springaop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class MethodExecutionCalculationAspect {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	// with around we can do before the method execution and after the method
	// execution also.
	// before+after = around
//	@Around("execution(* com.demo.springaop.business.*.*(..))")
//	@Around("com.demo.springaop.aspect.CommonJoinPointConfig.businessLayerExecution()")
	// only work for @annotation TrackTime
	@Around("com.demo.springaop.aspect.CommonJoinPointConfig.trackTimeAnnotation()")
	public Object aroundAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		// precedingJointPoint would allow you to continue with the execution of the
		// method.

		// do something before
		long startTime = System.currentTimeMillis();
		// returns the method's return
		// *Important* if we don't return anything the methods that are being
		// intercepted will also not return anything
		// as it's a proxy around the method
		Object ret = proceedingJoinPoint.proceed(); // continues the method calls
		// do something after
		long endTime = System.currentTimeMillis();
		long timeTaken = endTime - startTime;

		logger.info("time taken by this {} is {}", proceedingJoinPoint, timeTaken);

		return ret;
	}

}
