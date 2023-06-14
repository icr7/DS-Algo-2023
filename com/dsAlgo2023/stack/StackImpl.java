package com.dsAlgo2023.stack;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

public class StackImpl {
    public static void main(String[] args) {
        Stack<Integer> myStack = new Stack<>();
        System.out.println("myStack is empty : "+myStack.isEmpty());
        myStack.push(5);
        myStack.push(2);
        myStack.push(7);
        myStack.push(7);
        myStack.printStack();
        myStack.pop();
        System.out.println("After poping ----");
        myStack.printStack();
        System.out.println("myStack is empty : "+myStack.isEmpty());
        System.out.println("peek : "+myStack.peek());

    }
}

class Stack<T>{
    List<T> stackList;
    Stack(){
        stackList=new ArrayList<>();
    }

    public void push(T value){
        stackList.add(value);
    }

    public boolean isEmpty(){
        return stackList.isEmpty();
    }

    public void pop(){
        if(isEmpty()){
            throw new EmptyStackException();
        }
        stackList.remove(stackList.size()-1);
    }

    public void printStack(){
        for(int i=stackList.size()-1;i>=0;i--){
            System.out.println(stackList.get(i));
        }
    }

    public T peek(){
        if(isEmpty()){
            throw new EmptyStackException();
        }
      return stackList.get(stackList.size()-1);
    }

}
