package com.ssafy.algo.live20221108;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class SWEA4193 {
	static int T, N;
	static int[][] map, visited;
	static int[] s, e;
	
	static int[] dy = {0, 0, 1, -1};
	static int[] dx = {1, -1, 0, 0};
	
	public static void main(String[] args) {
		FastReader sc = new FastReader();
		
		T = sc.nextInt();
		for(int t = 1 ; t <= T; t++) {
			N = sc.nextInt();
			
			visited = new int[N][N];
			map = new int[N][N];
			s = new int[2];
			e = new int[2];
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++){
					map[i][j] = sc.nextInt();
				}
			}
			s[0] = sc.nextInt();
			s[1] = sc.nextInt();
			e[0] = sc.nextInt();
			e[1] = sc.nextInt();
			
			int ans = bfs();
			
//			for(int i = 0; i < N; i++) {
//				System.out.println(Arrays.toString(visited[i]));
//			}
			
			System.out.printf("#%d %d\n", t, ans);
			
		}
		
	}
	
	static int bfs() {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(s[0], s[1], 1));
		visited[s[0]][s[1]] = 1;
		
		while(!pq.isEmpty()) {
			Node n = pq.poll();
			int r = n.y;
			int c = n.x;
			
			if(r == e[0] && c == e[1]) {
				return n.time - 1;
			}
			
			for(int d = 0; d < 4; d++) {
				int nr = r + dy[d];
				int nc = c + dx[d];
				
				if(nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
				if(map[nr][nc] == 2 && (((n.time - 1) % 3) - 2) != 0) {
					pq.add(new Node(r, c, n.time + 1));
				} else {
					if(map[nr][nc] == 1) continue;
					if(visited[nr][nc] != 0 && visited[nr][nc] <= n.time + 1) continue;
					if(map[nr][nc] == 2) {
						if((((n.time - 1) % 3) - 2) == 0) {
							pq.add(new Node(nr, nc, n.time + 1));
							visited[nr][nc] = n.time + 1;
						} 
						continue;
					}
					
					pq.add(new Node(nr, nc, n.time+1));
					visited[nr][nc] = n.time + 1;
				}
			}
		}
		
		return -1;
		
	}
	
	static class Node implements Comparable<Node>{
		int y, x, time;

		public Node(int y, int x, int time) {
			super();
			this.y = y;
			this.x = x;
			this.time = time;
		}

		@Override
		public String toString() {
			return "Node [y=" + y + ", x=" + x + ", time=" + time + "]";
		}

		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return this.time - o.time;
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
