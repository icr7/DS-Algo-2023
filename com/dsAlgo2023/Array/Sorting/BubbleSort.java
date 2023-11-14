package com.dsAlgo2023.Array.Sorting;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = new int[]{7, 7, 6, 9, 8, 1, 3, 2, 4, 5, 3, 1, 2};
        int N = arr.length - 1;
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N - i; j++)
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
        for (int x : arr) System.out.print(x + ", ");
    }

}
