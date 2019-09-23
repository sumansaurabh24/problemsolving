package com.sumansaurabh.ps.gs;

import com.sumansaurabh.ps.Utils;

public class AddFractions {

    static int[] addFractions(int[] fraction1, int[] fraction2){
        if(fraction1.length != 2 || fraction2.length != 2){
            return null;
        }

        int sum = (fraction1[0] * fraction2[1]) + (fraction1[1] * fraction2[0]);
        int denominator = (fraction1[1] * fraction2[1]);

        int min = Math.min(sum, denominator);
        for(int i = 2; i < min; i++){
            while (sum % i == 0 && denominator % i ==0){
                sum = sum / i;
                denominator = denominator / i;
            }
        }

        return new int[]{sum, denominator};
    }

    public static void main(String[] args) {
        int[] result = addFractions( new int[]{ -2, 3 }, new int[]{ 1, 2 } );
        Utils.printArray(result);
    }
}
