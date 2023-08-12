package com.dsAlgo2023.linkedList;

import java.util.ArrayList;
import java.util.List;

public class ReverseLinkedList {
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(2);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);
        head.next.next.next.next.next.next = new Node(7);
        head.next.next.next.next.next.next.next = new Node(8);
        head.next.next.next.next.next.next.next.next = new Node(9);
        head.next.next.next.next.next.next.next.next.next = new Node(10);

        System.out.println("initially --->\n" + head);

        head = reverseLinkedList(head);
        System.out.println("After reversing linked list ---->\n" + head);

        head = reverseLinkedList(head);
        System.out.println("Undo reversing linked list ---->\n" + head);

        head = reverseLinkedListInGroup(head);
        System.out.println("After reversing in group ---->\n" + head);

    }


    public static Node reverseLinkedListInGroup(Node head) {
        Node prev = null;
        Node next = null;
        Node curr = head;
        int count = 0;
        List<Pair> pairs = new ArrayList<>();
        Node tail = head;
        while (curr != null) {
            if ((count != 0 && count % 4 == 0) || curr.next == null) {
                Pair pair = new Pair();
                if (curr.next == null) pair.head = curr;
                else pair.head = prev;
                pair.tail = tail;
                pairs.add(pair);
                tail = curr;
            }
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            count++;
        }

        for (int i = 0; i < pairs.size(); i++) {
            if (i == pairs.size() - 1) pairs.get(i).tail.next = null;
            else pairs.get(i).tail.next = pairs.get(i + 1).head;
        }

        return pairs.get(0).head;
    }

    private static Node reverseLinkedList(Node head) {
        Node prev = null;
        Node next = null;
        Node curr = head;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;

    }
}

class Pair {
    Node head;
    Node tail;
}

class Node {
    int data;
    Node next;


    Node(int data) {
        this.data = data;
        this.next = null;
    }

    @Override
    public String toString() {
        return "Node{" + "data=" + data + ", next=" + next + '}';
    }
}