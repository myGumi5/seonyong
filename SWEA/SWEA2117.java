package com.ssafy.coding.live20221002;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class SWEA2117 {
	static int T, N, M;
	static int [][] map, visited;
	
	static int[] dy = {0, 0, 1, -1};
	static int[] dx = {1, -1, 0, 0};
	
	static HashMap<Integer, Integer> hash = null;
	
	public static void main(String[] args) {
		FastReader sc = new FastReader();
		T = sc.nextInt();
		
		for(int t = 0; t < T; t++) {
			N = sc.nextInt();
			M = sc.nextInt();
			map = new int[N][N];
			visited = new int[N][N];
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			
			int ans = 0;
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					visited = new int[N][N];
					hash = new HashMap<Integer, Integer>();
					for(int z = 1; z <= 21; z++) hash.put(z, 0); 
					// map init
					//System.out.println(hash);
					bfs(i, j);
					ans = Math.max(ans, check());
					
				}
			}
			
			System.out.printf("#%d %d\n", t+1, ans);
			
		}
		
	}
	/*
1
8 3
0 0 0 0 0 1 0 0
0 1 0 1 0 0 0 1
0 0 0 0 0 0 0 0
0 0 0 1 0 1 0 0
0 0 1 1 0 0 0 0
0 0 0 0 0 0 0 0
0 0 0 0 1 0 1 0
1 0 0 0 0 0 0 0

	 
	 */
	static int check() {
		for(int i = 2; i<= 21; i++) {
			hash.put(i, hash.get(i-1) + hash.get(i));
		}
		
		for(int i = 21; i >= 1; i--) {
			if(hash.get(i) >= (i * i) + (i-1) * (i-1)) {
				return hash.get(i) / M;
			}
			
		}
		
		return 0;
	}
	
	static void bfs(int i, int j) {
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(i, j, 1, 1));
		visited[i][j] = 1;
		if(map[i][j] == 1) {
			if (hash.get(1) == null) {
				hash.put(1, M);
			} else {
				hash.put(1, hash.get(1) + M);
			}
		}
		
		while(!q.isEmpty()) {
			Node n = q.poll();
			int y = n.y;
			int x = n.x;
			
			for(int d = 0; d < 4; d++) {
				int r = y+dy[d];
				int c = x+dx[d];
				
				if(r < 0 || c < 0 || r >= N || c >= N) continue;
				if(visited[r][c] == 1) continue;
				
				if(map[r][c] == 1) {
					if(hash.get(n.dist+1) == null) {
						hash.put(n.dist+1, M);
					} else {
						hash.put(n.dist+1, hash.get(n.dist+1) + M);
					}
				}
				q.add(new Node(r, c, n.dist+1, map[r][c]));
				visited[r][c] = 1;
			}
			
		}
		
	}
	
	static class Node{
		int y, x, dist;
		int ishouse;

		

		public Node(int y, int x, int dist, int ishouse) {
			super();
			this.y = y;
			this.x = x;
			this.dist = dist;
			this.ishouse = ishouse;
		}



		@Override
		public String toString() {
			return "Node [y=" + y + ", x=" + x + ", dist=" + dist + "]";
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
