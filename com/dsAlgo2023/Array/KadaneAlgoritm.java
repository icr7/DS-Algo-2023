package com.dsAlgo2023.Array;

public class KadaneAlgoritm {
    public static void main(String[] args) {
        int[] arr = new int[]{-2, -3, 4, -1, -2, 1, 5, -3};
        System.out.println("maximum sum of contiguous subarray : " + maxSubArraySum(arr, arr.length));
    }

    private static int maxSubArraySum(int[] arr, int n) {
        int max_sum = Integer.MIN_VALUE, curr_sum = 0;
        for (int i = 0; i < n; i++) {
            curr_sum += arr[i];
            max_sum = Math.max(max_sum, curr_sum);
            if (curr_sum <= 0) curr_sum = 0;
        }
        return max_sum;
    }
}
