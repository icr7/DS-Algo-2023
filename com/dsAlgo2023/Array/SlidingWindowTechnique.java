package com.dsAlgo2023.Array;

public class SlidingWindowTechnique {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 4, 2, 10, 2, 3, 1, 0, 20};
        int k = 4;
        System.out.println(MaxSum.maxSumOfConsecutiveNumber(arr, arr.length, k));
    }
}

class MaxSum {
    public static int maxSumOfConsecutiveNumber(int[] arr, int n, int k) {
        if (k > n) return -1;
        int maxSum = 0;
        for (int i = 0; i < k; i++) maxSum += arr[i];
        int window = maxSum;
        for (int i = k; i < n; i++) {
            window += arr[i] - arr[i - k];
            maxSum = Math.max(maxSum, window);
        }
        return maxSum;
    }
}