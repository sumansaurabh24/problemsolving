package com.prep.coderpad;
/**
 *  
 *  e.g.
 *      for the input: "abbbccda" the longest uniform substring is "bbb" (which starts at index 1 and is 3 characters long).
 */

import java.util.*;

public class _01_LongestUniformString {

  private static final Map<String, int[]> testCases = new HashMap<String, int[]>();

  static int[] longestUniformSubstring(String input){
    int longestStart = -1;
    int longestLength = 0;
    
    if(input.length()!=0) {
    	int count=1;
    	for(int i=0;i<input.length();i++) {
    		if(i<input.length()-1 && input.charAt(i)==input.charAt(i+1)) {
    			count++;
    		}else {
    			if(longestLength<count)
    			{
    				longestLength=count;
    				longestStart=i-count+1;
    			}count=1;
    		}
    	}
    }
    // your code goes here
    return new int[]{ longestStart, longestLength };
  }

  public static void main(String[] args) {
	  //System.out.println('a'=='A');
    testCases.put("", new int[]{-1, 0});
    testCases.put("10000111", new int[]{1, 4});
    testCases.put("aabbbbbCdAAAAAAA", new int[]{9, 7});

    boolean pass = true;
    for(Map.Entry<String,int[]> testCase : testCases.entrySet()){
      int[] result = longestUniformSubstring(testCase.getKey());
      pass = pass && (Arrays.equals(result, testCase.getValue()));
    }
    if(pass){
      System.out.println("Pass!");
    } else {
      System.out.println("Failed! ");
    }
  }
}