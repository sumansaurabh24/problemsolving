package com.sumansaurabh.ps.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LargestRange {

    static int findLargestUsingSorting(int[] arr) {
        Arrays.sort(arr); // (nlogn)
        int maxRange = 0;
        int currentRange = 1;
        for (int i = 0; i < arr.length - 1; i++) {

            if (arr[i] + 1 == arr[i + 1]) {
                currentRange = currentRange + 1;
            } else {
                maxRange = Math.max(maxRange, currentRange);
                currentRange = 1;
            }

        }
        return maxRange; //2nlogn
    }


    static int findLargestUsingDictionary(int[] arr) {
        Map<Integer, Boolean> toBeVisitedMap = new HashMap<>();

        for (int value : arr) {
            toBeVisitedMap.put(value, true);
        }

        int maxRange = 0;
        int currentRange = 1;

        for (int value : arr) {

            boolean toVisit = toBeVisitedMap.get(value);
            if (!toVisit) {
                continue;
            }

            int minusOne = value;

            while (true){
                minusOne = minusOne - 1;
                if(toBeVisitedMap.get(minusOne) == null){
                    break;
                }
                toBeVisitedMap.put(minusOne, false);
                currentRange++;
            }

            int plusOne = value;

            while (true){
                plusOne = plusOne + 1;
                if(toBeVisitedMap.get(plusOne) == null){
                    break;
                }
                toBeVisitedMap.put(plusOne, false);
                currentRange++;
            }

            maxRange = Math.max(maxRange, currentRange);
            currentRange = 1;
        }

        return maxRange;
    }


    public static void main(String[] args) {
        int[] arr = {1, 11, 3, 0, 15, 5, 2, 4, 10, 7, 12, 6, -1};
        int largestRange = findLargestUsingDictionary(arr);
        System.out.println("Largest Range: " + largestRange);
    }

}
