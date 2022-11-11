package com.ssafy.algo.live20221111;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA1949 {
	static int T, N, K, max, top;
	static int[][] map;
	
	static boolean[][] visited;
	
	static int[] dy = {0, 0, 1, -1};
	static int[] dx = {1, -1, 0, 0};
	
	public static void main(String[] args) {
		FastReader sc = new FastReader();
		T = sc.nextInt();
		for(int t = 1; t <= T; t++) {
			N = sc.nextInt();
			K = sc.nextInt();
			
			map = new int[N][N];
			max = Integer.MIN_VALUE;
			top = Integer.MIN_VALUE;
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					map[i][j] = sc.nextInt();
					top = Math.max(top, map[i][j]);
					// ž ���츮������ ������ �� �����Ƿ� ž ���츮�� ������ ���Ѵ�.
				}
			}
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(map[i][j] == top) { // �ְ� ���� ���츮 �� ���� Ž���� �Ѵ�.
						visited = new boolean[N][N];
						visited[i][j] = true;
						// ù ��� �湮 ó��
						
						dfs(i, j, 0, 1);
					}
				}
			}
			
			System.out.println("#"+t+" "+max);
		}
		
	}
	static void dfs(int r, int c, int cnt, int len) {
		max = Math.max(max, len);
		// ���츮���� �ִ밪�� �������ش�.
		
		// 4���� Ž�� ����
		for(int d = 0; d < 4; d++) {
			int nr = r + dy[d];
			int nc = c + dx[d];
			
			if(nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
			if(visited[nr][nc]) continue;
			//������ ����ų� �̹� �湮�� ����� ��湮���� �ʴ´�.
			
			if(map[nr][nc] >= map[r][c]) { // ���� ���̺��� ���� ���̰� ũ�ų� ������, ���� �غ� �ؾ��Ѵ�.
				if(cnt == 1) continue; // ������, �̹� ��Ҵٸ�, ���� ���� �� �� ����.
				for(int i = 1; i <= K; i++) {
					if(check(map[nr][nc] - i, map[r][c])) continue;
					// ���� 1���� K���� ����� ��, �� ���̰� ���� �� ���� ���� �۴ٸ� ���� ���� �� �� �ִ�.
					
					map[nr][nc] -= i;
					visited[r][c] = true;
					// ���� ��� �湮ó���� �Ѵ�.
					dfs(nr, nc, cnt+1, len+1);
					map[nr][nc] += i;
					visited[r][c] = false;
					// ���� ���� ���󺹱��ϰ� �湮ó���� ���󺹱��Ѵ�.
				}
			}else { // ���� ���̺��� ���� ��尡 �۴ٸ� �ƹ� ���Ǿ��� �� �� �ִ�.
				visited[r][c] = true;
				dfs(nr, nc, cnt, len+1);
				visited[r][c] = false;
				// �湮ó���� �ϰ� �ش�  ������ �����ϸ� �湮ó���� ���󺹱��Ѵ�.
			}
		}
	}
	
	private static boolean check(int i, int j) {
		if(i < j) return false;
		
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

		String nextLine() {
			String str = null;
			try {
				str = br.readLine();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return str;
		}

		int nextInt() {
			return Integer.parseInt(next());
		}
	}
}
