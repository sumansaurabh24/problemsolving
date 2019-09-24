package com.prep.coderpad;
/*
**  Below formation is called Pascals Triangle.
**
**  Example:
**               1
**              1 1
**             1 2 1
**            1 3 3 1
**           1 4 6 4 1
**         1 5 10 10 5 1
**        1 6 15 20 15 6 1
**
**  Complete the 'pascal' function below so that given a
**  col and a row it will return the value in that positon.
**
**  Example, pascal(1,2) should return 2
**
*/

/* 
*					******** IMPORTANT ********
*
* THIS IS SAMPLE SOLUTION. IF YOU FIND BETTER SOLUTION PLEASE CONSIDER USING SAME.
* USE YOUR OWN VARIABLE NAMES - @@@ DO NOT COPY @@@ EXACT VARIABLE NAMES
*
*/
import java.util.HashMap;
import java.util.Map;

public class _13_PascalTriangle {

	public static int pascal(int col, int row) {

		int[][] pascalArray = new int[row + 1][row + 1];
		for (int rows = 0; rows <= row; rows++) {
			for (int cols = 0; cols <= rows; cols++) {
				if (cols == 0 || cols == rows) {
					pascalArray[rows][cols] = 1;
				} else {
					pascalArray[rows][cols] = 
							pascalArray[rows - 1][cols - 1] + pascalArray[rows - 1][cols];
				}
			}
		}

		return pascalArray[row][col];
	}

	public static void main(String[] args) {
		if (_13_PascalTriangle.pascal(0, 0) == 1 && _13_PascalTriangle.pascal(1, 2) == 2
				&& _13_PascalTriangle.pascal(5, 6) == 6 && _13_PascalTriangle.pascal(4, 8) == 70
				&& _13_PascalTriangle.pascal(6, 6) == 1) {
			System.out.println("Pass");
		} else {
			System.out.println("Failed");
		}
	}
}
