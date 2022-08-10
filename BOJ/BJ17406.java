package com.ssfay.coding.live20220810;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ17406 {
	static int N, M, K, min = Integer.MAX_VALUE;
	static int minX, minY, maxX, maxY;
	static int[] visited;
	static int [][] command, map, copy;
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	
	public static void main(String[] args) {
		input();
		permution(new int[K+1], 1);
		
		System.out.println(min);
	}
	
	static void rollingMap(int i, int j) {
		int temp = map[i][j];
		int grade = 0;
		
		int y = i;
		int x = j;
		while(true) {	
			y = y + dy[grade];
			x = x + dx[grade];
			
			if(x < minX || x >= maxX || y < minY || y >= maxY) {
				x -= dx[grade];
				y -= dy[grade];
				grade++;
				continue;
			}
			
			map[y-dy[grade]][x-dx[grade]] = map[y][x];
			if(x == j && y == i) {
				map[i][j+1] = temp;
				break;
			}
			
		}
	
	}
	
	static void permution(int arr[], int depth) {
		if(depth == K + 1) {
			
			for(int k = 1; k <= K; k++) {
				int take = arr[k] - 1;
				maxY = command[take][0] + command[take][2];
				maxX = command[take][1] + command[take][2];
				minX = command[take][1] - command[take][2] - 1;
				minY = command[take][0] - command[take][2] - 1;
				
				int w = (maxX-minX) / 2;
				int h = (maxY-minY) / 2;
				int i = 0;
				while(true) {
					if(i >= w|| i >= h)
						break;
					rollingMap(minY, minX);
					minX++;
					minY++;
					maxX--;
					maxY--;
					i++;
				}
			}
			
			
			for(int i = 0; i < N; i++) {
				int sum = 0;
				for(int j = 0; j <M;j++) {
					sum += map[i][j];
					map[i][j] = copy[i][j];
				}
				min = Math.min(min, sum);
			}
		}
		
		for(int i = 1; i <= K; i++) {
			if(visited[i] == 1) continue;
			arr[depth] = i;
			visited[i] = 1;
			permution(arr, depth+1);
			visited[i] = 0;
		}
	}
	
	static void input() {
		FastReader sc = new FastReader();
		N = sc.nextInt();
		M = sc.nextInt();
		K = sc.nextInt();
		
		visited = new int[K+1];
		map = new int[N][M];
		copy = new int[N][M];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
				copy[i][j] = map[i][j];
			}
		}
		
		command = new int[K][3];
		for(int i = 0; i < K; i++) {
			command[i][0] = sc.nextInt();
			command[i][1] = sc.nextInt();
			command[i][2] = sc.nextInt();
			
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
