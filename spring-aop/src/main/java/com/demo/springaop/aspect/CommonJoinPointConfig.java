package com.demo.springaop.aspect;

import org.aspectj.lang.annotation.Pointcut;

public class CommonJoinPointConfig {
	// now instead of copying the same pointcuts
	// we'll use the "qualified" names for these classes.
	@Pointcut("execution(* com.demo.springaop.data.*.*(..))")
	public void dataLayerExecution() {
	}

	@Pointcut("execution(* com.demo.springaop.business.*.*(..))")
	public void businessLayerExecution() {
	}

	// we can join pointcuts using &
	@Pointcut("execution(* com.demo.springaop.data.*.*(..)) && execution(* com.demo.springaop.business.*.*(..))")
	public void multiLayerExecution() {
	}
	
	
	// pointcuts for specific bean names
	// ("the regular expression")
	@Pointcut("bean(*dao*)")
	public void beanContainingDao() {
	}
	@Pointcut("bean(dao*)")
	public void beanStartsWithDao() {
	}
	
	// within: executes everything inside a specific package
	@Pointcut("within(com.demo.springaop.data..*)")
	public void dataLayerExecutionWithWithin() {
	}
	// same result as:
	// @Pointcut("execution(* com.demo.springaop.data.*.*(..))")
	
	
	// pointcut for annotation
	@Pointcut("@annotation(com.demo.springaop.aspect.TrackTime)")
	public void trackTimeAnnotation() {
	}
	
}
