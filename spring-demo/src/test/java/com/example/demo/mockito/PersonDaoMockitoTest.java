// packagename should be same as the class we're writing tests for
package com.example.demo.mockito;

import static org.junit.Assert.assertArrayEquals;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringExtension;

// we don't need the spring context while using mockito
//@ContextConfiguration(classes = DemoApplicationMockito.class)
// we'll also use mockitoRunner in place of SpringRunner
@RunWith(MockitoJUnitRunner.class)
public class PersonDaoMockitoTest {

	// @Autowired not needed as mocktio is handling the contexts
	// cuz we did "@RunWith(MockitoJUnitRunner.class)"
	@InjectMocks
	PersonDAOMockito personDAOMockito;
	@Mock
	DBConnectionMockito mockDbConnectionMockito;

	@Test
	public void testXmlPersonDAO() {
		// by creating the mock, we're not dependent on the DB/persistent layer to get
		// the data back.
		when(mockDbConnectionMockito.DbGetData()).thenReturn(new int[] { 5, 2, 1 });

		int[] data = personDAOMockito.getDbConnection().DbGetData();

		assertArrayEquals(data, new int[] { 5, 2, 1 });
	}

}
