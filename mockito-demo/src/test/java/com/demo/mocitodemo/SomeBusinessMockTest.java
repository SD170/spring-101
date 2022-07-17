package com.demo.mocitodemo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

// used for getting desired return vals for 
// methods of inner classes/interfaces of the
// class/outer class we're writing test for

// we can create mock for methods of classes/interfaces

class SomeBusinessMockTest {
	@Test
	public void testReturnFirstElement() {
		// need to create a mock for ExternalDataService class
		ExternalDataService dataServiceMock = mock(ExternalDataService.class);
		// now we can do a lot with our "mock": dataServiceMock

		// for eg:
		// we want dataServiceMock.returnFirstElment() to return {1,2,3} or:
		// dataServiceMock.returnFirstElment() => new int [] {1,2,3}
		// previously we created a stubclass fot that
		// for mokito:
		when(dataServiceMock.retriveAllData())
						.thenReturn(new int[] { 1, 2, 3 });
		// we pass dataServiceMock to the SomeBusinessImpl/main class
		// we've created appropriate constructor to set the dependency 
		SomeBusinessImpl businessImpl = new SomeBusinessImpl(dataServiceMock);
		// if we call our mocked method returnFirstElment()
		int result = businessImpl.returnFirstElment();
		assertEquals(1,result);

	}
	
	// test for a different sets of vals
	@Test
	public void testReturnFirstElement_SingleElement() {
		ExternalDataService dataServiceMock = mock(ExternalDataService.class);
		// mocking methods to return another sets of vals
		when(dataServiceMock.retriveAllData())
						.thenReturn(new int[] { 7 });
		SomeBusinessImpl businessImpl = new SomeBusinessImpl(dataServiceMock);
		int result = businessImpl.returnFirstElment();
		assertEquals(7,result);

	}



}
