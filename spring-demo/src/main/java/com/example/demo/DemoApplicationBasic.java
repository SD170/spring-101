package com.example.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.example.demo.basic.QuickSort;
import com.example.demo.basic.SortAlgo;

// both @Configuration and @ComponentScan would've been taken care by
// @SpringBootApplication for spring-boot

@Configuration // @Configuration indicates that the class has @Bean definition methods. 
// So Spring container can process the class and generate Spring Beans 
// to be used in the application. 
@ComponentScan // scans for components in package and sub-packages
public class DemoApplicationBasic {

	public static void main(String[] args) throws Exception {
		ApplicationContext appCtx = new AnnotationConfigApplicationContext(DemoApplicationBasic.class);

		SortAlgo srt = appCtx.getBean(QuickSort.class);

		srt.sort(new int[] { 1, 2, 3, 4 });
	}

}
