package com.dsAlgo2023.linkedList;

public class LinkedListImpl {
    public static void main(String[] args) throws Exception {
        LinkedList<Integer> list= new LinkedList<>();
        list.addAtEnd(1);
        list.addAtEnd(0);
        list.addAtEnd(0);
        list.addAtEnd(0);
        list.addAtEnd(7);
        list.addAtEnd(-5);
        list.displayLinkedList();
        System.out.println("------------------------------");
        list.addAtStart(100);
        list.addAtStart(777);
        list.displayLinkedList();
        System.out.println("------------------------------");
        list.addAt(111,5);
        list.addAt(222,0);
        list.addAt(222,0);
        list.addAt(222,0);
        list.displayLinkedList();
        System.out.println("contains -5 : "+list.isContain(-5));
        System.out.println("contains 5 : "+list.isContain(5));
        System.out.println("------------------------------");
        System.out.println("delete 0");
        list.delete(0);
        list.delete(222);
        list.displayLinkedList();
        System.out.println("------------------------------");
        System.out.println("------------- size -----------: "+list.size());
    }
}

class LinkedList<T>{
    Node head;
    Node tail;

    int size;
    class Node<T>{
        T value;
        Node next;
        Node(T value){
            this.value=value;
            this.next=null;
        }
    }

    public void addAtEnd(T value){
        Node newNode=new Node(value);
        if(head==null){
            head=newNode;
            tail=newNode;
        }else{
            tail.next=newNode;
            tail=tail.next;
        }
    }

    public void addAtStart(T value){
        Node newNode= new Node(value);
        newNode.next=head;
        head=newNode;
    }

    public void addAt(T value, int pos) throws Exception {
        Node currentNode = head ;
        Node newNode=new Node(value);
        if(pos<0){
            throw new Exception("Invalid Position: "+pos);
        }
        else if(pos==0){
            newNode.next=head;
            head=newNode;
        }else {
            for(int i=0;i<pos-1;i++){
                currentNode=currentNode.next;
                if(currentNode==null){
                    throw new Exception("Invalid Position: "+pos);
                }
            }
            newNode.next=currentNode.next;
            currentNode.next=newNode;
        }

    }
    public void displayLinkedList(){
        Node currentNode=head;
        while(currentNode!=null){
            System.out.println(currentNode.value);
            currentNode=currentNode.next;
        }
    }

    public boolean isContain(T data){
        Node currentNode= head;
        while (currentNode!=null){
            if(currentNode.value.equals(data)){
                return true;
            }
            currentNode=currentNode.next;
        }
        return false;
    }

    public void delete(T data){
        Node currentNode=head;
        Node previousNode=head;
        while(currentNode!=null){
            if(head.value.equals(data)){
                currentNode=head.next;
                head.next=null;
                head=currentNode;
            } else if (currentNode.value.equals(data)) {
                previousNode.next=currentNode.next;
                currentNode=previousNode;
            }
            previousNode=currentNode;
            currentNode=currentNode.next;
        }
    }

    public int size(){
        int size=0;
        Node currentNode=head;
        while(currentNode!=null){
           size++;
           currentNode=currentNode.next;
        }
        return size;
    }

}