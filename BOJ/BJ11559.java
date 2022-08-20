package com.ssafy.coding.live20220820;

import java.io.*;
import java.util.*;


public class BJ11559 {
	static int N = 12, M = 6, cnt = 0, count = 0;
	static char[][] map;
	static int[][] visited;
	static boolean flag = true, over = true;
	
	static int[] dy = { 0, 0, 1, -1};
	static int[] dx = {1, -1, 0, 0};
	
	public static void main(String[] args) {
		FastReader sc = new FastReader();
		
		map = new char[N][M];
		visited = new int [N][M];
		for(int i = 0; i < N; i++) {
			String str = sc.nextLine();
			for(int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		
		pro();
		
	}
	
	
	
	private static void pro() {
		while(true) { // 더 터트릴 뿌요의 유무판단.
			visited = new int [N][M];
			flag = true;
			over = true; 
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					count = 0;
					if(visited[i][j] == 1) continue;
					if(map[i][j] == '.') continue;
					check(i, j, 1, map[i][j]);
					if(count >= 4) {
						over = false;
					}
				}
			}
			
			if(over) break;
			
			visited = new int [N][M];
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					if(map[i][j] == '.') continue;
					if(visited[i][j] == 1) continue;
					getPopCoor(i, j);
				}
			}
			
			setting(); // 터트린만큼 빈 공간을  정리하기
			
//			for(int i = 0; i < N; i++) {
//				System.out.println(Arrays.toString(map[i]));
//			}
//			System.out.println();
		}
		
		System.out.println(cnt);
		
	}



	private static void check(int i, int j, int depth, char shape) {
		if(i < 0 || i >= N || j < 0 || j >= M) return;
		if(visited[i][j] == 1) return;
		if(map[i][j] != shape) return;
		
		
		visited[i][j] = 1;
		count++;
		
		check(i+1, j, depth+1, shape);
		check(i, j+1, depth+1, shape);
		check(i-1, j, depth+1, shape);
		check(i, j-1, depth+1, shape);
		
	}



	private static void getPopCoor(int i, int j) {
		ArrayList<Node> list = new ArrayList<>();
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(i, j, map[i][j]));
		list.add(new Node(i, j, map[i][j]));
		visited[i][j] = 1;
		
		while(!q.isEmpty()) {
			Node n = q.poll();
			int r = n.y;
			int c = n.x;
			
			for(int t = 0; t < 4; t++) {
				int ry = r + dy[t];
				int cx = c + dx[t];
				
				if(ry < 0 || ry >= N || cx < 0 || cx >= M) continue;
				if(map[ry][cx] != n.shape) continue;
				if(visited[ry][cx] == 1) continue;
				
				list.add(new Node(ry, cx, map[ry][cx]));
				q.add(new Node(ry, cx, map[ry][cx]));
				visited[ry][cx] = 1;
			}
			
		}
		
		if(list.size() >= 4) {
			for(Node n : list) {
				map[n.y][n.x] = '.';
				if(flag) {
					cnt++;
					flag = false;
				}
			}
		}

	}



	private static void setting() {
		for(int i = N-1; i >= 0; i--) {
			for(int j = M-1; j >= 0; j--) {
				if(map[i][j] == '.') {
					for(int z = i; z >= 0; z--) {
						if(map[z][j] != '.') {
							swap(i, z, j);
							break;
						}
					}
				}
			}
		}
	}

	static void swap(int i , int z, int j) {
		map[i][j] = map[z][j];
		map[z][j] = '.';
	}
	
	static class Node{
		int y, x;
		char shape;

		public Node(int y, int x, char shape) {
			super();
			this.y = y;
			this.x = x;
			this.shape = shape;
		}

		@Override
		public String toString() {
			return "Node [y=" + y + ", x=" + x + ", shape=" + shape + "]";
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
					// TODO: handle exception
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
				// TODO: handle exception
				e.printStackTrace();
			}
			
			return str;
		}
	}
}
