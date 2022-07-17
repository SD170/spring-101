package com.demo.mocitodemo;


// this class has a dependency of some ExternalDataService
public class SomeBusinessImpl {
	// we need some implementation of this data service
	private ExternalDataService externalDataService;
	
	// to accept the data service passed from any testing case
	public SomeBusinessImpl(ExternalDataService externalDataService) {
		super();
		this.externalDataService = externalDataService;
	}


	// some logic of returning the fist element
	int returnFirstElment () {
		int[] retrivedData = externalDataService.retriveAllData();
		return retrivedData[0];		
	}
}

