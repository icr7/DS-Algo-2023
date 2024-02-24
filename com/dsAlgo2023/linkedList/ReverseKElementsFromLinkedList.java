package com.dsAlgo2023.linkedList;

public class ReverseKElementsFromLinkedList {
    public static void main(String[] args) {
        LinkedList<Integer> myList= new LinkedList<>();
        myList.add(1);
        myList.add(2);
        myList.add(3);
        myList.add(4);
        myList.add(5);
        myList.traverse();
        myList.reverseKElements(3);
        System.out.println("after reversing 3 Elements");
        myList.traverse();
    }
}
