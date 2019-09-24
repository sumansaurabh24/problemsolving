package com.prep.coderpad;

import java.io.*;
import java.util.*;

public class _05_Prime_Factorization
{
	/**
	   * Return an array containing prime numbers whose product is x
	   * Examples:
	   * primeFactorization( 6 ) == [2,3]
	   * primeFactorization( 5 ) == [5]
	   */
  public static ArrayList<Integer> primeFactorization(int x)
  {int n=x;
	  ArrayList list= new ArrayList();
	  for(int i=2;i<=x;i++) {
		  while(x%i==0) {
			  System.out.println("Method1");
			  x=x/i;
			  list.add(i);
		  }
	  }
	  
	  //Alternate Solution
	  
//	  while (n % 2 == 0) {
//			System.out.print(2 + " ");
//			n = n / 2;
//			System.out.println("Method2");
//		}
//
//		for (int i = 3; i <= n; i = i + 2) {
//			while (n % i == 0) {
//				System.out.print(i + " ");
//				n = n / i;
//				System.out.println("Method2");
//			}
//		}
  return list;
  }

public static void main(String args[])
  {
	
	//System.out.println(primeFactorization(6) + " " + primeFactorization(5) + " " +primeFactorization(2) + " " + primeFactorization(147)); 
	if(primeFactorization(315).equals(Arrays.asList(3, 3, 5, 7)) 
			//&& 
			//primeFactorization(5).equals(Arrays.asList(5))
			) {
		System.out.println("All passed");
	}else {
		System.out.println("Failed");
	}
  
  }
}