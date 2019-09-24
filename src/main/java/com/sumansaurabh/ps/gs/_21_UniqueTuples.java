package com.prep.coderpad;
 import java.util.Arrays;
import java.util.HashSet;

public class _21_UniqueTuples {

  public static HashSet<String> uniqueTuples( String input, int len ) {
    // your code
    HashSet<String> result = new HashSet<String>();
   for(int i=0;i<=input.length()-len;i++) {
	   System.out.println(input.substring(i, i+2));
	   result.add(input.substring(i, i+2));
	   
   }
    return result;
  }

  public static void main( String[] args ) {
    String input = "aab";
    String input1 = "abbccde";

    HashSet<String> result = uniqueTuples(input, 2);
    HashSet<String> result1 = uniqueTuples(input1, 2);

    if ((result.contains("aa") && result.contains("ab"))
            && (result1.containsAll(Arrays.asList("ab", "bb", "bc", "cc", "cd", "de")) && result1.size() == 6)) {
      System.out.println( "Test passed." );
     
    } else {
      System.out.println( "Test failed." );
      
    }
  }
}