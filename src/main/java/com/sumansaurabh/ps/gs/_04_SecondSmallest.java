package com.prep.coderpad;
public class _04_SecondSmallest {
	/**
	 * int secondSmallest(int[] x)
	 */
	public static int secondSmallest(int[] x) {
		
		// Your code
		if(x.length<2) return x[0];
		//return (0);
		
		int smallest=Integer.MAX_VALUE;
		int secondSmallest=Integer.MAX_VALUE;
		for(int i=0;i<x.length;i++) {
			if(x[i]<smallest) {
				secondSmallest=smallest;
				smallest=x[i];
			}else if(x[i]!=smallest && x[i]<secondSmallest) {
				secondSmallest=x[i];
			}
		}
		return secondSmallest;
		
	}

	public static void main(String args[]) {

		int[] a = { 0 };
		int[] b = { 0, 1 };

		boolean result = true;
		result &= secondSmallest(a) == 0;
		result &= secondSmallest(b) == 1;

		if (result) {
			System.out.println("Pass");
		} else {
			System.out.println("Fail");
		}

	}
}