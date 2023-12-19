package com.dsAlgo2023.java8;

import java.util.function.Predicate;

public class MyPredicates {
    public static void main(String[] args) {
        myFunc(i -> i>18,20);
        myFunc(i -> i>18,10);
        myFunc(i -> i>18,18);
    }

    public static void myFunc(Predicate<Integer> predicates,int age){
        if(predicates.test(age)){
            System.out.println("Eligible!!!");
        }else{
            System.out.println("Not Eligible !!!");
        }
    }
}
