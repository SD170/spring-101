// packagename should be same as the class we're writing tests for
package com.example.demo.basic;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.DemoApplicationBasic;

// we need to load the context class where the configuration 
// for BubbleSort is present: 
@ContextConfiguration(classes=DemoApplicationBasic.class)
// we'll also need a runner to run the loaded context
// it's a part of the spring-test module
@RunWith(SpringRunner.class)
public class BubbleSortTest {

	// without the @ContextConfiguration
	// cuz to autowire, we need the applicationContext where
	// BubbleSort classes bean is
	@Autowired
	BubbleSort bubbleSort;

	@Test
	public void testWith5Elements() {
		bubbleSort.sort(new int[] { 3, 2, 11, 34 });
		assertTrue(true);
	}

}
