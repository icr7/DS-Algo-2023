package com.dsAlgo2023.queue;

import java.util.ArrayList;
import java.util.List;

public class QueueImpl {
    public static void main(String[] args) throws Exception {
        Queue<Integer> myQueue = new Queue<>();
        System.out.println("size of queue: "+myQueue.size());
        System.out.println("is empty: "+myQueue.isEmpty());
        myQueue.push(2);
        myQueue.push(4);
        myQueue.push(6);
        myQueue.push(8);
        myQueue.push(10);
        System.out.println("size of queue: "+myQueue.size());
        System.out.println("----------------my queue-------------------");
        myQueue.printQueue();
        System.out.println("peek : "+myQueue.peek());
        myQueue.pop();
        System.out.println("peek after 1st pop: "+myQueue.peek());
        myQueue.pop();
        System.out.println("peek after 2nd pop: "+myQueue.peek());
        System.out.println("----------------my queue after 2 pops-------------------");
        myQueue.printQueue();
        System.out.println("size of queue: "+myQueue.size());
    }
}

class Queue<T>{
    List<T> queueList;

    Queue(){
        this.queueList=new ArrayList<>();
    }

    public void push(T value){
        this.queueList.add(value);
    }

    public boolean isEmpty(){
        return this.queueList.isEmpty();
    }
    public T peek() throws Exception {
        if(isEmpty()){
            throw new Exception("Empty Queue Execption");
        }
        return this.queueList.get(0);
    }

    public void pop() throws Exception {
        if(isEmpty()){
            throw new Exception("Empty Queue Execption");
        }else{
            this.queueList.remove(0);
        }
    }

    public int size(){
        return queueList.size();
    }

    public void printQueue(){
        for(T x : this.queueList){
            System.out.println(x);
        }
    }
}