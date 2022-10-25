package com.ssafy.coding.live20221025;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class SWEA2115 {
	static int T, N, M, C, max1, max2, ans;
	static int [][] map, sub;
	static ArrayList<Integer> list = new ArrayList<>();
	
	public static void main(String[] args) {
		FastReader sc = new FastReader();
		T = sc.nextInt();
		
		for(int t = 1; t <= T; t++) {
			N = sc.nextInt();
			M = sc.nextInt();
			C = sc.nextInt();
			
			list = new ArrayList<>();
			map = new int[N][N];
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			
			ans = Integer.MIN_VALUE;
			
			dfs(0, 0);
			System.out.println("#"+t+" "+ans);
		}
		
	}
	static void dfs(int depth, int cnt) {
		if(depth > N * N) return;
		if(cnt >= 2) {
			max1 = 0;
			max2 = 0;
//			int res = getCal();
//			if(list.get(0)==5 && list.get(1)==6 && list.get(2)==13&& list.get(3)==14) {
//				System.out.println("start");
//			}
			getCal1(0, 0, 0);
			getCal2(M, 0, 0);
	
//			System.out.println(list);
//			System.out.println(max1 + max2);
			ans = Math.max(ans, max1+max2);
			return;
		}
		
		if(check(depth)) {
			for(int i = 0; i < M; i++) {
				list.add(depth + i);
			}
			dfs(depth + M, cnt + 1);
			for(int i = 0; i < M; i++) {
				list.remove(list.size() - 1);
			}
		}

		dfs(depth + 1, cnt);
		
	}
	private static void getCal1(int depth , int val, int num) {
		if(num > C) return;
		if(depth == list.size() / 2) {
			max1 = Math.max(max1, val);
			return;
		}
		
		int r = list.get(depth) / N;
		int c = list.get(depth) % N;
		getCal1(depth + 1, val + (map[r][c] * map[r][c]), num + map[r][c]);
		getCal1(depth + 1, val, num);
		
	}
	private static void getCal2(int depth , int val, int num) {
		if(num > C) return;
		if(depth == list.size()) {
			max2 = Math.max(max2, val);
			return;
		}
		
		int r = list.get(depth) / N;
		int c = list.get(depth) % N;
		getCal2(depth + 1, val + (map[r][c] * map[r][c]), num + map[r][c]);
		getCal2(depth + 1, val, num);
	}
	/*
1
4 2 13
6 1 9 7    
9 8 5 8
3 4 5 3
8 2 6 7
	 */
	private static boolean check(int depth) {
		int c = depth % N;
		
		if(c + M > N) {
			return false;
		}
		
		return true;
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
					// TODO: handle exception
				}
			}
			return st.nextToken();
		}
		
		int nextInt() {
			return Integer.parseInt(next());
		}
	}
	
}
