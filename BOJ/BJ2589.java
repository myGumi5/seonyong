package com.ssafy.algo.live20221107;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ2589 {
	static int L, W, max;
	static char[][] map;
	
	static boolean[][] visited;
	
	static int[] dy = {0, 0, 1, -1};
	static int[] dx = {1, -1, 0, 0};
	
	public static void main(String[] args) {
		FastReader	sc = new FastReader();
		L = sc.nextInt();
		W = sc.nextInt();
		
		visited = new boolean[L][W];
		map = new char[L][W];
		for(int i = 0; i < L; i++) {
			String str = sc.nextLine();
			for(int j = 0; j < W; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		
		for(int i = 0; i < L; i++) {
			for(int j = 0; j < W; j++) {
				visited = new boolean[L][W];
//				if(i == 3 && j == 0) {
//					System.out.println("start");
//				}
				if(map[i][j] == 'L') bfs(i, j);
//				if(max == 10) {
//					System.out.println("start");
//				}
			}
		}
		
		System.out.println(max);
		
	}
	
	static void bfs(int i, int j) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(i, j, 0));
		visited[i][j] = true;
		
		while(!pq.isEmpty()) {
			Node n = pq.poll();
			int r = n.y;
			int c = n.x;
			
			max = Math.max(max, n.dist);
					
			for(int d = 0; d < 4; d++) {
				int nr = r + dy[d];
				int nc = c + dx[d];
				
				if(nr < 0 || nc < 0 || nr >= L || nc >= W) continue;
				if(visited[nr][nc]) continue;
				if(map[nr][nc] != 'L') continue;
				
				visited[nr][nc] = true;
				pq.add(new Node(nr, nc, n.dist+1));
			}
		}
	}
	
	static class Node implements Comparable<Node>{
		int y, x, dist;

		public Node(int y, int x, int dist) {
			super();
			this.y = y;
			this.x = x;
			this.dist = dist;
		}

		@Override
		public String toString() {
			return "Node [y=" + y + ", x=" + x + ", dist=" + dist + "]";
		}

		@Override
		public int compareTo(Node o) {
			return this.dist - o.dist;
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
