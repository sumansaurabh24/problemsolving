package com.prep.coderpad;

import java.util.ArrayList;
import java.util.List;

public class _7_SpiralPrintingRec {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int R = 3;
		int C = 6;
		//int a[][] = { { 1, 2, 3, 4, 5, 6 }, { 7, 8, 9, 10, 11, 12 }, { 13, 14, 15, 16, 17, 18 } };
		 //int a[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		int a[][]= {{1},{2},{3},{4},{5}};
		
		R = a.length;
		C = a[0].length;
		spiralPrint(R, C, 0,0,a);
	}

	static void spiralPrint(int rows, int cols,int rowIndex,int colIndex, int arr[][]) {
		List list = new ArrayList();
		if (rowIndex >= rows || colIndex >= cols) 
	        return; 
	  
	    // Print First Row 
	    for (int i = colIndex; i < cols; i++) 
	        System.out.println( arr[rowIndex][i] ); 
	  
	    // Print Last Column 
	    for (int i = rowIndex + 1; i < rows; i++) 
	    	System.out.println( arr[i][cols - 1] ); 
	  
	    // Print Last Row, if Last and 
	    // First Row are not same 
	    if (rowIndex!= (rows - 1) ) 
	        for (int i = cols - 2; i >= colIndex; i--) 
	        	System.out.println( arr[rows - 1][i] ); 
	  
	    // Print First Column,  if Last and 
	    // First Column are not same 
	    if (colIndex!=(cols - 1)) 
	        for (int i = rows - 2; i > rowIndex; i--) 
	        	System.out.println( arr[i][colIndex] ); 
	  
	   // print(arr, rowIndex + 1, colIndex + 1, rows - 1, cols - 1);
		spiralPrint(rows-1, cols-1,rowIndex+1,colIndex+1, arr);
	}
	
	
	
	
	
    

}
