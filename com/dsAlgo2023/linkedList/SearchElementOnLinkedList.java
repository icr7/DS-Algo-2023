package com.dsAlgo2023.linkedList;

public class SearchElementOnLinkedList {
    public static void main(String[] args) {
        LinkedList<Integer> myLinkedList = new LinkedList<>();
        for(int i=0;i<5;i++) myLinkedList.add(i*2);
        System.out.println(myLinkedList.search(1));
        System.out.println(myLinkedList.search(2));
        System.out.println(myLinkedList.search(8));
        System.out.println(myLinkedList.search(10));
    }
}
