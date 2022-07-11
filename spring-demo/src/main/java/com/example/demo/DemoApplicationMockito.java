package com.example.demo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.example.componentscan.ComponentScanPersonDAO;
import com.example.demo.mockito.PersonDAOMockito;
import com.example.demo.scope.PersonDAO;

@Configuration
@ComponentScan(basePackages = { "com.example.demo" })
public class DemoApplicationMockito {

	
	public static void main(String[] args) throws Exception {
		AnnotationConfigApplicationContext appCtx = new AnnotationConfigApplicationContext(
				DemoApplicationMockito.class);

		PersonDAOMockito mockito = appCtx.getBean(PersonDAOMockito.class);

		appCtx.close();
	}

}
