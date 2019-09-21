package com.sumansaurabh.ps.integer;

public class PalindromeInteger {

    public static void main(String[] args) {
        int num = -121;
        boolean isPalindrome = checkPalindrome(num);
        System.out.println(isPalindrome);
    }

    private static boolean checkPalindrome(int num) {
        if (num < 0) {
            return false;
        }

        int temp = num;
        int reversed = 0;

        while (num > 0) {
            int remainder = num % 10;
            reversed = (reversed * 10) + remainder;
            num = num / 10;
        }

        if (reversed == temp) {
            return true;
        } else {
            return false;
        }
    }
}
