package com.example.demo.propertiesfile;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SomeExternalService {
	// will read this value from property file
	@Value("${external.service.url}")
	private String url;
	
	// typically the property files will be in 
	// src/main/resources

	public String getServiceUrl() {
		return url;
	}

}
