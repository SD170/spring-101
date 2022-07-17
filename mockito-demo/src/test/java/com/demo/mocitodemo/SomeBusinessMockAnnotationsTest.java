package com.demo.mocitodemo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

// the class needs to have a runner; any of the three below works
// what is runner / how it works?? 
// see line **52**

//@ExtendWith(MockitoExtension.class)
//@ExtendWith(SpringExtension.class)
@SpringBootTest
class SomeBusinessMockAnnotationsTest {

	@Mock // for the dependency: creates the mock
	ExternalDataService dataServiceMock;
	@InjectMocks // for the test class: does necessary dependency injection
	SomeBusinessImpl businessImpl;

	@Test
	public void testReturnFirstElement() {
		// taken care by @Mock
		// ExternalDataService dataServiceMock = mock(ExternalDataService.class);

		// mocking
		when(dataServiceMock.retriveAllData()).thenReturn(new int[] { 1, 2, 3 });

		// taken care by @InjectMock
		// SomeBusinessImpl businessImpl = new SomeBusinessImpl(dataServiceMock);

		int result = businessImpl.returnFirstElment();
		assertEquals(1, result);

	}

	// writing tests became smaller
	@Test
	public void testReturnFirstElement_SingleElement() {
		when(dataServiceMock.retriveAllData()).thenReturn(new int[] { 7 });
		assertEquals(7, businessImpl.returnFirstElment());

	}

	/**
	 * The @SpringBootTest annotation tells Spring Boot to look for a main config
	 * class and to use it to start an Application context. If you run it
	 * without @SpringBootTest, we are attempting to use Dependency Injection
	 * without an Application context, we are simply running the tests, which will
	 * cause the NullPointerException. This is why we need to tell the application
	 * that the tests require an application context, so that Dependency Injection
	 * can be accomplished.
	 * 
	 * 
	 * and with @ExtendWith and both MockitoExtension.class, SpringExtension.class
	 * we're just integrating the Spring TestContext Framework into JUnit 5's
	 * Jupiter programming model. 
	 * Just what @SpringBootTest does.
	 */

}
