package com.dsAlgo2023.Algoritm.DivideAndConquer;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = new int[]{6, 9, 1, 5, 7, 4};
        mergeSort(arr, 0, 5);
        for (int a : arr) {
            System.out.print(a + "  ");
        }
    }

    private static void mergeSort(int[] arr, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            mergeSort(arr, low, mid);
            mergeSort(arr, mid + 1, high);
            merge(arr, low, mid, high);
        }
    }

    private static void merge(int[] arr, int low, int mid, int high) {
        int i = low;
        int j = mid + 1;
        int k = low;
        int[] brr = new int[high + 1];

        while (i <= mid && j <= high) {
            if (arr[i] < arr[j]) {
                brr[k++] = arr[i++];
            } else {
                brr[k++] = arr[j++];
            }
        }

        while (i <= mid) {
            brr[k++] = arr[i++];
        }

        while (j <= high) {
            brr[k++] = arr[j++];
        }

        for (k = low; k <= high; k++) {
            arr[k] = brr[k];
        }

    }

}
