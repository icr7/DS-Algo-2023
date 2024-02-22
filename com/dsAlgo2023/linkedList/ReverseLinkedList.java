package com.dsAlgo2023.linkedList;

public class ReverseLinkedList {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.traverse();
        System.out.println("---------- Reverse Linked List ----------");
        list.reverse();
        list.traverse();
        System.out.println("---------- Reverse the Linked List by recursion----------");
        list.reverseByRecusion();
        list.traverse();
    }
}
