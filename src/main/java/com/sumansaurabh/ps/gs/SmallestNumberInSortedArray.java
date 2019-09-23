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

    static int findMinUsingBinarySearch(int[] array, int start, int end) {

        if (start < end) {
            int mid = start + (end - start) / 2;
            if (mid == 0 || (array[mid] < array[mid - 1] && array[mid] <= array[mid + 1])) {
                return mid;
            } else if (array[mid] > array[end]) {
                return findMinUsingBinarySearch(array, mid + 1, end);
            } else {
                return findMinUsingBinarySearch(array, start, mid - 1);
            }
        }

        return start;
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
            System.out.println("Minimum Value : " + intArray[element]);
        });
    }
}
