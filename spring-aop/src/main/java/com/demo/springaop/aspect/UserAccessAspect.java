package com.demo.springaop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

// the class name is BeforeAspect as the interception to the services 
// will happen before the service calls.

// we need to define that this class is related to AOP
@Aspect
// we need to define that this class is a configuration
@Configuration
public class UserAccessAspect {

	// sl4j logger for better console logging
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	// we need to define the "kinds of methods"
	// that the below (before) function will be intercepting

	// syntax for *POINTCUT* or the expression:
	// @Before = before the method calls
	// execution = a keyword that's needed
	// first * = methods with any return type
	// PACKAGE = package name
	// second * = method belong to any class
	// third * = method with any name
	// (..) = method with any parameters

	// final syntax:
	// execution(* PACKAGE.*.*(..))

	@Before("execution(* com.demo.springaop.business.*.*(..))")
	public void before(JoinPoint joinPoint) {
		// parameter: JoinPoint joinPoint gives us the respective anticipated method
		// names

		// the things to do after intercepting
		logger.info("Checking some user access");
		// logging the method
		logger.info("Intercepted method call {}", joinPoint);
	}
	
	// combination of Pointcut and Advice is *ASPECT*
	// *JoinPoint* is the specific interception of method calls
	// *ADVICE* the logic after interception is called advice.
	// *POINTCUT* is the expression of execution
	// the whole process is called *Weaving*
	// the whole process is done by the framework is called *Weaver*
}
