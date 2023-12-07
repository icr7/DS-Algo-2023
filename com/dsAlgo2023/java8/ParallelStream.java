package com.dsAlgo2023.java8;

import java.util.ArrayList;
import java.util.List;

public class ParallelStream {
    public static void main(String[] args) {
        List<List<String>> myList= new ArrayList<>();

        for (int i=0;i<100;i++){
            List<String> str = new ArrayList<>();
            for(int j=0;j<100;j++){
                str.add("list: "+i+" string: "+j);
            }
            myList.add(str);
        }

        myList.parallelStream().forEach(System.out::println);
    }
}
