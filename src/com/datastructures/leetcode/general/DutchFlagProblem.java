package com.datastructures.leetcode.general;

public class DutchFlagProblem {

	public int[] sort(int a[]) {
		int lo = 0;
		int mid = 0;
		int high = a.length - 1;
		int temp = 0;
		while (mid <= high) {
			switch (a[mid]) {
			case 0:
				temp = a[lo];
				a[lo] = a[mid];
				a[mid] = temp;
				lo++;
				mid++;
				break;
			case 1:
				mid++;
				break;
			case 2:
				temp = a[high];
				a[high] = a[mid];
				a[mid] = temp;
				high--;
				break;
			}

		}
		return a;
	}
	
	public static void main(String[] args) {
		DutchFlagProblem dfp = new DutchFlagProblem();
		int[] a = new int[]{0,0,1,1,0,0,2,1,0,1,2,2,2,1};
		dfp.sort(a);
		for(int i=0;i<a.length;i++){
			System.out.println(a[i]);
		}
	}
}
