package com.dsAlgo2023.Algoritm.DynamicProgramming;

import java.util.Arrays;

public class CoinChangeProblem {
    public static void main(String[] args) {
        int [] coinTypes = new int[]{7,5,1};
        int sum=18;
        int dp[]=new int[sum+1];
        Arrays.fill(dp,-1);

        System.out.println("minimum coins: "+minimumCoins(coinTypes,sum,dp));
    }

    private static int minimumCoins(int[] coinTypes, int sum, int[] dp) {
        if(sum==0)
            return 0;
        if(sum<0)
            return Integer.MAX_VALUE;

        int minimumCoins = Integer.MAX_VALUE;
        int result=0;
        for(int coin : coinTypes){
            if((sum-coin)>=0 && dp[sum-coin]!=-1){
                result = dp[sum-coin];
            }
            else{
                result = minimumCoins(coinTypes,sum-coin, dp);
            }

            if(result!=Integer.MAX_VALUE)
                minimumCoins=Integer.min(minimumCoins,result+1 );

        }
        dp[sum]=minimumCoins;
        return minimumCoins;
    }

}
