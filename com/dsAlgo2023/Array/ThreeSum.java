package com.dsAlgo2023.Array;

import java.util.*;

public class ThreeSum {
    public static void main(String[] args) {
        ThreeSum obj = new ThreeSum();
        System.out.println(obj.threeSum(new int[]{-1,0,1,2,-1,-4}));
    }

    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> threeSum = new HashSet<>();
        Arrays.sort(nums);
        for(int i=0; i<nums.length&&nums[i]<=0;i++) {
            twoSum(i, nums, threeSum);
        }
        return new ArrayList<>(threeSum);
    }

    private void twoSum(int i, int[] nums, Set<List<Integer>> threeSum){
        int requiredSum= nums[i]*-1;
        int start=i;
        int end=nums.length-1;
        while(start!=end){
            int curr_sum=nums[start]+nums[end];
            if( curr_sum==requiredSum){
                if(i!=start && i!=end) {
                    List<Integer> pair = new ArrayList<>(Arrays.asList(nums[i], nums[start], nums[end]));
                    threeSum.add(pair);
                }
                start++;
            }
            else if(curr_sum>requiredSum) end--;
            else if(curr_sum<requiredSum) start++;
        }
    }
}
