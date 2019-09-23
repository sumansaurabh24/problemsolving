package com.sumansaurabh.ps.gs;

import java.util.ArrayList;
import java.util.List;

public class PrimeFactorization {

    static List<Integer> factors(int n) {
        List<Integer> factors = new ArrayList<>();

        for (int i = 2; i <= n; i++) {

            while (n % i == 0) {
                factors.add(i);
                n = n / i;
            }
        }
        return factors;
    }

    public static void main(String[] args) {
        int n = 315;
        for (int value : factors(n)) {
            System.out.println(value + " ");
        }
    }
}
