package com.example.demo.basic;

import org.springframework.stereotype.Component;

@Component
public class QuickSort implements SortAlgo {

	@Override
	public void sort(int[] arr) {
		// TODO Auto-generated method stub
		System.out.println("Quicksort happening");
		System.out.println(arr.toString());
	}

}
