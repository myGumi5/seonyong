package com.ssafy.coding.BJ14225;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BJ14225 {
	static int N;
	static int[] arr;
	static HashMap<Integer, Integer> list = new HashMap<>();
	
	public static void main(String[] args) {
		FastReader sc = new FastReader();
		N = sc.nextInt();
		
		arr = new int[N+1];
		for(int i = 1; i <= N; i++) {
			arr[i] = sc.nextInt();
		}
		
		for(int i = 1; i <= N; i++)
			combination(new int[N+1], i, 1);
		
		for(int i = 1; i <= 2000000; i++) {
			if(list.get(i) == null) {
				System.out.println(i);
				break;
			}
		}
		
		
	}
	static void combination(int[] per, int M, int depth) {
		if(depth == M+1) {
			int sum = 0;
			for(int i = 1; i <= M; i++) {
				sum += arr[per[i]];
			}
			list.put(sum, 1);
			return;
		}
		
		for(int i = per[depth - 1] + 1; i <= N; i++) {
			per[depth] =i;
			combination(per, M, depth+1);
		}
	}
	
	static class FastReader{
		BufferedReader br;
		StringTokenizer st;
		
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
