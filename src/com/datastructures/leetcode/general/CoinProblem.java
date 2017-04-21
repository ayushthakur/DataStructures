package com.datastructures.leetcode.general;

import java.util.Arrays;

/*
 * Given a value and coins of different value in infinite supply, 
 * how many ways can we make the change for the given value?
 */

public class CoinProblem {
	public static void main(String[] args) {
		int[] coins = { 1, 2, 3 };
		int value = 4;
		int ways = coinChangeRecursive(coins, coins.length, value);
		int dynamicWays = coinChangeDynamic(coins, coins.length, value);
		System.out.println(ways);
		System.out.println(dynamicWays);
	}

	public static int coinChangeRecursive(int[] coins, int numberOfCoins, int value) {

		if (value == 0) {
			return 1;
		}

		if (value < 0) {
			return 0;
		}

		if (value > 0 && numberOfCoins <= 0) {
			return 0;
		}

		return coinChangeRecursive(coins, numberOfCoins - 1, value)
				+ coinChangeRecursive(coins, numberOfCoins, value - coins[numberOfCoins - 1]);
	}

	public static int coinChangeDynamic(int[] coins, int numberOfCoins, int value) {
		int[] table = new int[value + 1];

		Arrays.fill(table, 0);

		table[0] = 1;

		for (int i = 0; i < numberOfCoins; i++)
			for (int j = coins[i]; j <= value; j++)
				table[j] += table[j - coins[i]];

		return table[value];
	}
}
