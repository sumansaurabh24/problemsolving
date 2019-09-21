package com.sumansaurabh.ps;

public class Utils {

    public static void printArray(int[] arr){
        if(arr == null){
            return;
        }
        for(int value : arr){
            System.out.print(value + " ");
        }
    }
}
