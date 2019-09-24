package com.prep.coderpad;

public class SecondSmallestInSortedRotatedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] input= {3,5,7,9,2};
		System.out.println(getSecondSmallest(input));
	}
	private static int getSecondSmallest(int[] input) {
		int index = Integer.MIN_VALUE;
		for (int i = 0; i < input.length - 1; i++) {
			if (input[i] > input[i + 1]) {
				
				index = i + 2;
				break;
			}
		}
		if (index == Integer.MIN_VALUE) {
			index = 1;
		} else if (index >= input.length)
			index = 0;
		return input[index];
	}

}
