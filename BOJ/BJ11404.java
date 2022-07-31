package com.ssafy.cding.BJ20220731;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BJ11404 {
	static int N, M;
	static int[][] cost;
	static final int INF = 987654321;
	
	public static void main(String[] args) {
		FastReader sc = new FastReader();
		N = sc.nextInt();
		M = sc.nextInt();
		
		cost = new int[N+1][N+1];
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= N; j++) {
				if(i == j) cost[i][j] = 0;
				else cost[i][j] = INF;
			}
		}
		
		for(int i = 0; i < M; i++) {
			int node1 = sc.nextInt();
			int node2 = sc.nextInt();
			int edge = sc.nextInt();
	
			cost[node1][node2] = Math.min(cost[node1][node2], edge);
		}
		
		for(int i = 1; i <= N; i++) {
			floyd_Warshall(i);
		}

		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= N; j++) {
				if(cost[i][j] == INF) System.out.print(0 + " ");
				else System.out.print(cost[i][j] + " ");	
			}
			System.out.println();
		}
	}
	static void floyd_Warshall(int node) {
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= N; j++) {
				if(cost[i][j] > cost[i][node] + cost[node][j]) {
					cost[i][j] = cost[i][node] + cost[node][j];
				}
			}
		}
	}
	
	static class FastReader{
		BufferedReader br = null;
		StringTokenizer st = null;
		
		public FastReader() {
			try {
				br = new BufferedReader(new InputStreamReader(System.in));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		String next() {
			while(st ==  null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				}catch (Exception e) {
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
