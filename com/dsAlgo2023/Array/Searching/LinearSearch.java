package com.dsAlgo2023.Array.Searching;

public class LinearSearch {
    public static void main(String[] args) {
        int [] arr = new int[]{10, 8, 20, 78, 6, 2, 55};
        int search = 6;
        int searchedIndex = search(arr, search);
        System.out.println(searchedIndex != -1 ? "found at position : " + searchedIndex : "not found");
    }

    private static int search(int[] arr, int target) {
        for(int i=0;i<arr.length;i++)
            if(arr[i]==target)
                return i+1;
        return -1;
    }
}
