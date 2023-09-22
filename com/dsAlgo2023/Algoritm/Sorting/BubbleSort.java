package com.dsAlgo2023.Algoritm.Sorting;

public class BubbleSort {
    public static void main(String[] args) {
        int arr[] = new int[]{7,7,6,9,8,1,3,2,4,5,3,1,2};

        for(int i=0;i< arr.length;i++)
            swap(arr.length-1-i,arr);

        for(int x:arr)
            System.out.print(x+", ");
    }

    private static void swap(int n, int[] arr) {
        for(int i=0;i<n;i++)
            if(arr[i]>arr[i+1]){
                int temp=arr[i];
                arr[i]=arr[i+1];
                arr[i+1]=temp;
            }
    }
}
