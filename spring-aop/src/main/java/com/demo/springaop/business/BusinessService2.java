package com.demo.springaop.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.springaop.data.DataDAO2;

@Service
public class BusinessService2 {
	@Autowired
	private DataDAO2 dao2;
	
	public String calculeteSomething() {
		// some business logic
		return dao2.retriveSomething();
	}
}
