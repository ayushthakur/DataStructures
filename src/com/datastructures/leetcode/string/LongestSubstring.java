package com.datastructures.leetcode.string;

import java.util.HashSet;
import java.util.Set;

/*
 * Given a string, find the length of the longest substring without repeating characters.
 */
public class LongestSubstring {
	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstring("dvdf"));
	}

	public static int lengthOfLongestSubstring(String s) {
		if (s.length() == 0 || s == null) {
			return 0;
		}
		Set<Character> charSet = new HashSet<Character>();
		int longest = 0;
		int i=0,j=0;
		while(i<s.length() && j <s.length()){
			if(!charSet.contains(s.charAt(j))){
				charSet.add(s.charAt(j++));
				longest = Math.max(longest, j-i);
			}else{
				charSet.remove(s.charAt(i++));
			}
		}
		return longest;
	}
}
