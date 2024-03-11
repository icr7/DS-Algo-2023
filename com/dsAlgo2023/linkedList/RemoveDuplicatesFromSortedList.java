package com.dsAlgo2023.linkedList;

public class RemoveDuplicatesFromSortedList {

    public static void main(String[] args) {
        LinkedList<Integer> myLinkedList = new LinkedList<>();
        myLinkedList.add(1);
        myLinkedList.add(1);
        myLinkedList.add(2);
        myLinkedList.add(2);
        myLinkedList.add(2);
        myLinkedList.add(3);
        myLinkedList.add(3);
        myLinkedList.add(3);
        myLinkedList.add(3);
        myLinkedList.add(4);

        myLinkedList.traverse();
        myLinkedList.deleteDuplicates();
        System.out.println("After removing duplicates: ");
        myLinkedList.traverse();
    }
}
