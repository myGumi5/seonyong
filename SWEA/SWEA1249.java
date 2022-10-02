package com.ssafy.coding.live20221002;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class SWEA1249 {
	static int T, N;
	static int[][] map, visited;
	
	static int[] dy = {0, 0, 1, -1};
	static int[] dx = {1, -1, 0, 0};
	public static void main(String[] args) {
		FastReader sc = new FastReader();
		T = sc.nextInt();
		for(int t = 0; t < T; t++) {
			N = sc.nextInt();
			
			visited = new int[N][N];
			map = new int[N][N];
			for(int i = 0; i < N; i++) {
				String str = sc.nextLine();
				for(int j = 0; j < N; j++) {
					map[i][j] = str.charAt(j) - 48;
				}
			}
			
			System.out.printf("#%d %d\n", t+1, bfs());
		
		}
		
	}
	static int bfs() {
		PriorityQueue<Node> q = new PriorityQueue<>();
		q.add(new Node(0, 0, 0, 0));
		visited[0][0] = 1;
		
		while(!q.isEmpty()) {
			Node n = q.poll();
			int r = n.y;
			int c = n.x;
			
			if(r == (N-1) && c == (N-1)) {
				return n.cost;
			}
			
			for(int d = 0; d < 4; d++) {
				int ry = r + dy[d];
				int cx = c + dx[d];
				
				if(ry < 0 || cx < 0 || ry >= N || cx >= N) continue;
				if(visited[ry][cx] == 1) continue;
				
				visited[ry][cx] = 1;
				if(map[ry][cx] >= 1) {
					q.add(new Node(ry, cx, n.cost + map[ry][cx], n.dist + 1));
				} else {
					q.add(new Node(ry, cx, n.cost, n.dist + 1));
				}
			}
		}
		
		return Integer.MAX_VALUE;
	}
	
	static class Node implements Comparable<Node>{
		int x, y, cost, dist;

		public Node(int y, int x, int cost, int dist) {
			super();
			this.x = x;
			this.y = y;
			this.cost = cost;
			this.dist = dist;
		}

		@Override
		public String toString() {
			return "Node [x=" + x + ", y=" + y + ", cost=" + cost + ", dist=" + dist + "]";
		}

		@Override
		public int compareTo(Node o) {
			if(this.cost == o.cost) return this.dist - o.dist;
			return this.cost - o.cost;
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
