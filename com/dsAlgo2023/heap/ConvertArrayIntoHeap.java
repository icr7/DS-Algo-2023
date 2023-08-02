package com.dsAlgo2023.heap;

public class ConvertArrayIntoHeap {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 5, 4, 6, 13, 10, 9, 8, 15, 17};
        buildHeap(arr);
        printHeap(arr);
        arr=insertIntoHeap(arr, 16);
        System.out.println("\nAfter adding 16 into heap: ");
        printHeap(arr);
        arr=delete(arr,2);
        System.out.println("\nAfter deleting arr[2] i.e 16 from heap: ");
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

    public static int[] insertIntoHeap(int heap[], int data) {
        int newHeap[] = new int[heap.length + 1];
        for (int i = 0; i < heap.length; i++)
            newHeap[i] = heap[i];

        int currPos = newHeap.length - 1;
        int parentPos = (currPos - 1) / 2;

        newHeap[currPos] = data;

        if (currPos == 0) return newHeap;

        while (newHeap[currPos] > newHeap[parentPos]) {
            int temp = newHeap[currPos];
            newHeap[currPos] = newHeap[parentPos];
            newHeap[parentPos] = temp;
            currPos = parentPos;
            parentPos = (currPos - 1) / 2;
        }
        return newHeap;
    }

    public static int[] delete(int[] heap, int index){
        heap[index]=heap[heap.length-1];
        if(heap.length==0) return heap;
        int[] newHeap = new int[heap.length-1];
        for(int i=0;i<heap.length-1;i++)
            newHeap[i]=heap[i];
        heapify(newHeap,index);
        return newHeap;
    }
}
