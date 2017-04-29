package com.datastructures.leetcode.general;

import java.util.ArrayList;

public class PascalTriangle {
	private static ArrayList<ArrayList<Integer>> triangle = new ArrayList<ArrayList<Integer>>();

	public static void generate(int rows) {
		if (rows <= 0) {
			System.out.println("Rows need to be greater than zero");
			return;
		}

		ArrayList<Integer> prev = new ArrayList<Integer>();

		prev.add(1);
		triangle.add(prev);

		for (int i = 2; i <= rows; i++) {
			ArrayList<Integer> curr = new ArrayList<Integer>();
			curr.add(1);
			for (int j = 0; j < prev.size() - 1; j++) {
				curr.add(prev.get(j) + prev.get(j + 1));
			}
			curr.add(1);
			triangle.add(curr);
			prev = curr;
		}
	}

	public static void printSimpleTriangle(int rows) {

		for (int i = 0; i < rows; i++) {
			int num = 1;
			int r = i + 1;

			for (int k = rows; k > i; k--) {
				System.out.print(" ");
			}

			for (int j = 0; j <= i; j++) {
				if(j>0){
					num = num * (r-j)/j;
				}
				System.out.print(" "+num);
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		int rows = 10;
//		generate(rows);

//		for (int i = 0; i < triangle.size(); i++) {
//			ArrayList<Integer> temp = triangle.get(i);
//			for (int k = rows; k > i; k--) {
//				System.out.print(" ");
//			}
//			for (int j = 0; j < temp.size(); j++) {
//				System.out.print(" " + temp.get(j));
//			}
//			System.out.println();
//		}
		
		printSimpleTriangle(rows);
	}
}
