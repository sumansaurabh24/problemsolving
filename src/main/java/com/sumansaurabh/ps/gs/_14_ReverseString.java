package com.prep.coderpad;

import java.io.*;
import java.util.*;

public class _14_ReverseString{
  /**
   * public static String reverseStr( String str )
   * Example: reverseStr(str) where str is "abcd" returns "dcba".
   */
  public static String reverseStr( String str ){
    //your code goes here
	  char []strArray=str.toCharArray();
	  for(int i=0;i<strArray.length/2;i++) {
		  char temp=strArray[i];
		  strArray[i]=strArray[strArray.length-i-1];
		  strArray[strArray.length-i-1]=temp;
		 // System.out.println(strArray);
	  }
	  System.out.println(strArray);
    return String.valueOf(strArray);
  }

  
  public static void main(String[] args){
  
  String testString;
    String solution;
    boolean result = true;

    result = result && reverseStr("abcd").equals("dcba");
  
  if(result){
    System.out.println("All tests pass");
  }
  else{
    System.out.println("There are test failures");
  }

   }
}