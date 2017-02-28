package com.datastructures.leetcode.general;

public class ReverseInteger {
	public static void main(String[] args) {
		
		System.out.println(reverse(-123));
	}

	public static int reverse(int x) {
		int res =0;
		int newRes = 0;
	
		if(x<9 && x>-9){
			return x;
		}
		while (x != 0) {
			int mod = x % 10;
			x = x / 10;
			newRes = res * 10 + mod;
			if ((newRes-mod)/10 != res) {
				return 0;
			}
			res = newRes;
		}

		return res;
	}
}
