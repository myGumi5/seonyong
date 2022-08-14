package com.ssafy.coding.live20220814;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BJ4963 {
	static int w, h, cnt;
	static int [][] map, visited;
	static int [] dx = {1, -1, 0, 0, 1, -1, 1, -1};
	static int [] dy = {0, 0, 1, -1, -1, 1, 1, -1};
	
	public static void main(String[] args) {
		FastReader sc = new FastReader();
		
		while(true) {
			w = sc.nextInt();
			h = sc.nextInt();
			cnt = 0;
			
			if(w == 0 && h == 0) break;
			
			visited = new int[h][w];
			map = new int[h][w];
			for(int i = 0; i < h; i++) {
				for(int j = 0; j < w; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			
			for(int i = 0; i < h; i++) {
				for(int j = 0; j < w; j++) {
					if(visited[i][j] == 0) {
						if(map[i][j] == 1) {
							bfs(i, j);
							cnt++;
						}
					}
				}
			}
			
			System.out.println(cnt);
		}
	}
	static void bfs(int i, int j) {
		Queue<Integer> q = new LinkedList<>();
		q.add(i);
		q.add(j);
		visited[i][j] = 1;
		
		while(!q.isEmpty()) {
			int r = q.poll();
			int c = q.poll();
			
			for(int d = 0; d < 8; d++) {
				int ry = r + dy[d];
				int cx = c + dx[d];
				
				if(ry < 0 || ry >= h || cx < 0 || cx >= w) continue;
				if(visited[ry][cx] == 1) continue;
				if(map[ry][cx] == 0) continue;
				
				q.add(ry);
				q.add(cx);
				visited[ry][cx] = 1;
			}
		}
		
	}
	
	static class FastReader{
		BufferedReader br = null;
		StringTokenizer st = null;
		
		FastReader(){
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
