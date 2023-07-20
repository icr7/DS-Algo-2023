package com.dsAlgo2023.Algoritm.DynamicProgramming;

public class CoinChangeProblem {
    public static void main(String[] args) {
        int [] coinTypes = new int[]{7,5,1};
        int sum=18;
        System.out.println("minimum coins: "+minimumCoins(coinTypes,sum));
    }

    private static int minimumCoins(int[] coinTypes, int sum) {
        if(sum==0)
            return 0;
        if(sum<0)
            return Integer.MAX_VALUE;

        int minimumCoins = Integer.MAX_VALUE;
        for(int coin : coinTypes){
            int result = minimumCoins(coinTypes,sum-coin);
            if(result!=Integer.MAX_VALUE)
                minimumCoins=Integer.min(minimumCoins,result+1 );

        }
        return minimumCoins;
    }

}
