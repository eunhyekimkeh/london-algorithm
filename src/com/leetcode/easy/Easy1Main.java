package com.leetcode.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Easy1Main {
    public static void main(String[] strs){
        System.out.println("eunhy check");


        int[] nums = new int[] {3,2,4};
        int target = 6;

        int[] result = twoSum(nums, target);

        Arrays.stream(result).forEach(System.out::println);

    }

    public static int[] twoSum(int[] nums, int target) {
//        Input: nums = [2,7,11,15], target = 9
//        Output: [0,1]
//        Output: Because nums[0] + nums[1] == 9, we return [0, 1].

        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<nums.length; i++){
            map.put(nums[i],i);
        }
        // 2,0
        // 7,1
        // 11,2
        // 15,3

        int remainder;
        for(int i=0; i<nums.length; i++){
            remainder = target - nums[i];
            if(map.containsKey(remainder) && map.get(remainder) != i){
                return new int[] {i, map.get(remainder)};
            }
        }

        return new int[2];

    }
}
