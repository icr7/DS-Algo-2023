package com.dsAlgo2023.linkedList;

public class LinkedList<T> {
    Node head;
    Node curr;

    static class Node<T> {
        T data;
        Node next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }

        @Override
        public String toString() {
            return "Node{" + "data=" + data + ", next=" + next + '}';
        }

    }

    public void add(T data) {
        if (head == null) {
            head = new Node<>(data);
            curr = head;
        } else {
            curr.next = new Node<>(data);
            curr = curr.next;
        }
    }
}
