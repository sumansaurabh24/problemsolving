package com.sumansaurabh.ps.integer;

public class ReverseInteger {

    public static int reverse(int x) {
        int reversed = 0, previousReversed = 0;
        boolean isNegative = false;

        if (x < 0) {
            isNegative = true;
            x = -x;
        }

        while (x > 0) {
            reversed = reversed * 10 + x % 10;
            x = x / 10;
        }

        if (isNegative) {
            reversed = -reversed;
        }
        return reversed;
    }

    public static void main(String[] args) {
        int num = 1534236469;
        System.out.println(reverse(num));
    }
}
