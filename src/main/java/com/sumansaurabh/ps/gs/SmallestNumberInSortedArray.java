package com.sumansaurabh.ps.gs;

import java.util.ArrayList;
import java.util.List;

public class SmallestNumberInSortedArray {

    static int findMinUsingLinearSearch(int[] array) {
        int min = array[0];

        for (int value : array) {
            if (value < min) {
                min = value;
            }
        }
        return min;
    }

    static int findMinUsingBinarySearch(int arr[], int low, int high)
    {
        // This condition is needed to handle the case when array
        // is not rotated at all
        if (high < low)  return arr[0];

        // If there is only one element left
        if (high == low) return arr[low];

        // Find mid
        int mid = low + (high - low)/2; /*(low + high)/2;*/

        // Check if element (mid+1) is minimum element. Consider
        // the cases like {3, 4, 5, 1, 2}
        if (mid < high && arr[mid+1] < arr[mid])
            return arr[mid+1];

        // Check if mid itself is minimum element
        if (mid > low && arr[mid] < arr[mid - 1])
            return arr[mid];

        // Decide whether we need to go to left half or right half
        if (arr[high] > arr[mid])
            return findMinUsingBinarySearch(arr, low, mid-1);
        return findMinUsingBinarySearch(arr, mid+1, high);
    }

    public static void main(String[] args) {
//        int[] array = {3, 4, 5, 6,1,2};
//        int minElement = findMinUsingLinearSearch(array);
//        System.out.println(minElement);

        List<int[]> list = new ArrayList<>();
        list.add(new int[]{3, 4, 5, 6, 1, 2});
        list.add(new int[]{-1, 2, 3, 4, 5, 6,});
        list.add(new int[]{1, 2, 3, 4, 5});
        list.add(new int[]{5, 4, 3, 2, 1});
        list.add(new int[]{5, 4, 3, 2, 1, 6});

        list.forEach(intArray -> {
            int element = findMinUsingBinarySearch(intArray, 0, intArray.length - 1);
            System.out.println("Minimum Value : " + element);
        });
    }
}
