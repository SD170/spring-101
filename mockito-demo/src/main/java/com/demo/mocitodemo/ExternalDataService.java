package com.demo.mocitodemo;

// this is some service which has a method that returns an array
// we dont have any implementation of this data service
// but we need it for the testing
public interface ExternalDataService {
	int[] retriveAllData();

}