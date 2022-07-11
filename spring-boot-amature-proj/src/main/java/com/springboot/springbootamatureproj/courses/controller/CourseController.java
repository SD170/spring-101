package com.springboot.springbootamatureproj.courses.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.springbootamatureproj.SpringBootAmatureProjApplication;
import com.springboot.springbootamatureproj.courses.bean.Course;


//when @RestController is used 
// we didn't needed to take the application context as a variable 
// in the application class and make an instance of the controller classes. 
// When spring boot starts. It automatically, makes an instance of the controllers 
// and it's dependencies. Also opens the port 
// so that it can be hit/used by others.

// that's why if we go to the "SpringBootAmatureProjApplication.java"
// we won't see

//		public class SpringBootAmatureProjApplication {
//		
//			public static void main(String[] args) {
//				ConfigurableApplicationContext applicationContext = SpringApplication.run(SpringBootAmatureProjApplication.class, args);
//				CourseController courseController = applicationContext.getBean(CourseController.class);
//			}
//		
//		}


// it'll just be:
//		SpringApplication.run(SpringBootAmatureProjApplication.class, args);


@RestController // this will open up a rest url
public class CourseController {

	@GetMapping(path = "/courses")
	public List<Course> listAllCourses() {
		return Arrays.asList(new Course(1, "Football 24/7", "SD17"));
		// java 9 syntax
		// return List.of(new Course(1, "Football 24/7", "SD17"));
	}
}
