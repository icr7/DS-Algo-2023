package com.dsAlgo2023.Array.Searching;

import java.util.Arrays;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = new int[]{10, 8, 20, 78, 6, 2, 55};
        Arrays.sort(arr);
        for (int x : arr) System.out.print(x + ", ");
        int search = 8;
        int searchedIndex = binarySearch(arr, 0, arr.length - 1, search);
        System.out.println(searchedIndex != -1 ? "found at position : " + (searchedIndex + 1) : "not found");

    }

    private static int binarySearch(int[] arr, int l, int r, int k) {
        if (r >= l) {
            int mid = (l + r) / 2;
            if (arr[mid] == k) return mid;
            else if (arr[mid] > k) return binarySearch(arr, l, mid - 1, k);
            else return binarySearch(arr, mid + 1, r, k);
        }
        return -1;
    }
}
