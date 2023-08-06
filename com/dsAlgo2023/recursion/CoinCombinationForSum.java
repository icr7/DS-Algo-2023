package com.dsAlgo2023.recursion;

import java.util.HashMap;
import java.util.Map;

public class CoinCombinationForSum {
    public static void main(String[] args) {
        int[] coins = new int[]{1, 2, 3};
        int sum = 7;
        System.out.println(coinsCount(sum, coins));
    }

    private static int coinsCount(int sum, int[] coins) {
        Map<String,Integer> coinMap= new HashMap<>();
        return coinsCount(sum, coins, 0, coinMap);
    }

    private static int coinsCount(int sum, int[] coins, int index, Map<String,Integer>coinMap) {
        if (sum == 0) return 1;
        if (sum < 0) return 0;
        int result = 0;
        String key=(index+1)+"/"+sum;
        if(coinMap.containsKey(key)){
            return coinMap.get(key);
        }
        for (int i = index; i < coins.length; i++)
            result += coinsCount(sum - coins[i], coins, i,coinMap);

        coinMap.put(key,result);

        return result;
    }
}
