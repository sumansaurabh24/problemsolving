package com.prep.coderpad;
public class _17_IsPowerOf10
{
  /**
   * Returns true if x is a power-of-10. 
   */
  public static boolean isPowerOf10(int x)
  {
  // your code goes here
	  int y=10;
	  int n=y;
	  if(x==1) return true;
	  else if(x<1) {
		  while(n>x) 
			  n=n/y;
	  }
	  else if(x>1) {
		  while(n<x)
			  n=n*y;
	  }
	  return n==x;

 // return false;
  }

  public static boolean doTestsPass()
  {
  int[] isPowerList = {10};
  int[] isNotPowerList = {3};

  for(int i : isPowerList)
  {
    if(!isPowerOf10(i))
    {
    System.out.println("Test failed for: " + i);
    return false;
    }
  }

  for(int i : isNotPowerList)
  {
    if(isPowerOf10(i))
    {
    System.out.println("Test failed for: " + i);
    return false;
    }
  }

  System.out.println("All tested passed");
  return true;
  };


  public static void main(String args[])
  {
  doTestsPass();
  }
}