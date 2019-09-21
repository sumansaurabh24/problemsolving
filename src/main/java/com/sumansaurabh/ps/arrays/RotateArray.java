package com.sumansaurabh.ps.arrays;

import com.sumansaurabh.ps.Utils;

/**
 * 1. Divide the array two parts: 1,2,3,4 and 5, 6
 * 2. Reverse first part: 4,3,2,1,5,6
 * 3. Reverse second part: 4,3,2,1,6,5
 * 4. Reverse the whole array: 5,6,1,2,3,4
 */
public class RotateArray {

    /**
     * Rotate an array
     * @param arr
     * @param order
     */
    static void rotate(int[] arr, int order){
        if(arr == null || arr.length == 0){
            throw new IllegalArgumentException("Array is null or empty");
        }

        if(order > arr.length){
            order = order % arr.length;
        }

        int index = arr.length - order;

        ReverseArray.reverse(arr, 0 , index-1);
        ReverseArray.reverse(arr, index, arr.length-1);
        ReverseArray.reverse(arr, 0, arr.length-1);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};
        int order = 2;
        rotate(arr, 2);
        Utils.printArray(arr);
    }
}
