package com.ssafy.coding.live20221011;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA5643 {
	static int N, M;
	static int[][] adj;
	
	public static void main(String[] args) {
		FastReader sc = new FastReader();
		int T = sc.nextInt();
		
		for(int t = 1; t <= T; t++) {
			N = sc.nextInt();
			M = sc.nextInt();
			
			adj = new int[N+1][N+1]; // 학생번호 1부터 처리
			
			for(int m = 0; m < M; m++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				
				adj[a][b] = 1; // a보다 b가 키가 크다
			}
			
			int ans = 0;
			for(int i = 1; i <= N; i++) {
				if(tlBfs(i)+ltBfs(i) == N-1) {
					ans++;
				}
				
				
			}
			System.out.println("#"+t+" "+ans);
		}
		
	}
	static int tlBfs(int start) { // start 학생부터 자신보다 키가 큰 학생 따라 탐색
		Queue<Integer> q = new LinkedList<Integer>();
		boolean[] visited = new boolean[N+1];
		visited[start] = true;
		q.add(start);
		
		int count = 0;
		while(!q.isEmpty()) {
			int cur = q.poll();
			
			for(int i = 1; i <= N; i++) { // 자신의 인접행렬 들여다보기
				if(adj[cur][i] == 1 && !visited[i]) { // i가 cur 보다 키가 크다!
					visited[i] = true;
					q.add(i);
					count++;
				}
			}
		}
		
		return count;
	}
	
	static int ltBfs(int start) { // start 학생부터 자신보다 키가 큰 학생 따라 탐색
		Queue<Integer> q = new LinkedList<Integer>();
		boolean[] visited = new boolean[N+1];
		visited[start] = true;
		q.add(start);
		
		int count = 0;
		while(!q.isEmpty()) {
			int cur = q.poll();
			
			for(int i = 1; i <= N; i++) {
				if(adj[i][cur] == 1 && !visited[i]) { // i가 cur 보다 키가 작다!
					visited[i] = true;
					q.add(i);
					count++;
				}
			}
		}
		
		return count;
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
