package com.dsAlgo2023.recursion;

public class CoinCombinationForSum {
    public static void main(String[] args) {
        int[] coins = new int[]{1, 2, 3};
        int sum = 5;
        System.out.println(coinsCount(sum, coins));
    }

    private static int coinsCount(int sum, int[] coins) {
        return coinsCount(sum, coins, 0);
    }

    private static int coinsCount(int sum, int[] coins, int index) {
        if (sum == 0) return 1;
        if (sum < 0) return 0;
        int result = 0;
        for (int i = index; i < coins.length; i++)
            result += coinsCount(sum - coins[i], coins, i);

        return result;
    }
}
