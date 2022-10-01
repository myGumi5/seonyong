package com.ssafy.coding.live20221001;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class SWEA2105 {
	static int T, N, ans;
	static int[][] map, sub, visited;

	static int[] dy = { 1, 1, -1, -1 };
	static int[] dx = { 1, -1, -1, 1 };

	public static void main(String[] args) {
		FastReader sc = new FastReader();
		T = sc.nextInt();
		for (int t = 0; t < T; t++) {
			N = sc.nextInt();

			sub = new int[N][N];
			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = sc.nextInt();
					sub[i][j] = map[i][j];
				}
			}

			ans = -1;
			visited = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					dfs(i, j, 0, new ArrayList<Integer>());
					visited[i][j] = 1;
				}
			}

			System.out.printf("#%d %d\n", t + 1, ans);
		}

	}

	static int[] canGo(int dir, ArrayList<Integer> list) {
		if(list.size() == 0) return new int[] { 0, 0 };
		
		if (dir == 0) {
			return new int[] { 0, 1 };
		} else if (dir == 1) {
			return new int[] { 1, 2 };
		} else if (dir == 2) {
			return new int[] { 2, 3 };
		} else {
			return new int[] { 3, 3 };
		}
	}

	static boolean isGo(ArrayList<Integer> list) {
		if (list.size() == 1)
			return false;
		
		for(int i = list.size()-2; i >= 0; i--) {
			if(list.get(list.size()-1) == list.get(i)) return true;
		}
		
		return false;
	}

	static void dfs(int r, int c, int dir, ArrayList<Integer> list) {
		if(r < 0 || c < 0 || r  >= N || c  >= N) return;
		if(isGo(list)) return;
		if (map[r][c] == -1) {
			ans = Math.max(ans, list.size());
//			System.out.println(list);
//			for(int i = 0; i < N; i++) {
//				System.out.println(Arrays.toString(map[i]));
//			}
			return;
		}
		if(visited[r][c] == 1) return;
		if(map[r][c] == 0) return;
		
		// 선택할 때,
		for (int d : canGo(dir, list)) {
			if(list.size() == 0) map[r][c] = -1;
			else map[r][c] = 0;
			
			ArrayList<Integer> subList = new ArrayList<>(list);
			subList.add(sub[r][c]);
			dfs(r + dy[d], c + dx[d], d, subList);
			map[r][c] = sub[r][c];
		}
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
