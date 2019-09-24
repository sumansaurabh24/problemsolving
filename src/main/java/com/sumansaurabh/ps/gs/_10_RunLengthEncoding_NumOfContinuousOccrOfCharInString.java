package com.prep.coderpad;
import org.junit.*;
import org.junit.runner.*;
import static org.junit.Assert.*;

import java.util.Arrays;

/*
 * Implement a run length encoding function.
 * For a string input the function returns output encoded as follows:
 *
 * "a"     -> "a1"
 * "aa"    -> "a2"
 * "aabbb" -> "a2b3"
 */
public class _10_RunLengthEncoding_NumOfContinuousOccrOfCharInString {

  public static String rle(String input) {
    // Your code goes here
	  int count=1;
	  StringBuilder sb= new StringBuilder();
	  for(int i=0;i<input.length();i++) {
		  if(i<input.length()-1 && input.charAt(i)==input.charAt(i+1)) {
			  count++;
		  }else {
			  sb.append(input.charAt(i)).append(count);
			  count=1;
		  }
	  }
	  
    return sb.toString();
  }


 public static void main(String[] args)  {
    
	  if("".equals(rle("")) && 
			  "a1".equals(rle("a")) && 
			  "a3".equals(rle("aaa"))){
		  System.out.println("Passed");
	  }else {
		  System.out.println("Failed");
	  }
  }
}