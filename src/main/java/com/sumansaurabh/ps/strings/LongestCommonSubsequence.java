package com.sumansaurabh.ps.strings;

public class LongestCommonSubsequence {

    static int[][] memoize;

    static int findLcs(String s1, String s2, int n, int m) {
        if (memoize[n][m] != 0) {
            return memoize[n][m];
        }
        if (n == 0 || m == 0) {
            return 0;
        } else if (s1.charAt(n - 1) == s2.charAt(m - 1)) {
            return 1 + findLcs(s1, s2, n - 1, m - 1);
        } else {
            int temp1 = findLcs(s1, s2, n - 1, m);
            int temp2 = findLcs(s1, s2, n, m - 1);
            int result = Math.max(temp1, temp2);
            memoize[n][m] = result;

            return result;
        }
    }

    public static void main(String[] args) {
        String s1 = "AGGTAB";
        String s2 = "GXTXAYB";
        memoize = new int[s1.length() + 1][s2.length() + 1];
        int length = findLcs(s1, s2, s1.length(), s2.length());
        System.out.println("Longest Common Subsequence for both string is : " + length);
    }
}
