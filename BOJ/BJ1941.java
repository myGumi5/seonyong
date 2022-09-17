package com.ssafy.coding.live20220917;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BJ1941 {
	static int r = 5, c = 5, ans = 0;
	static char[][] map;
	static int[][] coor;
	static int[] dy = {0, 0, 1, -1};
	static int[] dx = {1, -1, 0, 0};
	
	public static void main(String[] args) {
		FastReader sc = new FastReader();
		
		map = new char[r][c];
		coor = new int[25][2];
		int num = 0;
		for(int i = 0; i < r; i++) {
			String str = sc.nextLine();
			for(int j = 0; j < c; j++) {
				map[i][j] = str.charAt(j);
				coor[num][0] = i;
				coor[num++][1] = j;
			}
		}
		
		combination(new int[7+1], 1, 0);
		
		System.out.println(ans);
	}
	static boolean dfs(int [] com) {
		int[] visited = new int[7+1];
		int num = com[1] - 1;
		LinkedList<Integer> q = new LinkedList<>();
		q.add(coor[num][0]);
		q.add(coor[num][1]);
		visited[1] = 1;
		
		while(!q.isEmpty()) {
			int r = q.poll();
			int c = q.poll();
			
			for (int i = 0; i < 4; i++) {
				int ry = r + dy[i];
				int cx = c + dx[i];
				
				for(int j = 1; j <= 7; j++) {
					int sub = com[j] - 1;
					if(visited[j] == 1) continue;
					if(coor[sub][0] == ry && coor[sub][1] == cx) {
						q.add(0, cx);
						q.add(0, ry);
						visited[j] = 1;
					}
				}
				
			}
		}

		for(int i = 1; i <= 7; i++) {
			if(visited[i] != 1) return false;
		}
		return true;
	}
	
	static boolean count(int num) {
		int ry = coor[num-1][0];
		int cx = coor[num-1][1];
		
		if(map[ry][cx] == 'Y') return true;
		else return false;
	}
	
	static void combination(int[] com, int depth, int cnt) {
		if(cnt >= 4) {
			return;
		}
		
		if(depth == 7+1) {
			if(dfs(com)) {
				ans++;
				//System.out.println(Arrays.toString(Arrays.copyOfRange(com, 1, depth)));
			}
			
			return;
		}
		
		for(int i = com[depth - 1]+1; i <= 25; i++) {
			com[depth] = i;
			
			if(count(i))combination(com, depth + 1, cnt+1);
			else combination(com, depth + 1, cnt);
			com[depth] = 0;
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
			}catch (Exception e) {
				e.printStackTrace();
			}
			return str;
		}
	}
}
