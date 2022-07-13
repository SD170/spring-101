package demo.junit;

import java.util.Iterator;

public class MyMath {
	int sum(int[] numbers) {
		int s = 0;
		for (int i : numbers) {
			s+=i;
		}
		return s;
	}
}
