package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

//we'll also need a runner to run the loaded context
//it's a part of the spring-test module
@RunWith(SpringRunner.class) // instead of @SpringBootTest
class DemoApplicationBasicTests {

	@Test
	void contextLoads() {
	}

}
