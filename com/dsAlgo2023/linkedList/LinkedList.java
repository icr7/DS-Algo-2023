package com.dsAlgo2023.linkedList;

import java.util.ArrayList;
import java.util.List;

public class LinkedList<T> {
    private Node<T> head;
    private Node<T> curr;

    private int size;

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
        size++;
    }

    public int size() {
        return this.size;
    }

    public void traverse() {
        Node node = head;
        while (node != null) {
            System.out.print(node.data+", ");
            node = node.next;
        }
        System.out.println();
    }

    public void delete(int pos) {
        if (pos < size() && pos >= 0) {
            Node node = head;
            delete(node, pos);
        } else {
            throw new IllegalArgumentException("Invalid postion: " + pos);
        }
    }

    private void delete(Node node, int pos) {
        if (pos == 0) {
            Node deleteingNode = head;
            head = head.next;
            deleteingNode.next = null;
            return;
        }
        if (pos == 1) {
            Node deleteingNode = node.next;
            node.next = deleteingNode.next;
            deleteingNode.next = null;
            return;
        }
        delete(node.next, --pos);
    }


    public int search(T element) {
        int pos = -1;
        if (head == null) {
            return pos;
        }
        Node currNode = head;
        while (currNode != null) {
            pos++;
            if (currNode.data == element) return pos;
            currNode = currNode.next;
        }
        return -1;
    }

    public void reverse() {
        Node curr = head;
        Node prev = null, next = null;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }

    public void reverseByRecusion() {
        reverseByRecusion(head, null, null);
    }

    private void reverseByRecusion(Node curr, Node prev, Node next) {
        if (curr == null) {
            head = prev;
            return;
        }
        next = curr.next;
        curr.next = prev;
        prev = curr;
        curr = next;
        reverseByRecusion(curr, prev, next);
    }

    public void reverseFirstKElements(int k){
        reverseFirstKElements(head,null,null,k);
    }

    private void reverseFirstKElements(Node curr, Node prev, Node next, int k){
        if(curr==null || k==0){
            head.next=curr;
            head=prev;
            return;
        }
        next=curr.next;
        curr.next=prev;
        prev=curr;
        curr=next;
        reverseFirstKElements(curr,prev,next,--k);
    }

    public void reverseElementsInGroup(int k){
        head=reverseGroup(head,k);
    }

    private Node reverseGroup(Node curr_head, int k){
        if(curr_head == null) return null;

        Node curr=curr_head, prev =null, next=null;
        int count=0;
        while(curr!=null && count<k){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
            count++;
        }
      //  if(next!=null)
        curr_head.next=reverseGroup(next,k);
        return prev;
    }

}
