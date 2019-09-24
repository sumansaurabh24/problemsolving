package com.prep.coderpad;

public class _7_SpiralPrinting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int R = 3;
		int C = 6;
		int a[][] = { { 1, 2, 3, 4, 5, 6 }, { 7, 8, 9, 10, 11, 12 }, { 13, 14, 15, 16, 17, 18 } };
		// int a[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		//int a[][]= {{1},{2},{3},{4},{5}};
		
		R = a.length;
		C = a[0].length;
		spiralPrint(R, C, a);
	}

	static void spiralPrint(int rows, int columns, int a[][]) {
		int rowIndex = 0;
		int columnIndex = 0;
		int i;

		while (rowIndex < rows && columnIndex < columns) {
			// Print 1st Row
			for (i = columnIndex; i < columns; i++) {
				System.out.println(a[rowIndex][i]);
			}
			rowIndex++;
			// Print Last Column
			for (i = rowIndex; i < rows; i++) {
				System.out.println(a[i][columns - 1]);
			}
			columns--;
			// Print Remaining elements from Last row
			if (rowIndex < rows) {
				for (i = columns - 1; i >= columnIndex; i--) {
					System.out.println(a[rows - 1][i]);
				}
				rows--;
			}
			if (columnIndex < columns) {
				for (i = rows - 1; i >= rowIndex; i--) {
					System.out.println(a[i][columnIndex]);
				}
				columnIndex++;
			}
		}
	}

}
