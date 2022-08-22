package com.ssafy.coding.live20220822;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class SWEA1238 {
	static int N, T, maxDist = Integer.MIN_VALUE, maxNum = Integer.MIN_VALUE;
	static HashMap<Integer, ArrayList<Integer>> map;
	static int [] visited;
	
	public static void main(String[] args) {
		FastReader sc = new FastReader();
		T = 10;
		for(int t = 0; t < T; t++) {
			N = sc.nextInt();
			map = new HashMap<>();
			visited = new int[101];
			maxDist = Integer.MIN_VALUE;
			maxNum = Integer.MIN_VALUE;
			int start = sc.nextInt();
			
			for(int i = 0; i < N / 2; i++) {
				int num1 = sc.nextInt();
				int num2 = sc.nextInt();
				if(map.get(num1) == null) {
					map.put(num1, new ArrayList(Arrays.asList(num2)));
				} else {
					if(map.get(num1).contains(num2)) continue;
					else map.get(num1).add(num2);
 				}
			}
			
			//System.out.println(map);
			
			bfs(start);
			
			for(int i = 1; i <= 100; i++) {
				maxDist = Math.max(maxDist, visited[i]);
			}
			for(int i = 1; i <= 100; i++) {
				if(visited[i] == maxDist) {
					maxNum = Math.max(maxNum, i);
				}
			}
			
			System.out.printf("#%d %d\n", t+1, maxNum);
		}

	}
	static void bfs(int start) {
		Queue<Node> q = new LinkedList<Node>();
		q.add(new Node(start, 1));
		visited[start] = 1;
		
		while(!q.isEmpty()) {
			Node n = q.poll();
			
			if(map.get(n.number) == null) continue;
			for(int num : map.get(n.number)) {
				if(visited[num] >= 1) continue;
				
				visited[num] = n.dist+1;
				q.add(new Node(num, n.dist+1));
			}
			
		}
	}
	
	
	static class Node{
		int number, dist;

		public Node(int number, int dist) {
			super();
			this.number = number;
			this.dist = dist;
		}

		@Override
		public String toString() {
			return "Node [number=" + number + ", dist=" + dist + "]";
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
				}
			}
			return st.nextToken();
		}
		
		char nextChar() {
			return next().charAt(0);
		}
		
		int nextInt() {
			return Integer.parseInt(next());
		}
	}
}
