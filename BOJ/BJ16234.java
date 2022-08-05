package com.ssfay.coding.BJ20220805;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ16234 {
	static int N, L, R, cnt = 0;
	static int [][] map, visited;
	static HashMap<Node, ArrayList<Node>> union; 
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	
	public static void main(String[] args) {
		input();
		
		while(true) {
			union = new HashMap<>();
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (visited[i][j] != 1) {
						bfs(i, j);
					}
				}
			}
			boolean check = true;
			for(Node p : union.keySet()) {
				if(union.get(p).size() != 0) {
					check = false;
				}
			}
			
			if(check) {
				break;
			}
			
			for (Node n : union.keySet()) {
				int sum = map[n.r][n.c];
				for (Node n1 : union.get(n)) {
					sum += map[n1.r][n1.c];
				}
				
				if(union.get(n).size() != 0)
					map[n.r][n.c] = sum / (union.get(n).size() + 1);
				for (Node n1 : union.get(n)) {
					if(union.get(n).size() == 0) continue;
						map[n1.r][n1.c] = sum / (union.get(n).size() + 1);
				}

			}
			
			cnt++;
			visited = new int[N][N];
		}
		
		System.out.println(cnt);
		
	}
	
	static void bfs(int y, int x) {
		Queue<Integer> q = new LinkedList<>();
		ArrayList<Node> a = new ArrayList<>();
		q.add(y);
		q.add(x);
		visited[y][x] = 1;
		
		
		while(!q.isEmpty()) {
			int r = q.poll();
			int c = q.poll();
			
			for(int i = 0; i < 4; i++) {
				int ry = r + dy[i];
				int cx = c + dx[i];
				if(ry < 0 || ry >= N || cx < 0 || cx >= N) continue;
				if(visited[ry][cx] == 1) continue;
				if(Math.abs(map[r][c] - map[ry][cx]) >= L & Math.abs(map[r][c] - map[ry][cx]) <= R) {
					q.add(ry);
					q.add(cx);
					a.add(new Node(ry, cx));
					visited[ry][cx] = 1;
				}
			}
		}
		
		union.put(new Node(y, x), a);
	}
	
	static void input() {
		FastReader sc = new FastReader();
		N = sc.nextInt();
		L = sc.nextInt();
		R = sc.nextInt();
		
		visited = new int[N][N];
		map = new int[N][N];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
	}
	static class Node {
		int r;
		int c;
		
		public Node(int r, int c){
			this.r = r;
			this.c = c;
		}

		@Override
		public String toString() {
			return "Node [r=" + r + ", c=" + c + "]";
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
	}
}
