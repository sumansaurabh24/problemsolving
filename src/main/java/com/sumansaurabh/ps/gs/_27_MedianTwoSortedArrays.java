package com.prep.coderpad;

import java.util.Arrays;

// find the median of the two sorted arrays.
 // ex. {1, 3} and {2} is 2


public class _27_MedianTwoSortedArrays
{

  public static double logic(int[] A, int[] B) {
	  
	 int [] merged=new int[A.length+B.length];
	 int k=0;
	 for (int i=0;i<A.length;i++) {
		 merged[k++]=A[i];
	 }
	 for (int i=0;i<B.length;i++) {
		 merged[k++]=B[i];
	 }
	 Arrays.sort(merged);
	 
	 
	 if(merged.length%2==0) {
		 return (merged[(merged.length/2)]+merged[(merged.length/2)-1])/2d;
	 }else {
		 return merged[merged.length/2];
	 }
  }

  public static boolean pass()
  {
  boolean result = true;
  result = result && logic(new int[]{1, 3}, new int[]{2, 4}) == 2.5;
  return result;
  };

  public static void main(String[] args)
  {
  if(pass())
  {
    System.out.println("pass");
  }
  else
  {
    System.out.println("some failures");
  }
  }
}