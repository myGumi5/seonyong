package com.ssafy.coding.live20220819;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class BJ2644 {
	static int N;
	static int node1, node2;
	static int M;
	static int[] visited;
	
	static HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();  
	
	public static void main(String[] args) {
		FastReader sc = new FastReader();
		N = sc.nextInt();
		node1 = sc.nextInt();
		node2 = sc.nextInt();
		M = sc.nextInt();
		
		visited = new int[N+1];
		for(int i = 0; i < M; i++) {
			int num1 = sc.nextInt();
			int num2 = sc.nextInt();
			
			if(graph.get(num1) == null) {
				graph.put(num1, new ArrayList(Arrays.asList(num2)));
			} else {
				graph.get(num1).add(num2);
			}
			
			if(graph.get(num2) == null) {
				graph.put(num2, new ArrayList(Arrays.asList(num1)));
			} else {
				graph.get(num2).add(num1);
			}
		}
		
		dfs();
		
	}
	
	static void dfs() {
		LinkedList<Node> l = new LinkedList<>();
		l.add(new Node(node1, 0));
		visited[node1] = 1;
		
		while(!l.isEmpty()) {
			Node n = l.poll();
			int val = n.value;
			if(val == node2) {
				System.out.println(n.dist);
				return;
			}
			
			if(graph.get(val) == null) continue;
			for(int next : graph.get(val)) {
				if(visited[next] == 1) continue;
				visited[next] = 1;
				l.add(0, new Node(next, n.dist+1));
			}
			
		}
		
		System.out.println(-1);
	}
	static class Node{
		int value; int dist;


		public Node(int value, int dist) {
			super();
			this.value = value;
			this.dist = dist;
		}


		@Override
		public String toString() {
			return "Node [value=" + value + ", dist=" + dist + "]";
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
		
		String nextLine() {
			String str = null;
			try {
				str = br.readLine();
			} catch (Exception e) {
				// TODO: handle exception
			}
			return str;
		}
	}
}
