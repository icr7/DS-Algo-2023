package com.dsAlgo2023.linkedList;

public class ReverseFirstKElementsFromLinkedList {
    public static void main(String[] args) {
        LinkedList<Integer> myList= new LinkedList<>();
        myList.add(1);
        myList.add(2);
        myList.add(3);
        myList.add(4);
        myList.add(5);
        myList.traverse();
        myList.reverseFirstKElements(3);
        System.out.println("after reversing 3 Elements");
        myList.traverse();
    }
}
