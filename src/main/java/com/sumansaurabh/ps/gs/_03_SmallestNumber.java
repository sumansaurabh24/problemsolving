package com.prep.coderpad;

import java.util.*;
import java.util.stream.Stream;

import ch.qos.logback.core.net.SyslogOutputStream;

public class _03_SmallestNumber {

	/*
	 * public static int FindMin(int a[]) Returns the smallest number in array that
	 * has been rotated For example - Array {3,4,5,6,1,2} returns 1
	 */

	public static int FindMin(int a[]) {
		//System.out.println("Anuj --> "+findMin(a));
		return FindMinInArray(a, 0, a.length - 1);
		
	}
	private static int FindMinInArray(int arr[], int beg, int end) {
		System.out.println("Method2");
		if (beg == end)
			return arr[beg];

		if (beg > end)
			return arr[0];

		int middle = (beg + end) / 2;

		if (middle < end && arr[middle] > arr[middle + 1])
			return FindMinInArray(arr, middle + 1, end);//arr[middle + 1];
		if (middle > beg && arr[middle - 1] > arr[middle])
			return arr[middle];
		if (arr[end] > arr[middle])
			return FindMinInArray(arr, beg, middle - 1);

		return FindMinInArray(arr, middle + 1, end);
	}
/*	private static int findMin(int[] a) {
        if (a.length == 0 || a == null) {
            return -1;
        }
        int beg = 0;
        int end = a.length - 1;
        while (beg + 1 < end) {
            int mid = beg + (end - beg) / 2;
            int m = a[mid];
            int s = a[beg];
            int l = a[end];
            if (m > l) {
                beg = mid + 1;
            }
            if (m < l) {
                end = mid;
            } else {
                end--;
            }
        } // while
        if (a[beg] > a[end]) {
            return a[end];
        } else {
            return a[beg];
        }
    }*/

	public static void main(String args[]) {
		boolean result = true;
		result = result && FindMin(new int[] {3, 4, 5, 6,1,2}) == 1;
		result = result && FindMin(new int[] {-1,2, 3, 4, 5, 6, }) == -1;
		result = result && FindMin(new int[] {1,2, 3, 4, 5 }) == 1;
		result = result && FindMin(new int[] {5,4,3,2,1 }) == 1;
		result = result && FindMin(new int[] {5,4,3,2,1,6 }) == 1;
		result = result && FindMin(new int[] { 2, -1 }) == -1;
		result = result && FindMin(new int[] { 1 }) == 1;

		try {
			FindMin(null);
			result = false;
		} catch (Exception e) {
			result = result && true;
		}

		if (result) {
			System.out.println("All tests pass");
		} else {
			System.out.println("There are test failures");
		}
	}
}