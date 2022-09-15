package com.ssafy.coding.live20220914;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BJ17472 {
	static int N, M, count; 
	static int[][] map, visited, minArr;
	static int[] dy = {0, 0, 1, -1};
	static int[] dx = {1, -1, 0, 0};
	
	public static void main(String[] args) {
		FastReader sc = new FastReader();
		N = sc.nextInt();
		M = sc.nextInt();
		
		map = new int[N][M];
		visited = new int[N][M];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		int cnt = 1;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(visited[i][j] == 0 && map[i][j] == 1) {
					dfs(i, j, cnt++);
				}
			}
		}
		
		count = cnt - 1;
		minArr = new int[cnt][cnt];
		for(int i = 0; i < cnt; i++) {
			for(int j = 0; j < cnt; j++) {
				minArr[i][j] = 10000;
			}
		}

//		for(int i = 0; i < cnt; i++) {
//			System.out.println(Arrays.toString(visited[i]));
//		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(map[i][j] == 0 )continue;
				for(int c = 0; c < 4; c++) {
					makeBridge(i + dy[c], j + dx[c], visited[i][j], c, 1);
				}
			}
		}
		
//		for(int i = 1; i < cnt; i++) {
//			System.out.println(Arrays.toString(minArr[i]));
//		}
		
		boolean[] v = new boolean[cnt];
		int[] dist = new int[cnt];
		for(int i = 1; i < cnt; i++) {
			dist[i] = Integer.MAX_VALUE;
		}
		
		int idx = cnt-1;
		for(int i = 1; i < cnt; i++) {
			dist[i] = minArr[idx][i] == 0 ? Integer.MAX_VALUE : minArr[idx][i];
		}
		dist[idx] = 0;
		int res = 0;
		for(int i = 1; i < cnt; i++) {
			int min = Integer.MAX_VALUE;
			int minIdx = 0;
			for(int j = 1; j < cnt; j++) {
				if(v[j]) { // 이미 포함된 정점 무시
					continue;
				}
				if(min > dist[j]) {
					min = dist[j];
					minIdx = j;
				}
			}
			
			res += min;
			v[minIdx] = true;
			
			for(int j = 1; j < cnt; j++) {
				if(v[j]) continue;
				
				// 현재 선택된 위치에서 연결되지 않은 정점은 무시
				if(minArr[minIdx][j] == 0) continue;
				
				// 현재 선택된 위치에서 연결된 정점에서
				// 기존 dist 배열에 있는 비용보다 새롭게 선택된 정점으로의 비용이
				// 최소비용이면 업데이트
				if(dist[j] > minArr[minIdx][j]) {
					dist[j] = minArr[minIdx][j];
				}
			}
		}

		if(res >= 10000) System.out.println(-1);
		else System.out.println(res);
		
	}
	static void makeBridge(int i, int j, int now, int dir, int cnt) {
		if(i < 0 || i >= N || j < 0 || j >= M) return;
		if(visited[i][j] == now) return;
		if(visited[i][j] != 0) {
			if(cnt == 2) return;
			minArr[now][visited[i][j]] = Math.min(minArr[now][visited[i][j]], cnt-1);
			return;
		}
		
		makeBridge(i + dy[dir], j + dx[dir], now, dir, cnt+1);
	}
	
	
	
	static void dfs(int i, int j, int cnt) {
		if(i < 0 || i >= N || j < 0 || j >= M) return;
		if(visited[i][j] >= 1) return;
		if(map[i][j] == 0) return;
		
		visited[i][j] = cnt;
		
		dfs(i + 1, j, cnt);
		dfs(i, j + 1, cnt);
		dfs(i - 1, j, cnt);
		dfs(i, j - 1, cnt);
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
	}
}
