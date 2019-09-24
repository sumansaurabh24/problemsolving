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

public class _31_SubArrayExceedingSum {
	public static int subArrayExceedsSum(int arr[], int target) {
		int i = 0, j = 0, subArraySize = Integer.MAX_VALUE, arraySize = arr.length;
		if (target <= 0)
			return 0;
		if (arraySize < 1)
			return -1;

		int currentSum = arr[0];
		if(currentSum<0) {
			currentSum=0;
		}
		while (true) {
			if (currentSum >= target) {
				if (i == j)
					return (1);
				else {
					if(arr[i]>0) 
						currentSum -= arr[i];
					if (j - i + 1 < subArraySize) 
						subArraySize = j - i + 1;
					i++;
				}
			} else {
				j++;
				if (j == arraySize)
					break;
				else if(arr[j]>0)
						currentSum += arr[j];
				
			}
		}
		if (subArraySize == Integer.MAX_VALUE)
			return -1;
		System.out.println(subArraySize);
		return subArraySize;
	}

	public static void doTestsPass() {
		boolean result = true;
		int[] arr = { 1, 2, 3, 4 };
		result = result && subArrayExceedsSum(arr, 1) == 1;
		result = result && subArrayExceedsSum(arr, 6) == 2;
		result = result && subArrayExceedsSum(arr, 12) == -1;
		result = result && subArrayExceedsSum(arr, 10) == 4;
		result = result && subArrayExceedsSum(arr, 4) == 1;

		int[] arr2 = {};
		result = result && subArrayExceedsSum(arr2, 0) == 0;
		result = result && subArrayExceedsSum(arr2, 2) == -1;

		int[] arr3 = {-8, 1, 4, 2, -6};
		result = result && subArrayExceedsSum(arr3, 6) == 2;
		int[] arr4 = {1, -8, 3, 2, -6};
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
