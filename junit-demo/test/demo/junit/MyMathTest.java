package demo.junit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * we're importing " **static** org.junit.jupiter.api.Assertions" which
 * basically means we don't have to do "Assertions.assertEquals()" we can
 * directly write "assertEquals()"
 */

class MyMathTest {
	// instead of instantiating in each test, instantiate once
	MyMath myMath = new MyMath();
	
	// as @BeforeAll always runs once for a class it's a class level method
	// we need to mark it as static. Same for @AfterAll
	
	
	
	@Test
	@BeforeEach
	@AfterEach
	public void assertMethods() {
		assertEquals(1, 1);
		assertTrue(true);
		assertFalse(false);
		assertNull(null);
		assertNotNull(1);
		// to compare if 2 arrays are equal
		assertArrayEquals(new int[] { 1, 2, 3 }, new int[] { 1, 2, 3 });
	}

	@Test
	public void sum_with3Numbers() {
//		MyMath myMath = new MyMath();
		// check result = 6
		assertEquals(6, myMath.sum(new int[] { 1, 2, 3 }));
	}

	@Test
	public void sum_with1Numbers() {
//		MyMath myMath = new MyMath();
		int result = myMath.sum(new int[] { 3 });

		// check result = 6
		assertEquals(6, result);
	}

}
