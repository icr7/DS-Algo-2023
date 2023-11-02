package com.dsAlgo2023.Algoritm.DynamicProgramming;

import java.util.HashMap;
import java.util.Map;

public class KnapSack01 {
    public static void main(String[] args) {
        int [] wt = new int[]{1,2,3,4};
        int  [] val= new int[]{9,6,10,8};
        int W=5;
        System.out.println(knapSack(wt,val,W));
    }

    private static int  knapSack(int[] wt, int[] val, int W) {
        Map<String,Integer> dp = new HashMap<>();
         int result = knapSack(wt,val,0,0,0,W,dp);
        System.out.println("dp--> "+dp.toString());
         return result;
    }

    private static int knapSack(int[] wt, int[] val, int curr, int profit, int maxProfit, int W, Map<String, Integer> dp) {

        if(W<0)
            return maxProfit;
        if(profit>maxProfit)
            maxProfit=profit;

        for(int i=curr; i<wt.length;i++){
            System.out.println(i+"#"+W+" / "+profit);
            dp.put(i+"#"+W,profit);
            maxProfit= knapSack(wt,val,i+1,profit+val[i],maxProfit,W-wt[i], dp);

        }

        return maxProfit;
    }
}
