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
					// 탑 봉우리에서만 시작할 수 있으므로 탑 봉우리가 얼마인지 구한다.
				}
			}
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(map[i][j] == top) { // 최고 높이 봉우리 일 때만 탐색을 한다.
						visited = new boolean[N][N];
						visited[i][j] = true;
						// 첫 노드 방문 처리
						
						dfs(i, j, 0, 1);
					}
				}
			}
			
			System.out.println("#"+t+" "+max);
		}
		
	}
	static void dfs(int r, int c, int cnt, int len) {
		max = Math.max(max, len);
		// 봉우리마다 최대값을 갱신해준다.
		
		// 4방향 탐색 시작
		for(int d = 0; d < 4; d++) {
			int nr = r + dy[d];
			int nc = c + dx[d];
			
			if(nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
			if(visited[nr][nc]) continue;
			//범위를 벗어낫거나 이미 방문한 노드라면 재방문하지 않는다.
			
			if(map[nr][nc] >= map[r][c]) { // 현재 높이보다 다음 높이가 크거나 같으면, 깎을 준비를 해야한다.
				if(cnt == 1) continue; // 하지만, 이미 깎았다면, 다음 노드로 갈 수 없다.
				for(int i = 1; i <= K; i++) {
					if(check(map[nr][nc] - i, map[r][c])) continue;
					// 산을 1부터 K까지 깎았을 때, 그 높이가 지금 내 높이 보다 작다면 다음 노드로 갈 수 있다.
					
					map[nr][nc] -= i;
					visited[r][c] = true;
					// 산을 깎고 방문처리를 한다.
					dfs(nr, nc, cnt+1, len+1);
					map[nr][nc] += i;
					visited[r][c] = false;
					// 깎은 산을 원상복구하고 방문처리도 원상복구한다.
				}
			}else { // 현재 높이보다 다음 노드가 작다면 아무 조건없이 갈 수 있다.
				visited[r][c] = true;
				dfs(nr, nc, cnt, len+1);
				visited[r][c] = false;
				// 방문처리를 하고 해당  로직이 종료하면 방문처리를 원상복구한다.
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
