package com.ssafy.coding.BJ20220804;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ1261 {
	static int N, M, cnt = 0;
	static int[][] map, visited;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	
	public static void main(String[] args) {
		input();
		
		bfs();
		
		System.out.println(cnt);
	}
	
	static void bfs() {
		PriorityQueue<Node> q = new PriorityQueue<>();
		q.offer(new Node(0, 0, 0));
		visited[0][0] = 1;
		
		while(!q.isEmpty()) {
			Node n = q.poll();
			int x = n.j;
			int y = n.i;
			
			if(x == M - 1 && y == N -1) {
				cnt = n.depth;
				return;
			}
			
			for(int i = 0; i < 4; i++) {
				int c = x + dx[i];
				int r = y + dy[i];
				if(c < 0 || c >= M || r < 0 || r >= N) continue;
				if(visited[r][c] == 1) continue;
				
				if(map[r][c] == 1) {
					q.add(new Node(r, c, n.depth+1));
					visited[r][c] = 1;
				} else{
					q.add(new Node(r, c, n.depth));
					visited[r][c] = 1;
				}
			}
		}
		
		
	}
	
	static void input() {
		FastReader sc = new FastReader();
		M = sc.nextInt();
		N = sc.nextInt();
		
		map = new int[N][M];
		visited = new int[N][M];
		for(int i = 0; i < N; i++) {
			String str = sc.nextLine();
			for(int j = 0; j < str.length(); j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}
	}
	static class Node implements Comparable<Node>{
		int i;
		int j;
		int depth;
		
		public Node(int i, int j, int depth) {
			this.i = i;
			this.j = j;
			this.depth = depth;
			
		}
		
		@Override
		public int compareTo(Node o1) {
			return this.depth - o1.depth;
		}
		
	}
	
	static class FastReader{
		BufferedReader br = null;
		StringTokenizer st = null;
		
		public FastReader(){
			br = new BufferedReader(new InputStreamReader(System.in));
		}
		
		String next() {
			while(st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			return st.nextToken();
		}
		
		int nextInt() {
			return Integer.parseInt(next());
		}
		String nextLine() {
			String str = "";
			try {
				str = br.readLine();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return str;
		}

	}
}
