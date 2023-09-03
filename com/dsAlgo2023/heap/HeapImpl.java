package com.dsAlgo2023.heap;

public class HeapImpl {
    public static void main(String[] args) {
        int [] heap = new int[1000];
        for(int i=0;i<=10;i++)
            heap[i]=i;
        int n = 10;
        printHeap(heap,n);
        System.out.println("\nAfter converting array into heap ");
        buildHeap(heap,n);
        printHeap(heap,n);
        int index = 3; //i.e 7
        System.out.println("\nAfter deleting "+heap[index]);
        n = deleteFromHeap(index, heap, n);
        printHeap(heap,n);
        int data = 7;
        System.out.println("\nAfter inserting 7 into Heap ");
        n=insertIntoHeap(data,heap,n);
        printHeap(heap,n);

    }


    private static void buildHeap(int[] heap, int n){
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

    private static int deleteFromHeap(int index, int[] heap, int n) {
        heap[index]=heap[--n];
        heapify(heap,index,n);
        return n;
    }

    private static int insertIntoHeap(int data, int[] heap, int n) {
        heap[n++]=data;
        int i = n-1;
        while(i>0){
            int parent = (i-1)/2;
            if(heap[parent]<heap[i]){
                int temp = heap[parent];
                heap[parent]=heap[i];
                heap[i]=temp;
            }
            break;
        }
        return n;
    }

}