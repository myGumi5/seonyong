package com.ssafy.coding.live20220926;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class SWEA1767_dfs {
	static int[][] map;
	static int N, T, ans, max;
	static ArrayList<int[]> list = null;
	
	public static void main(String[] args) {
		FastReader sc = new FastReader();
		T = sc.nextInt();
		
		for(int t = 0; t < T; t++) {
			N = sc.nextInt();
			ans = Integer.MAX_VALUE;
			max = Integer.MIN_VALUE;
			list = new ArrayList<>();
			map = new int[N][N];
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					map[i][j] = sc.nextInt();
					if(map[i][j] == 1 && (i != 0 && j != 0)) {
						list.add(new int[]{i, j});
					}
				}
			}
			
			dfs(0, 0, 0);
			System.out.printf("#%d %d\n", t+1, ans);
			
		}

	}
	static void dfs(int depth, int val, int core){
		if((list.size() - depth) + core < max) return; 
		
		if(depth >= list.size()) {
			if(max < core) {
				max = core;
				ans = val;
			} else if(max == core) {
				ans = Math.min(ans, val);
			}
			return;
		}
		
		// 선택함
		for(int i = 1; i <= 4; i++) {
			if(isCan(list.get(depth), i)) {
				int cnt = draw(list.get(depth), i, 2);
				dfs(depth+1, val + cnt, core + 1);
				draw(list.get(depth), i, 0);
			}
		}
		
		// 선택안함
		dfs(depth+1, val, core);
	}
	
	private static int draw(int[] coord, int dir, int s) {
		int i = coord[0];
		int j = coord[1];
		
		int cnt = 0;
		// 1 : 좌, 2 하, 3 : 우, 4 : 상
		while(true) {
			if(dir == 1) {
				j--;
			} else if(dir == 2) {
				i++;
			} else if(dir == 3) {
				j++;
			} else {
				i--;
			}
			
			if(i < 0 || i >= N || j < 0 || j >= N) {
				break;
			}	
			
			map[i][j] = s;
			cnt++;
		}

		return cnt;
		
	}
	private static boolean isCan(int [] coord, int dir) {
		int i = coord[0];
		int j = coord[1];
		
		// 1 : 좌, 2 하, 3 : 우, 4 : 상
		while(true) {
			if(dir == 1) {
				j--;
			} else if(dir == 2) {
				i++;
			} else if(dir == 3) {
				j++;
			} else {
				i--;
			}
			
			if(i < 0 || i >= N || j < 0 || j >= N) {
				break;
			}
			
			if(map[i][j] == 1 || map[i][j] == 2) {
				return false;
			}
			
		}
		return true;
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
