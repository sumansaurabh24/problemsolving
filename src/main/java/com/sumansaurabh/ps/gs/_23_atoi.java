package com.prep.coderpad;
/*
 *					******** IMPORTANT ********
 *
 * THIS IS SAMPLE SOLUTION. IF YOU FIND BETTER SOLUTION PLEASE CONSIDER USING SAME.
 * USE YOUR OWN VARIABLE NAMES - @@@ DO NOT COPY @@@ EXACT VARIABLE NAMES
 *
 */

import java.util.Arrays;

public class _23_atoi
{
    public static int atoi(String inputString)
    {
        int negative=1;
        int i=0;
        if(inputString.charAt(i)=='-') {
        	negative=-1;
        	i++;
        }
        int num=0;
        for(;i<inputString.length();i++) {
        	if(inputString.charAt(i)< '0' || inputString.charAt(i) > '9') {
        		System.out.println();
        		break;
        	}
        	num=10*num+Integer.parseInt(String.valueOf(inputString.charAt(i)));
        }
        System.out.println(num*negative);
    	return num*negative;
    }


    public static boolean doTestsPass()
    {
        boolean result = true;
        result = result && atoi("0") == 0;
        result = result && atoi("1") == 1;
        result = result && atoi("123") == 123;
        result = result && atoi("-1") == -1;
        result = result && atoi("-123") == -123;
        result = result && atoi("123a") == 123;
        result = result && atoi("a") == 0;

        String intMax = String.valueOf(Integer.MAX_VALUE);
        result = result && atoi(intMax) == Integer.MAX_VALUE;

        String intMin = String.valueOf(Integer.MIN_VALUE);
        result = result && atoi(intMin) == Integer.MIN_VALUE;

        return result;
    }


    public static void main(String[] args)
    {
        if(doTestsPass())
        {
            System.out.println("All tests pass");
        }
        else
        {
            System.out.println("There are test failures");
        }
    }
}