package com.example.demo.xml;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.scope.DBConnection;


//main class: com.example.demo.DemoApplicationXml

//we'll use a xml file for dependency injection
//location: src/main/resource/applicationContext.xml

public class XmlPersonDAO {
	XmlDBConnection dbConnection;

	public XmlDBConnection getDbConnection() {
		return dbConnection;
	}

	public void setDbConnection(XmlDBConnection dbConnection) {
		this.dbConnection = dbConnection;
	}

	
	
//	@PostConstruct
//	public void postConstruct() {
//		System.out.println("PostConstruct called");
//	}
//	
//	@PreDestroy
//	public void preDest() {
//		System.out.println("preDest called");
//	}
	
}
