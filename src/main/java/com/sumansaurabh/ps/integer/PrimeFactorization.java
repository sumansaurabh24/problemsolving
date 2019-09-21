package com.sumansaurabh.ps.integer;

import java.util.ArrayList;
import java.util.List;

public class PrimeFactorization {

    static List<Integer> factors(int n) {
        List<Integer> factors = new ArrayList<>();

        while (n % 2 == 0) {
            factors.add(2);
            n = n / 2;
        }

        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            while (n % i == 0) {
                factors.add(i);
                n = n / i;
            }
        }

        if(n > 2){
            factors.add(n);
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
