package com.prep.coderpad;

import java.util.Map;
import java.util.HashMap;

public class _16_CountLengthOfCycle {

	/**
	 *
	 * You have an integer array. Starting from arr[startIndex], follow each element
	 * to the index it points to. Continue to do this until you find a cycle. Return
	 * the length of the cycle. If no cycle is found return -1
	 *
	 */
	public static int countLengthOfCycle(int[] data, int index) {
		// your code goes here
		// public static int countCycles(int[] data) {
		int response = -1;

		int count = 0;
		Map map = new HashMap();
		int z = -1;
		while (map.put(index, count) == null) {
			count++;
			index = data[index];
			if (map.get(index) != null)
				z = (int) map.get(index);

		}

		if (z != -1) {
			response = count - z;
		}

		System.out.println("Response-->" + response);
		return response;

		/*
		 * int[] counters = new int[data.length]; // int index = 0; int count = 0;
		 * while(counters[index] == 0) { counters[index] = count++; index = data[index];
		 * } response=count - counters[index];
		 */

		/*
		 * int count=0; private Map<Integer, Integer> visitedElements = new
		 * HashMap<Integer, Integer>(); public int countCycle(int[] array){ int
		 * startOfLoop = visitNextElement(array, array[0]); return count - startOfLoop;
		 * }
		 * 
		 * private int visitNextElement(int[] data, int index){ counter++;
		 * 
		 * Integer startOfLoop = visitedElements.put(index, count); if(startOfLoop ==
		 * null){ return visitNextElement(data, data[index]); } else{ return
		 * startOfLoop; } }
		 */
	}

	public static void main(String[] args) {

		boolean testsPassed = true;

		testsPassed &= countLengthOfCycle(new int[] { 1, 0 }, 0) == 2;
		testsPassed &= countLengthOfCycle(new int[] { 1, 2, 0 }, 0) == 3;
		testsPassed &= countLengthOfCycle(new int[] { 1, 3, 0, 4, 1 }, 0) == 3;
		testsPassed &= countLengthOfCycle(new int[] { 1, 3, 0, 4, 3 }, 0) == 2;
		// testsPassed &= countLengthOfCycle(new int[]{1, 2}, 0) == -1;

		if (testsPassed) {
			System.out.println("Test passed.");
			// return true;
		} else {
			System.out.println("Test failed.");
			// return false;
		}

	}
}