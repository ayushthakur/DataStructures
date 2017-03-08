package com.datastructures.leetcode.general;

public class PallindromeNumber {
	public static void main(String[] args) {
		System.out.println(isPalindrome(1331));
	}

	public static boolean isPalindrome(int x) {
		int res = 0;
		int newRes = 0;
		int orignalNum = x;
		while (x > 0) {
			int mod = x % 10;
			x = x / 10;
			newRes = res * 10 + mod;
			if ((newRes - mod) / 10 != res) {
				return false;
			}
			res = newRes;
		}
		if (orignalNum == res) {
			return true;
		} else {
			return false;
		}
	}
}
