package com.datastructures.leetcode.general;

public class BigFactorial {
	public static void factorial(int n) {

		int[] value = new int[100000];
		int resultSize = 1;
		value[0] = 1;

		for (int i = 2; i <= n; i++) {
			resultSize = multiply(value, i, resultSize);
		}

		for (int i = resultSize-1; i >= 0; i--) {
			System.out.print(value[i]);
		}
	}

	public static int multiply(int[] value, int i, int resultSize) {
		int carry = 0;

		for (int x = 0; x < resultSize; x++) {
			int prod = value[x] * i + carry;
			value[x] = prod % 10;
			carry = prod / 10;
		}

		while (carry > 0) {
			value[resultSize] = carry % 10;
			carry = carry / 10;
			resultSize++;
		}

		return resultSize;
	}

	public static void main(String[] args) {
		factorial(1000);
	}
}
