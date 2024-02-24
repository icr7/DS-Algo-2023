package com.dsAlgo2023.linkedList;

public class DeletionInLinkedList
{
    public static void main(String[] args) {
        LinkedList<Integer> mylinkedList = new LinkedList<>();
        mylinkedList.add(10);
        mylinkedList.add(20);
        mylinkedList.add(7);
        mylinkedList.add(2);
        mylinkedList.delete(3);
        mylinkedList.traverse();
    }
}
