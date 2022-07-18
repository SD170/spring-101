package com.demo.springaop.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.springaop.data.DataDAO1;

@Service
public class BusinessService1 {
	@Autowired
	private DataDAO1 dao1;
	
	public String calculeteSomething() {
		// some business logic
		return dao1.retriveSomething();
	}
}
