package com.datastructures.leetcode.general;

import java.util.Arrays;

/*
 * Find all primes to a given number
 */



public class PrimeNumbers {

	public static void seiveOfEratosthenes(int n){
		
		boolean[] flags = new boolean[n];
		
		Arrays.fill(flags, true);
		
		flags[0] = false;
		flags[1] = false;
		for(int i=2; i*i<n ; i++){
			if(flags[i]){
				
				//Mark all factors of i as primes
				for(int j = i; i*j<n; j++){
					flags[i*j] = false;
				}
			}		
		}
		
		for(int i=0;i<n ; i++){
			if(flags[i]){
				System.out.print(i + " ");
			}
		}
	}
	
	public static void main(String[] args) {
		seiveOfEratosthenes(130);
	}
}
