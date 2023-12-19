package com.dsAlgo2023.java8;

import java.util.function.Predicate;

public class MyPredicates {
    public static void main(String[] args) {
        Predicate<Integer> greaterthan18 = i-> i>18;
        Predicate<Integer> lessthan60 = i-> i<60;
        myFunc(i -> i>18,20);
        myFunc(greaterthan18,10);
        myFunc(lessthan60,65);
        myFunc(greaterthan18.and(lessthan60),45);
        myFunc(greaterthan18.and(lessthan60),100);

    }

    public static void myFunc(Predicate<Integer> predicates,int age){
        if(predicates.test(age)){
            System.out.println("Eligible!!!");
        }else{
            System.out.println("Not Eligible !!!");
        }
    }
}
