package com.dsAlgo2023.heap;

public class ConvertArrayIntoHeap {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 5, 4, 6, 13, 10, 9, 8, 15, 17};
        buildHeap(arr);
        printHeap(arr);
    }

    public static void buildHeap(int[] arr) {
        int lastLeafNode = (arr.length / 2) - 1;
        for (int i = lastLeafNode; i >= 0; i--) {
            heapify(arr, i);
        }

    }

    public static void heapify(int[] arr, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;


        if (left < arr.length && arr[left] > arr[largest]) largest = left;
        if (right < arr.length && arr[right] > arr[largest]) largest = right;
        if (largest != i) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;
            heapify(arr, largest);
        }
    }

    public static void printHeap(int[] heap) {
        for (int x : heap) {
            System.out.print(x + " ");
        }
    }
}
