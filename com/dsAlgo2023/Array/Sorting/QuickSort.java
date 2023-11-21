package com.dsAlgo2023.Array.Sorting;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = new int[]{10, 7, 8, 9, 1, 5};
        quickSort(arr, 0, arr.length - 1);
        for (int x : arr) System.out.print(x + ", ");
    }

    private static void quickSort(int[] arr, int l, int r) {
        if (l < r) {
            int pi = partition(arr, l, r);
            quickSort(arr, l, pi - 1);
            quickSort(arr, pi + 1, r);
        }
    }

    private static int partition(int[] arr, int l, int r) {
        int i = l;
        int pivot = arr[r];
        for (int j = l; j < r; j++)
            if (arr[j] < pivot) {
                swap(arr, i, j);
                i++;
            }
        swap(arr, i, r);
        return i;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
