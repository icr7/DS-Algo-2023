package com.dsAlgo2023.linkedList;

public class DetectLoopInLinkedList {

    public static void main(String[] args) {
        LinkedList<Integer> myLinkedList = new LinkedList<>();
        myLinkedList.add(1);
        myLinkedList.add(2);
        myLinkedList.add(3);
        myLinkedList.add(4);

        System.out.println(myLinkedList.detectLoop());
    }
}
