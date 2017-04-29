package com.datastructures.leetcode.general;

/*
 * given a set of continuous inputs from command line of integers, 
 * find the max positive, max negative, min positive and min negative
 */
public class MinMax {
	public String findMinMax(String nums) {
		String[] temp = nums.split(" ");

		int[] numArr = new int[temp.length];
		for (int i = 0; i < temp.length; i++) {
			numArr[i] = Integer.parseInt(temp[i]);
		}

		int maxPos = 0;
		int minPos = Integer.MAX_VALUE;
		int maxNeg = Integer.MIN_VALUE;
		int minNeg = 0;

		for (int i = 0; i < numArr.length; i++) {
			if (numArr[i] > 0 && numArr[i] < minPos) {
				minPos = numArr[i];
			}
			if (numArr[i] > maxPos && numArr[i] > 0) {
				maxPos = numArr[i];
			}
			if (numArr[i] < 0 && numArr[i] > maxNeg) {
				maxNeg = numArr[i];
			}
			if (numArr[i] < 0 && numArr[i] < minNeg) {
				minNeg = numArr[i];
			}
		}

		String values = minPos + " " + maxPos + " " + minNeg + " " + maxNeg;
		return values;
	}

	public static void main(String[] args) {
		MinMax minMax = new MinMax();

		System.out.println(minMax.findMinMax("7 8 6 10 4 3 2 -1 -15 -3 -4 -7"));
	}
}
