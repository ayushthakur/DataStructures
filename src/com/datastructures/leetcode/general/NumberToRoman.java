package com.datastructures.leetcode.general;

/*
 * Convert a given number to Roman Numerals
 */

import java.util.HashMap;
import java.util.TreeMap;


public class NumberToRoman {
	private static final TreeMap<Integer, String> data = new TreeMap<Integer, String>();
	private static HashMap<Integer, String> memo = new HashMap<Integer, String>();
	static{
		data.put(1, "I");
		data.put(4, "IV");
		data.put(5, "V");
		data.put(9, "IX");
		data.put(10, "X");
		data.put(40, "XL");
		data.put(50, "L");
		data.put(90, "XC");
		data.put(100, "C");
		data.put(400, "CD");
		data.put(500, "D");
		data.put(900, "CM");
		data.put(1000, "M");
	}
	
	public static void main(String[] args) {

		System.out.println(intToRoman(64));
	}

	public static String intToRoman(int num) {
        int l = data.floorKey(num);

		if (num == l) {
			return data.get(l);
		} else if (memo.containsKey(l)) {
			return memo.get(l);
		} else {
			String answer = data.get(l) + intToRoman(num - l); 
			memo.put(num, answer);
			return answer;
		}
	}
}
