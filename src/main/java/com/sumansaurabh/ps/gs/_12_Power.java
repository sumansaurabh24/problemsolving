package com.prep.coderpad;
public class _12_Power {

  /* Given base and integer exponent, compute value of base raised to the power of exponent.
   */
  public static double power(double base, int exp) {
    //Your code goes here
	  double result=1.0;
	  for(int i=1;i<=exp;i++) {
		  result=result*base;
	  }
    return result;
  }

  public static boolean doTestPass() {
    boolean testsPass = true;
    double result = power(2,2);
    return testsPass && result==4;
  }

  public static void main( String[] args ) {
    if(doTestPass()){
      System.out.println("Pass");
    }
    else{
      System.out.println("There are failures");
    }
  }
}