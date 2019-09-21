package com.sumansaurabh.ps.arrays;

import com.sumansaurabh.ps.Utils;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class TwoNumberThatAddUpToN {

    static int[] findSum(int[] arr, int n){

        int[] result = new int[2];
        Set<Integer> set = new HashSet<>();
        for(int i : arr){
            if(set.contains(n-i)){
                result[0] = i ;
                result[1] = n-i;
                break;
            }
            set.add(i);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1, 21, 3, 14, 5, 60, 7, 6};
        int n = 27;
        int[] numbers = findSum(arr, n);
        Utils.printArray(numbers);
    }
}
