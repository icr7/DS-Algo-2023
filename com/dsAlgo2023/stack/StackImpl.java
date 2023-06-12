package com.dsAlgo2023.stack;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

public class StackImpl {
    public static void main(String[] args) {
        Stack<Integer> myStack = new Stack<>();
        myStack.push(5);
        myStack.push(2);
        myStack.push(7);
        myStack.push(7);
        myStack.pop();
        myStack.printStack();

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

    public void pop(){
        if(stackList==null){
            throw new EmptyStackException();
        }
        stackList.remove(stackList.size()-1);
    }

    public void printStack(){
        for(T x:stackList){
            System.out.println(x);
        }
    }
}
