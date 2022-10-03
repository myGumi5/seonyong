package com.ssafy.coding.live20221003;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ14391 {
	static int N, M, ans;
	static ArrayList<Integer> map = new ArrayList<>(); 
	static boolean[] visited;
	public static void main(String[] args) {
		FastReader sc = new FastReader();
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		ans = Integer.MIN_VALUE;
		visited = new boolean[N*M];
		for(int i = 0; i < N; i++) {
			String str = sc.nextLine();
			for(int j = 0; j < M; j++) {
				map.add(str.charAt(j) - 48);
			}
		}
		
		dfs(0);
		System.out.println(ans);
		
	}
	
	static void dfs(int depth) {
		if(depth == N * M) {
			ans = Math.max(ans, cal());
			return;
		}
		
		visited[depth] = true;
		dfs(depth + 1);
		visited[depth] = false;
		dfs(depth + 1);
	}
	
	private static int cal() {
		int sum = 0;
		for(int i = 0; i < N; i++) {
			int temp = 0;
			int mul = 1;
			for(int j = M-1; j >= 0; j--) {
				if(visited[i * M + j]) {
					temp += mul * map.get(i * M + j);
					mul *= 10;
				} else {
					sum += temp;
					temp = 0;
					mul = 1;
				}
			}
			sum += temp;
		}
		
		for(int i = 1; i <= M; i++) {
			int temp = 0;
			int mul = 1;
			for(int j = 0; j < N; j++) {
				if(!visited[(N * M - i) - (j * M)]) {
					temp += mul * map.get((N * M - i) - (j * M));
					mul *= 10;
				} else {
					sum += temp;
					temp = 0;
					mul = 1;
				}
			}
			sum += temp;
		}
		
		
		return sum;
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

		int nextInt() {
			return Integer.parseInt(next());
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
	}
}
