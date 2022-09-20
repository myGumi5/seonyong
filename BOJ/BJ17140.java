package com.ssafy.coding.live20220920;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BJ17140 {
	static int r, c, val, R, C, ans;
	static int[][] map;

	public static void main(String[] args) {
		FastReader sc = new FastReader();

		R = 3;
		C = 3;
		ans = 0;
		r = sc.nextInt();
		c = sc.nextInt();
		val = sc.nextInt();

		map = new int[101][101];

		for (int i = 1; i <= R; i++) {
			for (int j = 1; j <= C; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		pro();

	}

	static void doRow() {
		int maxLen = 0;
		int[][] sub = new int[201][201];
		for (int i = 1; i <= R; i++) {
			int[] cnt = new int[201];
			int len = 0;
			for (int j = 1; j <= C; j++) {
				cnt[map[i][j]]++;
			}

			int num = 1;
			int count = 1;
			while (count <= 200) {
				for (int j = 1; j <= 200; j++) {
					if (cnt[j] == count) {
						len+=2;
						sub[i][num++] = j;
						sub[i][num++] = cnt[j];
					}
				}
				count++;
			}
			maxLen = Math.max(maxLen, len);
		}
		
		C = maxLen;
		if(C >= 100) {
			for(int i = 1; i <= R; i++) {
				for(int j = 101; j <= 200; j++) {
					map[i][j-100] = sub[i][j];
				}
			}
			C-= 100;
			return;
		}
		for(int i = 1; i <= R; i++) {
			for(int j = 1; j <= C; j++) {
				map[i][j] = sub[i][j];
			}
		}
	}
	static void doCol() {
		int maxLen = 0;
		int[][] sub = new int[201][201];
		for (int i = 1; i <= C; i++) {
			int[] cnt = new int[201];
			int len = 0;
			for (int j = 1; j <= R; j++) {
				cnt[map[j][i]]++;
			}

			int num = 1;
			int count = 1;
			while (count <= 100) {
				for (int j = 1; j <= 100; j++) {
					if (cnt[j] == count) {
						len+=2;
						sub[num++][i] = j;
						sub[num++][i] = cnt[j];
					}
				}
				count++;
			}
			maxLen = Math.max(maxLen, len);
		}
		
		R = maxLen;
		if(R >= 100) {
			for(int i = 101; i <= 200; i++) {
				for(int j = 1; j <= C; j++) {
					map[i-100][j] = sub[i][j];
				}
			}
			R -= 100;
			return;
		}
		for(int i = 1; i <= R; i++) {
			for(int j = 1; j <= C; j++) {
				map[i][j] = sub[i][j];
			}
		}
	}

	static void pro() {
		int time = 0;
		while(true) {
			if (map[r][c] == val) {
				System.out.println(time);
				return;
			}

			if (R >= C) {
				doRow();
			} else {
				doCol();
			}
			
//			for(int i = 1; i<= R; i++) {
//				System.out.println(Arrays.toString(Arrays.copyOfRange(map[i], 1, C+1)));
//			}
//			System.out.println();

			if (time == 100) {
				System.out.println(-1);
				return;
			} else {
				time++;
			}
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
