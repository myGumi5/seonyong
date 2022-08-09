package com.ssfay.coding.live20220810;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BJ1697 {
	static int N, K, cnt = Integer.MAX_VALUE;
	static int[] visited;
	static int[] dir = {-1, 1, N};
			
	public static void main(String[] args) {
		FastReader sc = new FastReader();
		
		N = sc.nextInt();
		K = sc.nextInt();
		visited = new int[100001];
		
		bfs();
		
		System.out.println(cnt);
	}
	static void bfs() {
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(N, 0));
		visited[N] = 1;
		
		while(!q.isEmpty()) {
			Node n = q.poll();
			int num = n.value;
			dir[2] = num;
			if(num == K) {
				cnt = n.depth;
				return;
			}
			
			
			for(int i = 0; i < 3; i++) {
				int n1 = num + dir[i];
				if(n1 < 0 || n1 > 100000)continue;
				
				if(visited[n1] == 1)continue;
				
				
				q.add(new Node(n1, n.depth+1));
				visited[n1] = 1;
			}
			
		}
		
	}
	static class Node{
		int value;
		int depth;
		public Node(int value, int depth) {
			super();
			this.value = value;
			this.depth = depth;
		}
		@Override
		public String toString() {
			return "Node [value=" + value + ", depth=" + depth + "]";
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
