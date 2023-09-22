package com.dsAlgo2023.Algoritm.Sorting;

public class SelectionSort {
    public static void main(String[] args) {
        int [] arr = new int[]{6,9,7,8,5,3,2,4,1,4};
        for (int i=0; i< arr.length ;i++){
            int temp=arr[i];
            int minIndex=getMinIndex(i,arr);
            arr[i]=arr[minIndex];
            arr[minIndex]=temp;
        }

        for (int x: arr)
            System.out.print(x+", ");
    }

    private static int getMinIndex(int pos, int[] arr) {
        int minValue=arr[pos];
        int minIndex=pos;
        for(int i=pos;i< arr.length;i++)
            if (arr[i]<minValue){
                minValue=arr[i];
                minIndex=i;
            }
        return minIndex;
    }
}
