package com.demo.springaop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class UserAccessAspect2 {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	// syntax for *POINTCUT* or the expression:
	// @Before = before the method calls
	// execution = a keyword that's needed
	// first * = methods with any return type
	// PACKAGE = package name
	// // // // // // // // //second * = method belong to any class
	// .. = .. after package means intercept any calls inside this sub-package
	// third * = method with any name
	// (..) = method with any parameters

	// final syntax:
	// execution(* PACKAGE.*.*(..))

	@Before("execution(* com.demo.springaop..*.*(..))")
	public void before(JoinPoint joinPoint) {

		// *ADVICE* the logic after interception is called advice.

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
