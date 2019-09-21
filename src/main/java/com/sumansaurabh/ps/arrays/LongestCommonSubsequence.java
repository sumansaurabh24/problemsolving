package com.sumansaurabh.ps.arrays;

import com.sumansaurabh.ps.Utils;
import com.sumansaurabh.ps.linkedlist.ListNode;

import java.util.ArrayList;
import java.util.List;

public class LongestCommonSubsequence {

    static int[][] inMemory;

    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 1};
        int[] arr2 = {3, 4, 1, 2, 1, 3};
        int n = arr1.length;
        int m = arr2.length;

        inMemory = new int[n + 1][m + 1];

        int lcs = findLcs(arr1, arr2, n, m);
        System.out.println(lcs);
//        Utils.printArray(lcs);
    }

    private static int findLcs(int[] arr1, int[] arr2, int n, int m) {

        if (inMemory[n][m] != 0) {
            return inMemory[n][m];
        }

        if (n == 0 || m == 0) {
            return 0;
        } else if (arr1[n - 1] == arr2[m - 1]) {
            list.add(arr1[n - 1]);
            return 1 + findLcs(arr1, arr2, n - 1, m - 1);
        } else {
            int max = Math.max(findLcs(arr1, arr2, n - 1, m), findLcs(arr1, arr2, m - 1, n));
            inMemory[n][m] = max;
            return max;
        }
    }
}
