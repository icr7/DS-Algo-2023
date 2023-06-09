package com.dsAlgo2023.Algoritm.Greedy;

import java.util.*;

/*
Given the weights and profits of N items, in the form of {weight,profit}
put these items in a knapsack of capacity W to get the maximum total profit
in the knapsack. In Fractional Knapsack, we can break items for maximizing
the total value of the knapsack.
 */
public class FractionalKnapsackProblem {
    public static void main(String[] args) {
        List<Item>itemList = new ArrayList<>();
        itemList.add(new Item(10,40));
        itemList.add(new Item(30,30));
        itemList.add(new Item(20,80));
        itemList.add(new Item(50,70));

        int weightConstraint=60;
        System.out.println("iteamList : "+itemList);
        System.out.println(maximumProfit(itemList, weightConstraint));
    }

    public static double maximumProfit(List<Item> itemList, int w){
        Collections.sort(itemList,new Comparator<Item>(){
            @Override
            public int compare(Item item1, Item item2){
                return -1*Double.compare((double) item1.profit/item1.weight, (double) item2.profit/item2.weight);
            }
        });

        System.out.println("sorted itemList based on profit/weight ratio : "+itemList);
        double maxProfit = 0;
        for(Item item : itemList){
            if(w-item.weight>=0){
                System.out.println("picked item : "+item);
                maxProfit=maxProfit+item.profit;
                if(w-item.weight==0){
                    return maxProfit;
                }
            }
            else{
                System.out.println("picked item weight : "+(double)item.weight/w +" profit : "+item.profit*w/item.weight);
                maxProfit=maxProfit+((double)item.profit*w/item.weight);
                return maxProfit;
            }
            w=w-item.weight;
        }

        return 0;

    }

    static class Item{
        int weight;
        int profit;
        Item(int weight, int profit){
            this.weight=weight;
            this.profit=profit;
        }

        @Override
        public String toString() {
            return "Item{" +
                    "weight=" + weight +
                    ", profit=" + profit +
                    '}';
        }
    }
}
