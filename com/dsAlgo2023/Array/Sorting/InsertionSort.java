package com.dsAlgo2023.Array.Sorting;

public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = new int[]{7, 3, 8, 9, 1};

        for (int i = 1; i < arr.length; i++)
            for (int j = i; j > 0 && arr[j - 1] > arr[j]; j--) {
                int temp = arr[j];
                arr[j] = arr[j - 1];
                arr[j - 1] = temp;
            }
        for (int x : arr) System.out.print(x + ", ");
    }
}
