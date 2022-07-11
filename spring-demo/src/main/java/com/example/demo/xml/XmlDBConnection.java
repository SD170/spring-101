package com.example.demo.xml;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

// main class: com.example.demo.DemoApplicationXml

//we'll use a xml file for dependency injection
//location: src/main/resource/applicationContext.xml

public class XmlDBConnection {
	public XmlDBConnection() {
		System.out.println("DB connected");
	}
}
