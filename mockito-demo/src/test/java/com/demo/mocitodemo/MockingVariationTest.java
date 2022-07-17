package com.demo.mocitodemo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 * 
 * @author sd17 we'll mock the List Interface to see some examples
 *
 */
@ExtendWith(MockitoExtension.class) // starts application context
class MockingVariationTest {
	@Mock
	List listMock;

	// 0 parameters : 1 returns
	@Test
	public void testSize() {
		// we used @Mock in this place
		// List listMock = mock(List.class);

		// we'll mock the .size() method
		// of the List Interface to return a specific value: 5
		when(listMock.size()).thenReturn(5);

		// testing: first call -> 5
		assertEquals(5, listMock.size());
		// testing: second call -> 5
		assertEquals(5, listMock.size());

	}

	// 0 parameters : 2 returns
	@Test
	public void testSize_multipleReturns() {

		// first call will return: 5
		// second call will return: 15
		when(listMock.size()).thenReturn(5).thenReturn(15); // we can chain as many returns

		// testing: first call -> 5
		assertEquals(5, listMock.size());
		// testing: second call -> 15
		assertEquals(15, listMock.size());
		// testing: third call -> 15 [the last value]
		assertEquals(15, listMock.size());

	}

	// 1 parameters : 1 returns
	@Test
	public void testIndexOf_specificParameter() {

		// List.get(idx) returns element at a given idx
		when(listMock.get(7)).thenReturn("Some String");

		// testing: first call -> "Some String"
		assertEquals("Some String", listMock.get(7));
		// testing: second call -> null [for unspecified values]
		assertEquals(null, listMock.get(44));

	}

	// 1 parameters : 1 returns
	@Test
	public void testIndexOf_genericParameter() {

		// List.get(idx) returns element at a given idx
		// when(listMock.get(anyInt())) // static import : same thing
		when(listMock.get(Mockito.anyInt())).thenReturn("Some String");

		// testing: first call -> "Some String" [for all values]
		assertEquals("Some String", listMock.get(7));
		// testing: second call -> "Some String" [for all values]
		assertEquals("Some String", listMock.get(44));

	}

	/**
	 * Parameter rule For Mockito: if one of the parameter is generic (anyInt(),
	 * anyString()); then all of the other parameters should also be generic. 
	 * [for multiple parameters]
	 * 
	 */

}
