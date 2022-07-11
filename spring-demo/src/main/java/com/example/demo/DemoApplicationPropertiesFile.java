package com.example.demo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.example.demo.propertiesfile.SomeExternalService;

@Configuration
@ComponentScan
@PropertySource("classpath:app.properties")	// reading a properties file
// classpath namespace cuz file is in /src
public class DemoApplicationPropertiesFile {
	public static void main(String[] args) {
//		if we use try no need to do "appCtx.close()" explicitly
		try (AnnotationConfigApplicationContext appCtx = new AnnotationConfigApplicationContext(
				DemoApplicationScope.class)) {
			SomeExternalService sxs = appCtx.getBean(SomeExternalService.class);
			
			// to get the url inside SomeExternalService class
			System.out.println("The url: " + sxs.getServiceUrl());
		}
	}
}
