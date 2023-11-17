package com.dsAlgo2023.Array.Sorting;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = new int[]{6, 9, 1, 5, 7, 4};
        mergeSort(arr, 0, arr.length - 1);
        for (int x : arr) System.out.print(x + ", ");
    }

    private static void mergeSort(int[] arr, int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;
            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);
            merge(arr, l, m, r);
        }
    }

    private static void merge(int[] arr, int l, int m, int r) {
        int[] L = new int[m + 1 - l];
        int[] R = new int[r - m];

        for (int i = 0; i < L.length; i++)
            L[i] = arr[l + i];
        for (int i = 0; i < R.length; i++)
            R[i] = arr[m + 1 + i];

        int i = 0, j = 0;
        int k = l;
        while (i < L.length && j < R.length) if (L[i] < R[j]) arr[k++] = L[i++];
        else arr[k++] = R[j++];

        while (i < L.length) arr[k++] = L[i++];

        while (j < R.length) arr[k++] = R[j++];
    }
}
