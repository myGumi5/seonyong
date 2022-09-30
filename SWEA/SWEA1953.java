package com.ssafy.algo.live20220930;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.StringTokenizer;

public class SWEA1953 {
	static int T, N, M, R, C, time, cnt;
	static int [][] map, visited;
	static int [] dy = {-1, 1, 0, 0};
	static int [] dx = {0, 0, -1, 1};
	
	public static void main(String[] args) {
		FastReader sc = new FastReader();
		
		T = sc.nextInt();
		for(int t = 0; t < T; t++) {
			N = sc.nextInt();
			M = sc.nextInt();
			R = sc.nextInt();
			C = sc.nextInt();
			time = sc.nextInt();
			
			cnt = 0;
			map = new int[N][M];
			visited = new int[N][M];
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			
			bfs();
			System.out.printf("#%d %d\n", t+1, cnt+1);
			
		}

	}
	static boolean isCanGo(int dir, int R, int C, int nodeTime) {
		if(R < 0 || R >= N || C < 0 || C >= M) {
			return false;
		}
		if(visited[R][C] == 1) {
			return false;
		}
		if(map[R][C] == 0) {
			return false;
		}
		if(nodeTime == time) {
			return false;
		}
		
		if(dir == 0) {
			if(map[R][C] == 4 || map[R][C] == 3 ||
					map[R][C] == 7) return false;
		} else if(dir == 1) {
			if(map[R][C] == 6 || map[R][C] == 3 ||
					map[R][C] == 5) return false;
		} else if(dir == 2) {
			if(map[R][C] == 6 || map[R][C] == 2 ||
					map[R][C] == 7) return false;
		} else{
			if(map[R][C] == 4 || map[R][C] == 2 ||
					map[R][C] == 5) return false;
		} 
		
		return true;
	}
	
	static void bfs() {
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(R, C, 0, 1));
		visited[R][C] = 1;
		
		while(!q.isEmpty()) {
			Node n = q.poll();
			int y = n.y;
			int x = n.x;
			
			for(int i = 0; i < 4; i++) {
				if(shpaePipe(i, y, x)) continue;
				if(isCanGo(i, y+dy[i], x+dx[i], n.time)) {
					q.add(new Node(y+dy[i], x+dx[i], n.dist+1, n.time+1));
					visited[y+dy[i]][x+dx[i]] = 1;
					cnt++;
				}
			}
			

		}
		
		
	}
	static class Node{
		int y, x, dist, time;

		public Node(int y, int x, int dist, int time) {
			super();
			this.y = y;
			this.x = x;
			this.dist = dist;
			this.time = time;
		}

		@Override
		public String toString() {
			return "Node [y=" + y + ", x=" + x + ", dist=" + dist + ", time=" + time + "]";
		}
		
		
	}
	
	private static boolean shpaePipe(int dir, int R, int C) {
		if(map[R][C] == 1) {
			return false;
		} else if(map[R][C] == 2) {
			if(dir == 0 || dir == 1) return false;
		} else if(map[R][C] == 3) {
			if(dir == 2 || dir == 3) return false;
		} else if(map[R][C] == 4) {
			if(dir == 0 || dir == 3) return false;
		} else if(map[R][C] == 5) {
			if(dir == 1 || dir == 3) return false;
		} else if(map[R][C] == 6) {
			if(dir == 1 || dir == 2) return false;
		} else {
			if(dir == 0 || dir == 2) return false;
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
/*

1    
5 6 2 1 3  
0 0 5 3 6 0
0 0 2 0 2 0
3 3 1 3 7 0
0 0 0 0 0 0
0 0 0 0 0 0

1
5 6 2 2 6
3 0 0 0 0 3
2 0 0 0 0 6
1 3 1 1 3 1
2 0 2 0 0 2
0 0 4 3 1 1
10 10 4 3 9
*/