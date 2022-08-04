package com.ssafy.coding.BJ20220803;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class BJ14891 {
	static LinkedList<Integer> [] arr;
	static HashMap<Integer, ArrayList<Integer>> map;
	static int[][] rotation;
	static int [] visited;
	static int K, sum;	
	
	public static void main(String[] args) {

		input();
		
		
		for(int i = 1; i <= K; i++) {
			map  = new HashMap<>();
			visited = new int[4+1];
			whoNeedRotation();

			dfs(rotation[i][1], rotation[i][2]);
				
		}
		
		getPoint();
		
		System.out.println(sum);
		
	}
	static void dfs(int num, int dir) {
		if(visited[num] == 1) return;
		rotation(num, dir);
		visited[num] = 1;
		
		if(map.get(num) == null) return;
		for(int i : map.get(num)) {
			dfs(i, dir * -1);
		}
	}
	
	static void whoNeedRotation() {
		if(arr[1].get(2) != arr[2].get(6)) {
			if(map.get(1) == null) {
				map.put(1, new ArrayList<>(Arrays.asList(2)));
			} else {
				map.get(1).add(2);
			}
			if(map.get(2) == null) {
				map.put(2, new ArrayList<>(Arrays.asList(1)));
			} else {
				map.get(2).add(1);
			}
		}
		if(arr[2].get(2) != arr[3].get(6)) {
			if(map.get(2) == null) {
				map.put(2, new ArrayList<>(Arrays.asList(3)));
			} else {
				map.get(2).add(3);
			}
			if(map.get(3) == null) {
				map.put(3, new ArrayList<>(Arrays.asList(2)));
			} else {
				map.get(3).add(2);
			}
		}
		if(arr[3].get(2) != arr[4].get(6)) {
			if(map.get(3) == null) {
				map.put(3, new ArrayList<>(Arrays.asList(4)));
			} else {
				map.get(3).add(4);
			}
			if(map.get(4) == null) {
				map.put(4, new ArrayList<>(Arrays.asList(3)));
			} else {
				map.get(4).add(3);
			}
		}
		
	}
	
	static void rotation(int num, int dir) {
		if (dir == -1) {
			int a = arr[num].remove(0);
			arr[num].add(a);
		} else {
			int a = arr[num].remove(arr[num].size() - 1);
			arr[num].add(0, a);
		}
	}
	
	static void getPoint() {
		sum = 0;
		for(int i = 1; i <= 4; i++) {
			if(arr[i].get(0) == 1)
				sum += Math.pow(2, i-1);
		}
	}
	
	static void input() {
		FastReader sc = new FastReader();
		
		arr = new LinkedList[5];
		for(int i = 1; i <= 4; i++) {
			arr[i] = new LinkedList<>();
			String str = sc.nextLine();
			for(int j = 1; j <= str.length(); j++) {
				arr[i].add(str.charAt(j-1) - 48);
			}
		}
		
		K = sc.nextInt();
		
		rotation = new int[K+1][3];
		for(int i = 1; i <= K; i++) {
			for(int j = 1; j <= 2; j++) {
				rotation[i][j] = sc.nextInt();
			}
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
		
		String nextLine() {
			try {
				return br.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return "";
		}
	}
}
