package com.sumansaurabh.ps.dp;

public class CoinChange {

    static long countWays(int[] array, int length, int amount) {
        int table[] = new int[amount + 1];

        // Base case (If given value is 0)
        table[0] = 1;

        // Pick all coins one by one and update the table[] values
        // after the index greater than or equal to the value of the
        // picked coin
        for (int i = 0; i < length; i++)
            for (int j = array[i]; j <= amount; j++)
                table[j] += table[j - array[i]];

        return table[amount];

    }


    public static void main(String[] args) {
        int arr[] = {1, 2, 3};
        int m = arr.length;
        int n = 4;
        System.out.println(countWays(arr, m, n));
    }
}
