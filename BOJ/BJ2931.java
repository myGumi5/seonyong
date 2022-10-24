package com.ssafy.algo.live20221024;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2931 {
	static int R, C, ansI, ansJ;
	static char[][] map, sub;
	static char ansC;
	static boolean flag;
	static int[] M, Z;
	
	static int [] dy = {-1, 1, 0, 0};
	static int [] dx = {0, 0, -1, 1};
	static char[] block = {'|', '-', '+','1', '2', '3', '4'};
	public static void main(String[] args) {
		FastReader sc = new FastReader();
		R = sc.nextInt();
		C = sc.nextInt();
		
		map = new char[R][C];
	
		M = new int[2];
		Z = new int[2];
		for(int i = 0; i < R; i++) {
			String str = sc.nextLine();
			for(int j = 0; j < C; j++) {
				map[i][j] = str.charAt(j);
				if(map[i][j] == 'M') {
					M[0] = i;
					M[1] = j;
				}
				if(map[i][j] == 'Z') {
					Z[0] = i;
					Z[1] = j;
				}
			}
		}
		for(int i = 0; i < 4; i++) {
			int r = M[0] + dy[i];
			int c = M[1] + dx[i];
			if(r < 0 || c < 0 || r >= R || c >= C) continue;
			if(map[r][c] != '.') {
				if(map[r][c] == 'Z') continue;
				dfs(r, c, i, 0);
				break;
			} else {
				for(int a = 0; a < 7; a++) {
					// 해당칸을 갈 수 있는지 확인
					if(check(i, block[a])) {
						// 그리기
						map[r][c] = block[a];
						getAns(r, c, block[a]);
						// dfs()			
						dfs(r, c, i, 1);
						// 되돌리기
						map[r][c] = '.';
					}
				}
			}
		}
		
	}
	
	static void dfs(int r, int c, int dir, int cnt) {
		if(flag) return;
		
		if(r == Z[0] && c == Z[1]) {
			System.out.println(ansI+" "+ansJ+" "+ansC);
			flag = true;
			return;
		}
		
		dir = getDir(r, c, dir);
		r += dy[dir];
		c += dx[dir];
		if(r < 0 || c < 0 || r >= R || c >= C) return;
		if(map[r][c] == '.') {
			if(cnt == 1) return;
			for(int i = 0; i < 7; i++) {
				// 해당칸을 갈 수 있는지 확인
				if(check(dir, block[i])) {
					// 그리기
					map[r][c] = block[i];
					getAns(r, c, block[i]);
					// dfs()			
					dfs(r, c, dir, cnt+1);
					// 되돌리기
					map[r][c] = '.';
				}
			}
		}else {
			if(check(dir, map[r][c]))
				dfs(r, c, dir, cnt);
		}
	}
	
	private static void getAns(int r2, int c2, char d) {
		ansI = r2+1;
		ansJ = c2+1;
		ansC = d;
	}

	private static boolean check(int dir, char i) {
		if(i == 'Z') return true;
		
		if(dir == 0) {
			if(i == '|' || i == '1' || i ==  '4' || i == '+') {
				return true;
			}
		} else if(dir == 1) {
			if(i == '|' || i == '2' || i ==  '3' || i == '+') {
				return true;
			}
		} else if(dir == 2) {
			if(i == '-' || i == '1' || i ==  '2' || i == '+') {
				return true;
			}
		} else {
			if(i == '-' || i == '3' || i ==  '4' || i == '+') {
				return true;
			}
		}
		
		return false;
	}

	private static int getDir(int r2, int c2, int dir) {
		if(map[r2][c2] == '1') {
			if(dir == 0) {
				return 3;
			} else {
				return 1;
			}
		} else if(map[r2][c2] == '2') {
			if(dir == 1) {
				return 3;
			} else {
				return 0;
			}
		} else if(map[r2][c2] == '3') {
			if(dir == 3) {
				return 0;
			} else {
				return 2;
			}
		} else if(map[r2][c2] == '4') {
			if(dir == 3) {
				return 1;
			} else {
				return 2;
			}
		} else {
			return dir;
		}
		
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
