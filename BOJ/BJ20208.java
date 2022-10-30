package com.ssafy.coding.live20221030;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ20208 {
	static int N, M, H, ans, cnt;
	static int[][] map;
	static boolean [] visited;
	static ArrayList<int[]> list;
	static ArrayList<Integer> sub;
	static int[] coord; 
	
	static int[] dy = {0, 0, 1, -1};
	static int[] dx = {1, -1, 0, 0};
	static int startR, startC;
	public static void main(String[] args) {
		FastReader sc = new FastReader();
		N = sc.nextInt();
		M = sc.nextInt();
		H = sc.nextInt();
		
		sub = new ArrayList<>();
		coord = new int[2];
		map = new int[N][N];
		list = new ArrayList<>();

		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
				if(map[i][j] == 1) {
					startR = i;
					startC = j;
					coord[0] = i;
					coord[1] = j;
				}
				if(map[i][j] == 2) {
					list.add(new int[] {i, j});
				}
				
			}
		}
		visited = new boolean[list.size()];
		dfs(0, startR, startC, M);
		System.out.println(ans);
		
	}
	static void dfs(int depth, int R, int C, int hp) {
		if(depth >= list.size()) {
			if(check2(R, C, hp)) {
				ans = Math.max(ans, cnt);
//				System.out.println(sub);
//				System.out.println(hp);
			}
			return;
		}
		
		// 선택
		if(check(depth, hp, R, C) && !visited[depth]) {

			startR = list.get(depth)[0];
			startC = list.get(depth)[1];
			visited[depth] = true;
			cnt++;
			dfs(0, startR, startC, getHp(depth, hp, R, C) + H);
			cnt--;
			visited[depth] = false;
			startR = R;
			startC = C;

		}
		// 미선택
		dfs(depth + 1, R, C, hp);
		
	}
	
	private static boolean check2(int R, int C, int hp) {
		if(Math.abs(coord[0] - R) + Math.abs(coord[1] - C) <= hp) {
			return true;
		}
		
		return false;
	}
	private static int getHp(int depth, int hp, int R, int C) {
		int r = list.get(depth)[0];
		int c = list.get(depth)[1];
		
		hp -= Math.abs(R - r) + Math.abs(C - c);
		
		return hp;
	}
	private static boolean check(int depth, int hp, int R, int C) {
		int r = list.get(depth)[0];
		int c = list.get(depth)[1];
		
		if(Math.abs(R - r) + Math.abs(C - c) <= hp) {
			return true;
		}
		
		return false;
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
