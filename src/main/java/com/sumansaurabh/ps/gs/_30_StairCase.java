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

class _30_StairCase
{
  // Recursive solution
  public static Integer countSteps(Integer n)
  {
	  if(n <= 0) return 0;
	  if(n == 1) return 1;
	  if(n == 2) return 2;
	  if(n == 3) return 4;
 
  else return countSteps(n - 3) + countSteps(n - 2) + countSteps(n - 1); 
 }


  public static boolean doTestsPass()
  {

    return countSteps(3) == 4
      && countSteps(4) == 7
      && countSteps(1) == 1
      && countSteps(2) == 2
      && countSteps(0) == 0
      && countSteps(-5) == 0
      && countSteps(10) == 274
      && countSteps(36) == 2082876103; // Will cause naive solution to time-out
  }


  public static void main(String[] args)
  {
    if(doTestsPass())
    {
      System.out.println("All tests pass");
    }
    else
    {
      System.out.println("Tests fail.");
    }

    for (Integer n = 1; n <= 5; n++)
    {
      Integer numberOfCombinations = countSteps(n);
      System.out.println(n + " steps => " + numberOfCombinations);
    }
  }
}