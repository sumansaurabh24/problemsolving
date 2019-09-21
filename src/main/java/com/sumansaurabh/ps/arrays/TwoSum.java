package com.sumansaurabh.ps.arrays;

import com.sumansaurabh.ps.Utils;

import java.util.*;

public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new LinkedHashMap<>();
        int[] indices = new int[2];

        for(int i = 0; i < nums.length; i++){
            int diff = target - nums[i];

            if(map.containsKey(diff)){
                indices[0] = map.get(diff);
                indices[1] = i;
            }
            map.put(nums[i], i);
        }

        return indices;
    }

    public static void main(String[] args) {
        int[] arr = {2, 7, 11, 15};
        int target = 9;
        int result[] = twoSum(arr, target);
        Utils.printArray(result);
    }
}
