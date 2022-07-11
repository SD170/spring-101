package com.example.demo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.demo.xml.XmlPersonDAO;

// we'll use a xml file for dependency injection
// location: src/main/resource/applicationContext.xml

public class DemoApplicationXml {

	public static void main(String[] args) throws Exception {
		// ClassPathXmlApplicationContext will search for the xml file in
		// the project's folders. So, no need for specifying the whole path
		// just "applicationContext.xml" is fine
		ClassPathXmlApplicationContext appCtx = 
				new ClassPathXmlApplicationContext("applicationContext.xml");

		XmlPersonDAO xmlPersonDAO = appCtx.getBean(XmlPersonDAO.class);
//		ComponentScanPersonDAO personDAO = appCtx.getBean(ComponentScanPersonDAO.class);

		System.out.println(xmlPersonDAO.getDbConnection());
		appCtx.close();
	}

}
