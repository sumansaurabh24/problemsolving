package com.sumansaurabh.ps.arrays;

import com.sumansaurabh.ps.Utils;

public class ReverseArray {

    static void reverse(int[] arr, int left, int right) {

        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        int arr[] = {4, 3, 2, 1, 5};
        reverse(arr, 0, arr.length - 1);
        Utils.printArray(arr);
    }
}
