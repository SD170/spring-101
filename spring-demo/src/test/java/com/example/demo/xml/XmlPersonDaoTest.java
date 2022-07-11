// packagename should be same as the class we're writing tests for
package com.example.demo.xml;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.DemoApplicationBasic;

// we need to load the context class where the configuration 
// for XmlPersonDAO is present: 
// using applicationContext.xml, so the syntax is
// @ContextConfiguration(locations = "/applicationContext.xml")

// applicationContext.xml is in the class path: we can even override
// the "/spring-demo/src/main/resources/applicationContext.xml"
// by creating another application context in:
// "/spring-demo/src/test/resources/testContext.xml"
// so after overriding, syntax is:
@ContextConfiguration(locations = "/testContext.xml")
// we'll also need a runner to run the loaded context
// it's a part of the spring-test module
@RunWith(SpringRunner.class)
public class XmlPersonDaoTest {

	// without the @ContextConfiguration
	// cuz to autowire, we need the applicationContext where
	// 	XmlPersonDAO classes bean is
	@Autowired 
	// we'll use autowire otherwise 
	// we have to do it in xml for the tests also
	XmlPersonDAO xmlPersonDAO;

	@Test
	public void testXmlPersonDAO() {
		xmlPersonDAO.getDbConnection();
		assertTrue(true);
	}

}
