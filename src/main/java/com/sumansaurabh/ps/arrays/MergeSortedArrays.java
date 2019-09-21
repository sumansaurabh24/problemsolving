package com.sumansaurabh.ps.arrays;

import com.sumansaurabh.ps.Utils;

import java.util.Arrays;

public class MergeSortedArrays {

    static int[] merge(int arr1[], int arr2[]){
        int firstArrayLength = arr1.length, secondArrayLength = arr2.length;
        int resultArrayLength = firstArrayLength + secondArrayLength;

        int firstPointer = 0, secondPointer = 0, thirdPointer = 0;
        int[] result = new int[resultArrayLength];

        while (firstPointer < firstArrayLength && secondPointer < secondArrayLength){

            if(arr1[firstPointer] < arr2[secondPointer]){
                result[thirdPointer] = arr1[firstPointer];
                thirdPointer++;
                firstPointer++;
            }else{
                result[thirdPointer] = arr2[secondPointer];
                thirdPointer++;
                secondPointer++;
            }
        }

        while (firstPointer < firstArrayLength){
            result[thirdPointer++] = arr1[firstPointer++];
        }

        while (secondPointer < secondArrayLength){
            result[thirdPointer++] = arr2[secondPointer++];
        }

        return result;
    }

    public static void main(String[] args) {
        int arr1[] = {1, 3, 4, 5, 6, 8};
        int arr2[] = {2, 7, 9, 15};
        int[] merged = merge(arr1, arr2);
        Utils.printArray(merged);
    }
}
