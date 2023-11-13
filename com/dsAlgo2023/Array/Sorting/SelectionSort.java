package com.dsAlgo2023.Array.Sorting;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = new int[]{6, 9, 7, 8, 5, 3, 2, 4, 1, 4};
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;
            int temp = arr[i];
            for (int j = i + 1; j < arr.length; j++)
                if (arr[min] > arr[j]) min = j;

            arr[i] = arr[min];
            arr[min] = temp;
        }
        for (int x : arr) System.out.print(x + ", ");
    }
}
