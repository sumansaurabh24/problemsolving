package com.sumansaurabh.ps.gs;

public class SecondSmallestInArray {

    static int find(int[] arr){

        int smallest = Integer.MAX_VALUE;
        int secondSmallest = Integer.MAX_VALUE;

        if(arr.length < 2){
            return arr[0];
        }

        for(int value : arr){

            if(value < smallest){
                secondSmallest = smallest;
                smallest = value;
            }else if( value != smallest && value < secondSmallest){
                secondSmallest = value;
            }
        }

        return secondSmallest;
    }

    public static void main(String[] args) {
        int[] arr = {0, 1};
        System.out.println(find(arr));
    }
}
