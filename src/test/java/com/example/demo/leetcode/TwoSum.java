package com.example.demo.leetcode;

public class TwoSum {

    public static void main(String[] args) {
        int[] arr = {3, 2, 4};
        int target = 6;

        int[] results = twoSum(arr, target);

        for (int i = 0; i < results.length; i++) {
            System.out.println(results[i]);
        }
    }


    public static int[] twoSum(int[] nums, int target) {
        int[] indices = new int[2];

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    indices[0] = i;
                    indices[1] = j;
                    return indices;
                }
            }
        }

        return indices;
    }
}
