package com.dsAlgo2023.linkedList;

public class ReverseLinkedList {
    public static void main(String[] args) {
        Node head= new Node(1);
        head.next=new Node(2);
        head.next.next=new Node(2);
        head.next.next.next=new Node(4);
        head.next.next.next.next=new Node(5);

        System.out.println(head);
        System.out.println("After reversing ---->");
        System.out.println(reverseLinkedList(head));

    }

    private static Node reverseLinkedList(Node head) {
        Node prev=null;
        Node next=null;
        Node curr=head;
        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
       return head=prev;

    }
}

class Node{
    int data;
    Node next;
    Node(){};
    Node(int data){
        this.data=data;
        this.next=null;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", next=" + next +
                '}';
    }
}