package com.ssafy.coding.live20220926;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class BJ1941_dfs {
	static ArrayList<int []> list = null;
	static char [][] map;
	static boolean[][] visited;
	static int N = 5, ans = 0;
	
	static int[] dy = {0, 0, 1, -1};
	static int[] dx = {1, -1, 0, 0};
	
	
	public static void main(String[] args) {
		FastReader sc = new FastReader();
		
		map = new char[N][N];
		list = new ArrayList<>();
		for(int i = 0; i < N; i++) {
			String str = sc.nextLine();
			for(int j = 0; j < N; j++) {
				map[i][j] = str.charAt(j);
				list.add(new int[] {i, j});
			}
		}
		
		dfs(0, new ArrayList<Integer>(), 0);

		System.out.println(ans);
	}
	static void bfs(ArrayList<Integer> sub) {
		visited = new boolean[N][N];
		Queue<Integer> q = new LinkedList<>();
		q.add(list.get(sub.get(0))[0]);
		q.add(list.get(sub.get(0))[1]);
		visited[list.get(sub.get(0))[0]][list.get(sub.get(0))[1]] = true;
		
		int cnt = 1;
		while(!q.isEmpty()) {
			int i = q.poll();
			int j = q.poll();
			
			for(int t = 0; t < 4; t++) {
				int ry = i + dy[t];
				int cx = j + dx[t];
				
				if(ry < 0 || ry >= N || cx < 0 || cx >= N) continue;
				
				
				for(int a : sub) {
					if(visited[ry][cx]) continue;
					if(list.get(a)[0] == ry && list.get(a)[1] == cx) {
						q.add(ry);
						q.add(cx);
						visited[ry][cx] = true;
						cnt++;
						break;
					}
				}
			}
		}
		
		if(cnt == 7) ans++; 
	}
	
	static void dfs(int depth, ArrayList<Integer> sub, int y) {
		if(y >= 4 || list.size() - depth + sub.size() < 7) {
			return;
		}
		
		if(sub.size() >= 7) {
//			if(sub.get(0) == 5 && sub.get(5) == 14) {
//				System.out.println("start");
//			}
//		
//			
//			for (int i = 0; i < sub.size(); i++) {
//				System.out.print(sub.get(i) + " ");
//			}
//			System.out.println();
	
			bfs(sub);
			
			return;
		}
		
		// 선택
		int i = list.get(depth)[0];
		int j = list.get(depth)[1];
		sub.add(depth);
		if(map[i][j] == 'Y') {
			dfs(depth + 1, new ArrayList<>(sub), y+1);
		} else {
			dfs(depth + 1, new ArrayList<>(sub), y);
		}
		
		sub.remove(sub.size()-1);
		// 미선택
		dfs(depth + 1, new ArrayList<>(sub), y);
		
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
