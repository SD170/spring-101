package com.demo.springaop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.demo.springaop.business.BusinessService1;
import com.demo.springaop.business.BusinessService2;

@SpringBootApplication
public class SpringAopApplication implements CommandLineRunner {
	// as we only have @service not any @restcontrollers.
	// we need to make the applicationContext and then make the beans 
	// for the service class
	// now generally we would've done it inside main as, 
	// when the application is gonna run, main will run first and thus
	// the beans will be created.
	
	// **IF** we can have another method that'll run, as soon as the appCtx intialized
	// we can also create the beans there.
	// here comes, CommandLineRunner. It's an interface, which contains a callback "run" method
	// and that "run" method  is a callback for spring-boot application context creation.
	// whenever SpringApplication.run(SpringAopApplication.class, args)
	// launches the application context. the run method is called.
	// thus we can do the bean logging/creation inside "run" method/ or autowire them (not statically)
	// which is better than statically do it for "main()"
	
	
	// to do the same inside "main()" we needed to make "service1" static
	// as to even sysout it inside main needed it to static
	@Autowired
	private BusinessService1 service1;
	
	@Autowired
	private BusinessService2 service2;
	
	
	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext = SpringApplication.run(SpringAopApplication.class, args);
		
		// System.out.println(service1);
		// can't be done as service1 isn't static
	}


	@Override
	public void run(String... args) throws Exception {
		System.out.println(service1.calculeteSomething());
		System.out.println(service2.calculeteSomething());
	}
	
	
	

}
