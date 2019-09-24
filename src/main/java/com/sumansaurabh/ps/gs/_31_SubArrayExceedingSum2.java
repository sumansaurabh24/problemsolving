package com.prep.coderpad;
/* 
*					******** IMPORTANT ********
*
* THIS IS SAMPLE SOLUTION. IF YOU FIND BETTER SOLUTION PLEASE CONSIDER USING SAME.
* USE YOUR OWN VARIABLE NAMES - @@@ DO NOT COPY @@@ EXACT VARIABLE NAMES
*
*/

import java.io.*;
import java.util.*;

public class _31_SubArrayExceedingSum2 {
	// Returns length of smallest subarray with sum greater than x. If there is no subarray with given sum, then returns n+1
		public static int subArrayExceedsSum(int arr[], int target) {
			int arraySize=arr.length;
			if (target <= 0)
				return 0;

			if (arraySize < 1)
				return -1;
			// Initialize current sum and minimum length
			
			int curr_sum = 0, min_len = arraySize + 1;

			// Initialize starting and ending indexes
			int beg = 0, end = 0;
			while (end < arraySize) {
				// Keep adding array elements while current sum is smaller than x
				while (curr_sum <= target && end < arraySize) {
					// Ignore subarrays with negative sum if x is positive.
					if (curr_sum <= 0 && target > 0) {
						beg = end;
						curr_sum = 0;
					}
					curr_sum += arr[end++];
				}

				// If current sum becomes greater than x.
				while (curr_sum >= target && beg < arraySize) {
					// Update minimum length if needed
					if (end - beg < min_len)
						min_len = end - beg;

					// remove starting elements
					curr_sum -= arr[beg++];
				}
			}
			if(min_len == arraySize + 1)
				return -1;
			System.out.println(min_len);		
			return min_len;
		}
		
	public static void doTestsPass() {
		boolean result = true;
		/*int[] arr = { 1, 2, 3, 4 };
		result = result && subArrayExceedsSum(arr, 1) == 1;
		result = result && subArrayExceedsSum(arr, 6) == 2;
		result = result && subArrayExceedsSum(arr, 12) == -1;
		result = result && subArrayExceedsSum(arr, 10) == 4;
		result = result && subArrayExceedsSum(arr, 4) == 1;

		int[] arr2 = {};
		result = result && subArrayExceedsSum(arr2, 0) == 0;
		result = result && subArrayExceedsSum(arr2, 2) == -1;

		int[] arr3 = {-8, 1, 4, 2, -6};
		result = result && subArrayExceedsSum(arr3, 6) == 2;*/
		int[] arr4 = {1, -8, 3, 2, -6};
		//result = result && subArrayExceedsSum(arr4, 6) == -1;
		result = result && subArrayExceedsSum(arr4, 5) == 2;
		
		if (result) {
			System.out.println("All tests pass\n");
		} else {
			System.out.println("There are test failures\n");
		}
	};

	public static void main(String[] args) {
		doTestsPass();
	}
};
