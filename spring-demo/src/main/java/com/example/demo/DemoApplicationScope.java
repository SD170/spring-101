package com.example.demo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.example.componentscan.ComponentScanPersonDAO;
import com.example.demo.scope.PersonDAO;

@Configuration
@ComponentScan(basePackages = 
{"com.example.componentscan", "com.example.demo"})
public class DemoApplicationScope {

//	private static Logger LOGGER =  // use "sl4j" logger to print
//			LoggerFactory.getLogger(DemoApplicationScope.class);	
	public static void main(String[] args) throws Exception {
		AnnotationConfigApplicationContext appCtx = 
				new AnnotationConfigApplicationContext(DemoApplicationScope.class);
//				SpringApplication.run(DemoApplicationScope.class, args);
		
		ComponentScanPersonDAO personDAO = 
				appCtx.getBean(ComponentScanPersonDAO.class);
		PersonDAO personDAO2 = 
				appCtx.getBean(PersonDAO.class);
		
//		// {} will be replaced by the obj
//		LOGGER.info("{}", personDAO);
//		LOGGER.info("{}", personDAO.getDbConnection());
//		LOGGER.info("{}", personDAO.getDbConnection());
//		LOGGER.info("{}", personDAO2);
//		LOGGER.info("{}", personDAO2.getDbConnection());
		
		appCtx.close();
	}

}
