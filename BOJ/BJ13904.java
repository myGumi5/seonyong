package com.ssafy.coding.live20221017;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ13904 {
	static int N;
	static int[][] arr;
	static boolean[] visited;
	public static void main(String[] args) {
		FastReader sc = new FastReader();
		N = sc.nextInt();
		arr = new int[N+1][1001];
		visited = new boolean[1001];
		for(int i = 1; i <= N; i++) {
			int num = sc.nextInt();
			int sub = sc.nextInt();
			for(int j = 1; j <= num; j++) {
				arr[i][j] = sub;
			}
		}

//		for(int i = 1; i <= N; i++) {
//			System.out.println(Arrays.toString(arr[i]));
//		}
//		
		int sum = 0;
		for(int i = N; i >= 1; i--) {
			int max = 0;
			int idx = 0;
			for(int j = N; j >= 1; j--) {
				if(visited[j]) continue;
				else {
					if(max < arr[j][i]) {
						max = arr[j][i];
						idx = j;
					}
				}
			}
			visited[idx] = true;
			if(max != 0) {
				sum += max;
			}
		}
		
		System.out.println(sum);
		
	}
	static class FastReader{
		BufferedReader br = null;
		StringTokenizer st = null;
		
		public FastReader() {
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
