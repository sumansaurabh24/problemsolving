package com.prep.coderpad;
public class _08_AddFraction {

  /**
   * Given two fractions passed in as int arrays,
   * returns the fraction which is result of adding the two input fractions.
   */
  public static int[] addFractions( int[] fraction1, int[] fraction2 ) {
    // Write your code here
	  
	  int []res=new int [2];
	  int num=fraction1[0]*fraction2[1]+fraction1[1]*fraction2[0];
	  int den=fraction1[1]*fraction2[1];
	  
	  //Find GCD
	  int min=Math.min(Math.abs(num), Math.abs(den));
	  int GCD=1;
	  for(int i=min;i>0;i--) {
		  if(num%i==0 && den%i==0) {
			  GCD=i;break;
		  }
	  }
	  res[0]=num/GCD;
	  res[1]=den/GCD;
	  
    return ( res );
  }

  
  public static void main( String[] args ) {
    int[] result = addFractions( new int[]{ -2, 3 }, new int[]{ 1, 2 } );

    if( result[ 0 ] == -1 && result[ 1 ] == 6 ) {
      System.out.println( "Test passed." );
      //return true;
    } else {
      System.out.println( "Test failed." );
      //return false;
    }
  }
}