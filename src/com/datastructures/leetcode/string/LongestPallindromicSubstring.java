package com.datastructures.leetcode.string;

/*
 * Given a string s, find the longest palindromic substring in s. 
 * You may assume that the maximum length of s is 1000.
 */

public class LongestPallindromicSubstring {
	public static void main(String[] args) {
		System.out.println(longestPalindrome("babad"));
	}

	public static String longestPalindrome(String s) {

		if (s.isEmpty()) {
			return null;
		}

		if (s.length() == 1) {
			return s;
		}

		String subs = s.substring(0, 1);

		for (int i = 0; i < s.length(); i++) {
			String tmp = helper(i, i, s);
			if (subs.length() < tmp.length()) {
				subs = tmp;
			}

			String midtmp = helper(i, i + 1, s);
			if (subs.length() < midtmp.length()) {
				subs = midtmp;
			}
		}

		return subs;
	}

	public static String helper(int begin, int end, String subs) {
		while (begin >= 0 && end <= subs.length()-1 && subs.charAt(begin) == subs.charAt(end)) {
			begin--;
			end++;
		}

		return subs.substring(begin+1, end);
	}
}
