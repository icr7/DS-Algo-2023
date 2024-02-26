package com.dsAlgo2023.linkedList;

public class ReverseKElementsInGroupFromLinkedList {
    public static void main(String[] args) {
        LinkedList<Integer>myList = new LinkedList<>();
        for (int i =1; i<11; i++)
            myList.add(i);
        myList.traverse();
        myList.reverseElementsInGroup(3);
        myList.traverse();
    }
}
