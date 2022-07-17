package com.demo.mocitodemo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SomeBusinessStubTest {
	@Test
	public void testReturnFirstElement() {
		SomeBusinessImpl businessImpl = 
				new SomeBusinessImpl(new DataServiceStub1());
		int result = businessImpl.returnFirstElment();
		assertEquals(33, result);

	}
	// to pass different data we are creating whole new classes
	// which is not right
	class DataServiceStub1 implements ExternalDataService {
		@Override
		public int[] retriveAllData() {
			return new int[] { 33, 2, 13 };
		}
	}
	// there'll be a lot of classes like these
	// (DataServiceStub1, DataServiceStub2) called stubs
	// mockito helps us create those stubs - easily
	class DataServiceStub2 implements ExternalDataService {
		@Override
		public int[] retriveAllData() {
			return new int[] { 99, 23, 3 };
		}
	}
}
