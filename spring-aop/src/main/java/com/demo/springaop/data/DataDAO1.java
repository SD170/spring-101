package com.demo.springaop.data;

import org.springframework.stereotype.Repository;

import com.demo.springaop.aspect.TrackTime;

@Repository
public class DataDAO1 {
	
	@TrackTime
	public String retriveSomething() {
		return "DAO1";
	}
}
