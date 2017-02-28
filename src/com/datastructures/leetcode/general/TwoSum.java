package com.datastructures.leetcode.general;

import java.util.HashMap;

/*
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 */

public class TwoSum {
	public static void main(String[] args) {
		int[] nums = {3,3};
		int[] result = twoSum(nums, 6);
		System.out.println(result[0]+" , "+result[1]);
	}

	public static int[] twoSum(int[] nums, int target) {
		int[] result = {0,0};
		HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
		for(int i =0;i<nums.length;i++){
			if(map.containsKey(target - nums[i])){
				result[0] =  map.get(target - nums[i]);
				result[1] = i;
			}else{
				map.put(nums[i], i);
			}
		}
		return result;
	}
}
