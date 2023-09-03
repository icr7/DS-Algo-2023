package com.dsAlgo2023.heap;

public class HeapImpl {
    public static void main(String[] args) {
        int [] heap = new int[1000];
        for(int i=0;i<=10;i++)
            heap[i]=i;
        int n = 10;

        buildHeap(heap,n);
        printHeap(heap,n);

    }

    public static void buildHeap(int[] heap, int n){
        int lastParentNode = ( n - 1) / 2;
        for(int i = lastParentNode; i>=0; i--)
            heapify(heap,i,n);
    }

    private static void heapify(int[] heap, int i, int n) {
        int largest = i;
        int left = 2*i+1;
        int right = 2*i+2;

        if(left<n && heap[left]>heap[largest])
            largest=left;
        if(right<n && heap[right]>heap[largest])
            largest= right;

        if(largest!=i){
            int temp = heap[i];
            heap[i] = heap[largest];
            heap[largest] = temp;
            heapify(heap,largest,n);
        }

    }

    private static void printHeap(int[] heap, int n) {
        int i=0;
        while (i!=n)
            System.out.print(heap[i++]+" ");
    }

}