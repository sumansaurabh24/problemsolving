package com.prep.coderpad;
/* Problem Name is &&& Snowpack &&& PLEASE DO NOT REMOVE THIS LINE. */

/*
** Instructions to candidate.
**  1) Given an array of non-negative integers representing the elevations
**     from the vertical cross section of a range of hills, determine how
**     many units of snow could be captured between the hills. 
**
**     See the example array and elevation map below.
**                                 ___
**             ___                |   |        ___
**            |   |        ___    |   |___    |   |
**         ___|   |    ___|   |   |   |   |   |   |
**     ___|___|___|___|___|___|___|___|___|___|___|___
**     {0,  1,  3,  0,  1,  2,  0,  4,  2,  0,  3,  0}
**                                 ___
**             ___                |   |        ___
**            |   | *   *  _*_  * |   |_*_  * |   |
**         ___|   | *  _*_|   | * |   |   | * |   |
**     ___|___|___|_*_|___|___|_*_|___|___|_*_|___|___
**     {0,  1,  3,  0,  1,  2,  0,  4,  2,  0,  3,  0}
**
**     Solution: In this example 13 units of snow (*) could be captured.
**  
**  2) Consider adding some additional tests in doTestsPass().
**  3) Implement computeSnowpack() correctly.
*/

import java.io.*;
import java.util.*;

class _29_Snowpack {
	/*
	 ** Find the amount of snow that could be captured.
	 */
	public static Integer computeSnowpack(Integer[] arr) {
		int n = arr.length;
		int left[] = new int[n];
		int right[] = new int[n];

		// left[i] contains height of tallest bar to the left of i'th bar including
		// itself
		// Fill left array
		left[0] = arr[0];
		for (int i = 1; i < n; i++)
			left[i] = Math.max(left[i - 1], arr[i]);

		// Right [i] contains height of tallest bar to the right of ith bar including
		// itself
		// Fill right array
		right[n - 1] = arr[n - 1];
		for (int i = n - 2; i >= 0; i--)
			right[i] = Math.max(right[i + 1], arr[i]);

		// Calculate the accumulated water element by element consider the amount of
		// water on i'th bar, the amount of water accumulated on this particular bar
		// will be equal to min(left[i], right[i]) - arr[i] .
		int water = 0;
		for (int i = 0; i < n; i++)
			water += Math.min(left[i], right[i]) - arr[i];

		return water;
	}

	/*
	 ** Returns true if the tests pass. Otherwise, returns false;
	 */
	public static boolean doTestsPass() {
		boolean result = true;
		result &= computeSnowpack(new Integer[] { 0, 1, 3, 0, 1, 2, 0, 4, 2, 0, 3, 0 }) == 13;

		return result;
	}

	/*
	 ** Execution entry point.
	 */
	public static void main(String[] args) {
		if (doTestsPass()) {
			System.out.println("All tests pass");
		} else {
			System.out.println("Tests fail.");
		}
	}
}