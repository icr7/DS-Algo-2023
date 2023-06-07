package com.dsAlgo2023.recursion;

public class Basics {
    public static void main(String[] args) {
        for(int i=1;i<=10;i++)System.out.println("factorial of "+i+" : "+factorial(i));
        System.out.println("-------------------------------------------------");
        for(int i=1;i<=10;i++)System.out.println("fibonacci of "+i+" : "+fibonacci(i));

    }
    public static int factorial(int num){
        if(num==1){
            return num;
        }
        num=num*factorial(num-1);
        return num;
    }

    public static int fibonacci(int n){
        if(n==0) return 0;
        if(n==1)return 1;

        return fibonacci(n-2)+fibonacci(n-1);
    }

}