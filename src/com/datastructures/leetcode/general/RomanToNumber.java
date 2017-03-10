package com.datastructures.leetcode.general;

/*
 * Convert Roman Numeral to Integer 
 */


import java.util.HashMap;

public class RomanToNumber {
	private static final HashMap<String, Integer> map = new HashMap<String, Integer>();
	static {
		map.put("I", 1);
		map.put("IV", 4);
		map.put("V", 5);
		map.put("IX", 9);
		map.put("X", 10);
		map.put("XL", 40);
		map.put("L", 50);
		map.put("XC", 90);
		map.put("C", 100);
		map.put("CD", 400);
		map.put("D", 500);
		map.put("CM", 900);
		map.put("M", 1000);
	}

	public static void main(String[] args) {
		System.out.println(romanToInt("XIX"));
	}

	public static int romanToInt(String roman) {
		int l;
		if (map.containsKey(roman)) {
			return map.get(roman);
		} else if (map.containsKey(roman.substring(0, 2))) {
			l = map.get(roman.substring(0, 2));
			return l + romanToInt(roman.substring(2));
		} else if (map.containsKey(roman.substring(0, 1))) {
			l = map.get(roman.substring(0, 1));
			return l + romanToInt(roman.substring(1));
		} else {
			return -1;
		}

	}
}
