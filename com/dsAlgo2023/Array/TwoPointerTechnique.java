package com.dsAlgo2023.Array;

public class TwoPointerTechnique {
    public static void main(String[] args) {
        TwoSumOfSortedArray arr = new TwoSumOfSortedArray();
        int[] twoSum= arr.twoSum(new int[]{1, 2, 3, 4, 5, 6, 9}, 9);
        for(int x:twoSum)
            System.out.print(x+", ");
    }
}


class TwoSumOfSortedArray {
    public int[] twoSum(int[] numbers, int target) {
        int leftPointer=0;
        int rightPointer=numbers.length-1;
        while(leftPointer<rightPointer){
            int sum = numbers[leftPointer] + numbers[rightPointer];
            if(sum<target) leftPointer++;
            else if(sum>target) rightPointer--;
            else if(sum==target) return new int[]{leftPointer+1,rightPointer+1};
        }
        return new int[0];

    }
}
