package com.ssafy.coding.live20220809;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BJ7562 {
	static int I, T, cnt;
	static int[] dx = {-2, -2, 2, 2, 1, -1, 1, -1};
	static int[] dy = {1, -1, 1, -1, -2, 2, 2, -2};
	static int[][] visited;
	static int[] arr;
	public static void main(String[] args) {
		FastReader sc = new FastReader();
		T = sc.nextInt();
		
		for(int t = 0; t < T; t++){
			I = sc.nextInt();
			visited = new int[I][I];
			arr = new int[2];
			cnt = 0;
		
			int x = sc.nextInt();
			int y = sc.nextInt();
			arr[0] = sc.nextInt();
			arr[1] = sc.nextInt();
			
			bfs(x, y);
			
			System.out.println(cnt);
 		}
	}
	static void bfs(int startX, int startY) {
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(startX, startY, 0));
		visited[startY][startX] = 1;
		
		while(!q.isEmpty()) {
			Node n = q.poll();
			
			for(int i = 0; i < 8; i++) {
				int cx = n.x + dx[i];
				int ry = n.y + dy[i];
				
				if(cx < 0 || cx >= I || ry < 0 || ry >= I) continue;
				if(visited[ry][cx] == 1) continue;
				if(cx == arr[0] && ry == arr[1]) {
					cnt = n.depth + 1;
					return;
				}
				
				q.add(new Node(cx, ry, n.depth+1));
				visited[ry][cx] = 1;
				
			}
		}
		
		
	}
	static class Node {
		int x;
		int y;
		int depth;
		
		public Node(int x, int y, int depth) {
			super();
			this.x = x;
			this.y = y;
			this.depth = depth;
		}

		@Override
		public String toString() {
			return "Node [x=" + x + ", y=" + y + ", depth=" + depth + "]";
		}
		
		
	}
	static class FastReader{
		BufferedReader br = null;
		StringTokenizer st = null;
		
		FastReader(){
			br = new BufferedReader(new InputStreamReader(System.in));
		}
		
		String next() {
			while(st == null ||!st.hasMoreElements()) {
				try{
					st = new StringTokenizer(br.readLine());
				} catch(Exception e) {
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
