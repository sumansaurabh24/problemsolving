package com.sumansaurabh.ps.ax;

import java.util.Arrays;

public class AliceAndBob {

    static int solution(int[] A, int K , int L){
        int totalApple = 0;

        int[] maxAndPosition = getMaxAndPosition(A, K);
        totalApple += maxAndPosition[0];

        int trailingIndex = maxAndPosition[1] + K;

        int[] leadingArray = Arrays.copyOfRange(A, 0, maxAndPosition[1]);
        int[] trailingArray = Arrays.copyOfRange(A, trailingIndex, A.length);

        int[] maxAndPositionLeading = getMaxAndPosition(leadingArray, L);
        int[] maxAndPositionTrailing = getMaxAndPosition(trailingArray, L);

        if(maxAndPositionLeading[0] > maxAndPositionTrailing[0]){
            totalApple += maxAndPositionLeading[0];
        }else{
            totalApple += maxAndPositionTrailing[0];
        }

        return totalApple;
    }

    static int[] getMaxAndPosition(int[] a, int length){
        int sum = 0;
        int currentSum = 0;
        int index = 0;

        int[] maxAndPosition = new int[2];


        for(int i = 0; i < a.length; i++){

            if(i <= a.length - length) {
                for (int j = i; j < i + length; j++) {
                    currentSum += a[j];
                }
            }

            if(currentSum > sum) {
                sum = currentSum;
                index = i;

            }
            currentSum = 0;
        }

        maxAndPosition[0] = sum;
        maxAndPosition[1] = index;

        return maxAndPosition;
    }

    public static void main(String[] args) {
        int[] a = {6, 1, 4, 6, 3, 2, 7, 4};
        int k = 3, l = 2;
        System.out.println(solution(a, k, l));
    }
}
