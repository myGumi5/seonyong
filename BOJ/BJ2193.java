package com.ssafy.coding.BJ3020;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ2193 {
	static ArrayList<int[]> list = new ArrayList<>();
	static int N;
	static long[] visited;
	public static void main(String[] args) {
		FastReader sc = new FastReader();
		N = sc.nextInt();
//		combination(new int[N], 0);
		visited = new long[N+10];
		visited[1] = 1;
		visited[2] = 1;

		for(int i = 2; i <= N; i++) {
			visited[i] = visited[i - 1] + visited[i - 2];
		}
		
		System.out.println(visited[N]);
		
/*		Dfs(1, 0);
		System.out.println(cnt);
*/
	}
/*	
	static void Dfs(int value, int depth) {
		if(depth == N-1) {
			cnt++;
			return;
		}
	 
		for(int i = 0; i < 2; i++) {
			if(value == 1 && i == 1) {
				return;
			}
			
			if(visited[depth])
			Dfs(i, depth+1);
		}
		
	}
	*/
	
//	static void check(int [] arr) {
//		if (arr[0] == 0)
//			return;
//		boolean con = false;
//		for (int j = 0; j < N - 1; j++) {
//			if (arr[j] == 1 && arr[j + 1] == 1) {
//				con = true;
//				break;
//			}
//		}
//		if (con)
//			return;
//
//		cnt++;
//		con = false;
//
//	}
//	
//	static void combination(int[] arr, int depth) {
//		if(depth == N) {
//			check(arr);
//			return;
//		}
//		for(int i = 0; i < 2; i++) {
//			arr[depth] = i;
//			if(arr[0] != 0)
//				combination(arr, depth+1);
//		}
//		
//	}
	
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
