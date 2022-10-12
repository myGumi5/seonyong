package com.ssafy.algo.live20221012;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA4012 {
	static int T, N, ans;
	static int[][] map;
	static boolean[] visited;
	
	public static void main(String[] args) {
		FastReader sc = new FastReader();
		T = sc.nextInt();
		
		for(int t = 1; t <= T; t++) {
			N = sc.nextInt();
			ans = Integer.MAX_VALUE;
			
			visited = new boolean [N];
			map = new int[N][N];
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			
			dfs(0, 0, 0);
			System.out.println("#"+t+" "+ans);
		}
		
	}
	
	static void dfs(int depth, int t, int f) {
		if(t > N / 2 || f > N / 2) return;
		
		if(depth == N) {
			ArrayList<Integer> Afood = new ArrayList<>();
			ArrayList<Integer> Bfood = new ArrayList<>();
			
			for(int i = 0; i < N; i++) {
				if(visited[i]) Afood.add(i);
				else Bfood.add(i);
			}
			
			ans = Math.min(ans, getScore(Afood, Bfood));
			
			return;
		}
		
		visited[depth] = true;
		dfs(depth+1, t+1, f);
		visited[depth] = false;
		dfs(depth+1, t, f+1);
		
	}

	private static int getScore(ArrayList<Integer> afood, ArrayList<Integer> bfood) {
		int asum = 0;
		for(int anum : afood) {
			for(int asub : afood) {
				asum += map[anum][asub];
			}
		}
		
		int bsum = 0;
		for(int bnum : bfood) {
			for(int bsub : bfood) {
				bsum += map[bnum][bsub];
			}
		}
		
		return Math.abs(asum - bsum);
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
				} catch (Exception e) {
					
				}
			}
			return st.nextToken();
		}
		
		int nextInt() {
			return Integer.parseInt(next());
		}
	}
}
