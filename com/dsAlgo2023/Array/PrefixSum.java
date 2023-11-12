package com.dsAlgo2023.Array;

public class PrefixSum {
    public static void main(String[] args) {
        int[] arr = new int[]{10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
        int[] prefixSum = new int[arr.length];
        int prefix = 0;
        for (int i = 0; i < arr.length; i++)
            prefix = prefixSum[i] = prefix + arr[i];

        for (int l = 1; l <= arr.length; l++)
            for (int r = l; r <= arr.length; r++)
                getSumOfSubArray(prefixSum, l - 1, r - 1);
        //l-1 and r-1 cuz in array index start from 0
    }

    private static void getSumOfSubArray(int[] prefixSum, int l, int r) {
        int sum;
        if (l == 0) sum = prefixSum[r];
        else sum = prefixSum[r] - prefixSum[l - 1];
        System.out.println("Sum of sub array(" + l + "," + r + ") : " + sum);
    }
}
