package com.demo.springaop.aspect;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// method:  we want this annotation to run only for methods [not classes]
@Target(ElementType.METHOD)
// runtime: annotaion information to be available at run time of the method, thus calculating the time taken by the execution
// cuz we'll use it with @Around
@Retention(RetentionPolicy.RUNTIME)
public @interface TrackTime {
	
}
