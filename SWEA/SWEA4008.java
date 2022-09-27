package com.ssafy.algo.live20220927;

import java.beans.Expression;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA4008 {
	static int T, N, max, min;
	static int[] nums, simbol;
	public static void main(String[] args) {
		FastReader sc = new FastReader();
		T = sc.nextInt();
		
		for(int t= 0; t < T; t++) {
			N = sc.nextInt();
			
			nums = new int[N];
			simbol = new int [4];
			
			max = Integer.MIN_VALUE;
			min = Integer.MAX_VALUE;
			
			for(int i = 0; i < 4; i++) {
				simbol[i] = sc.nextInt();
			}
			for(int i = 0; i < N; i++) {
				nums[i] = sc.nextInt();
			}
			
			dfs(1, nums[0], simbol);
			System.out.printf("#%d %d\n", t+1, max - min);
		}
		
/*
 * 
1
5
2 1 0 1
3 5 3 7 9

1
6
4 1 0 0
1 2 3 4 5 6 
 */
	}
	static int [] initArr(int [] sym, int num) {
		int [] arr = new int[sym.length];
		
		for(int i = 0; i < sym.length; i++) {
			arr[i] = sym[i];
		}
		
		arr[num]--;
		
		return arr;
	}
	
	static void dfs(int depth, int val, int [] sym) {
		if(depth >= N) {
			max = Math.max(max, val);
			min = Math.min(min, val);
			return;
		}
		
		
		if(sym[0] != 0) {
			dfs(depth + 1, val + nums[depth], initArr(sym, 0) );
		}
		if(sym[1] != 0) {
			dfs(depth + 1, val - nums[depth], initArr(sym, 1) );
		}
		if(sym[2] != 0) {
			dfs(depth + 1, val * nums[depth], initArr(sym, 2) );
		}
		if(sym[3] != 0) {
			if(nums[depth] != 0) {
				dfs(depth + 1, val / nums[depth], initArr(sym, 3) );
			}
		}
	}
	
	static class FastReader{
		BufferedReader br = null;
		StringTokenizer st = null;
		
		public FastReader(){
			br = new BufferedReader(new InputStreamReader(System.in));
		}
		
		String next() {
			while(st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch(Exception e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}
		
		int nextInt() {
			return Integer.parseInt(next());
		}
	}
}
