package com.ssafy.coding.live20220811;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BJ2468 {
	static int N, max = 0, cnt = 1;
	static int [][] map, visited;
	
	public static void main(String[] args) {
		FastReader sc = new FastReader();
		N= sc.nextInt();
		
		map = new int[N][N];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
				max = Math.max(map[i][j], max);
			}
		}
		
		for(int i = 0; i < max; i++) {
			visited = new int[N][N];
			for(int j = 0; j < N; j++) {
				for(int z = 0; z < N; z++) {
					map[j][z]--;
				}
			}
			
//			for(int j = 0; j < N; j++) {
//				System.out.println(Arrays.toString(map[j]));
//			}
			
			int c = 0;
			for(int j = 0; j < N; j++) {
				for(int z = 0; z < N; z++) {
					if(visited[j][z] == 0 && map[j][z] > 0) {
						dfs(j, z);
						c++;
					}
				}
			}
			
			cnt = Math.max(cnt, c);
		}
		
		System.out.println(cnt);
	}
	static void dfs(int i, int j) {
		if(i < 0 || i >= N || j < 0 || j >= N) return;
		if(visited[i][j] == 1) return;
		if(map[i][j] <= 0) return;
		
		visited[i][j] = 1;
		
		dfs(i+1, j);
		dfs(i-1, j);
		dfs(i, j+1);
		dfs(i, j-1);
	}
	
	static class FastReader{
		BufferedReader br = null;
		StringTokenizer st = null;
		
		public FastReader() {
			try {
				br = new BufferedReader(new InputStreamReader(System.in));
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		String next() {
			while(st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (Exception e) {
					// TODO: handle exception
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
