package com.datastructures.leetcode.arrays;

import java.util.Arrays;

public class ArraysMedian {
	public static void main(String[] args) {
		int arr1[] = { 1, 3};
		int arr[] = { 2 };

		System.out.println(findMedianSortedArrays(arr1, arr));
	}

	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
		double median = 0.0;
		int len1 = nums1.length;
		int len2 = nums2.length;

		int mergedArray[] = Arrays.copyOf(nums1, len1 + len2);

		for (int i = len1; i < mergedArray.length; i++) {
			mergedArray[i] = nums2[Math.abs(i - len1)];
		}
		
		Arrays.sort(mergedArray);

		if (mergedArray.length % 2 == 0) {
			int medianIndex1 = mergedArray.length / 2-1;
			int medianIndex2 = mergedArray.length / 2;
			
			median = mergedArray[medianIndex1]+mergedArray[medianIndex2];
			median = median/2;
			
		} else {
			double medianIndex = Math.floor(mergedArray.length/2);
			median = (double) mergedArray[(int) medianIndex];
		}
		return median;
	}
}
