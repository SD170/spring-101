package com.springboot.springbootamatureproj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.springboot.springbootamatureproj.courses.controller.CourseController;

@SpringBootApplication // holds 3 main annotations [ctrl+click]

//@SpringBootConfiguration [just like @configuration for spring] 
//		indicates the class has @Bean definition
//		So Spring container can process the class and generate Spring Beans 
//		to be used in the application. 
// 		we can exclude this and provide our own configuration.
//@EnableAutoConfiguration [Enables the Autoconfiguration provided by spring-boot]
//		takes care of the needed frameworks. we can exclude specific frameworks also.
//@ComponentScan [part of spring]
//		scans for components in package and sub-packages
public class SpringBootAmatureProjApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootAmatureProjApplication.class, args);
		
		
		//when @RestController is used 
		// we didn't needed to take the application context as a variable 
		// in the application class and make an instance of the controller classes. 
		// When spring boot starts. It automatically, makes an instance of the controllers 
		// and it's dependencies. Also opens the port 
		// so that it can be hit/used by others.

		// that's why if we go to the "SpringBootAmatureProjApplication.java"
		// we won't see this::
		
		// ConfigurableApplicationContext applicationContext = SpringApplication.run(SpringBootAmatureProjApplication.class, args);
		// CourseController courseController = applicationContext.getBean(CourseController.class);
	}

}
