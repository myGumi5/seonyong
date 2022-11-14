package com.ssafy.algo.live20221114;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA1486 {
	static int T, N, B, min;
	
	static boolean[] visited;
	static int[] arr;
	
	public static void main(String[] args) {
		FastReader sc = new FastReader();
		T = sc.nextInt();
		for(int t = 1; t <= T; t++) {
			N = sc.nextInt();
			B = sc.nextInt();
				
			min = Integer.MAX_VALUE;
			arr = new int[N];
			visited = new boolean[N];
			
			for(int i = 0; i < N; i++) {
				arr[i] = sc.nextInt();
			}
			
			dfs(0, 0);
			System.out.println("#"+t+" "+ (min - B));
			
		}
		
	}
	
	static void dfs(int depth, int cnt) {
//		System.out.println(cnt);
//		System.out.println();
		
		if(min < cnt) return;
		if(cnt >= B) {
			min = cnt;
		}
		if(depth == N) return;
		
		// 선택

		dfs(depth+1, cnt + arr[depth]);
		
		
		// 미선택
		dfs(depth+1, cnt);
		
	}
	
	static class FastReader {
		BufferedReader br = null;
		StringTokenizer st = null;

		public FastReader() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() {
			while (st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			return st.nextToken();
		}

		String nextLine() {
			String str = null;
			try {
				str = br.readLine();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return str;
		}

		int nextInt() {
			return Integer.parseInt(next());
		}
	}
}
