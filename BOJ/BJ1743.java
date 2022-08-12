package com.ssafy.coding.live20220812;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BJ1743 {
	static int N, M, K, result = Integer.MIN_VALUE;
	static char [][] map;
	static int [][] visited;
	static int [] dx = {1, -1, 0, 0};
	static int [] dy = {0, 0, 1, -1};
	
	
	public static void main(String[] args) {
		FastReader sc = new FastReader();
		N = sc.nextInt();
		M = sc.nextInt();
		K = sc.nextInt();
		
		map = new char [N+1][M+1];
		visited = new int[N+1][M+1];
		for(int i = 0; i < K;i++) {
			int r = sc.nextInt();
			int c = sc.nextInt();
			
			map[r][c] = '#';
		}
		
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= M; j++) {
				if(visited[i][j] != 1)
					if(map[i][j] == '#')
						bfs(i, j);
			}
		}
		
		System.out.println(result);
	}
	static void bfs(int i, int j) {
		Queue<Integer> q = new LinkedList<>();
		q.add(i);
		q.add(j);
		visited[i][j] = 1;
		int cnt = 1;
		
		while(!q.isEmpty()){
			int r = q.poll();
			int c = q.poll();
			
			for(int t = 0; t < 4; t++) {
				int ry = r + dy[t];
				int cx = c + dx[t];
				
				if(cx <= 0 || cx > M || ry <= 0 || ry > N) continue;
				if(visited[ry][cx] == 1) continue;
				if(map[ry][cx] != '#') continue;
				
				visited[ry][cx] = 1;
				q.add(ry);
				q.add(cx);
				cnt++;
			}
		}
		
		result = Math.max(cnt, result);
		
	}
	
	static class FastReader{
		BufferedReader br = null;
		StringTokenizer st = null;
		
		public FastReader() {
			try {
				br = new BufferedReader(new InputStreamReader(System.in));
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		String next() {
			while(st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (Exception e) {
					// TODO: handle exception
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
