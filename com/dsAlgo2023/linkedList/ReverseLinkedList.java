package com.dsAlgo2023.linkedList;

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

        head = reverseLinkedListInGroup(head,4);
        System.out.println("After reversing in group of 4 ---->\n" + head);

    }


    public static Node reverseLinkedListInGroup(Node head,int k){
        Node prev=null;
        Node next=null;
        Node curr=head;
        int count=0;
        while(count<k && curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
            count++;
        }
        if(next!=null)
        head.next=reverseLinkedListInGroup(next,k);
        return prev;
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