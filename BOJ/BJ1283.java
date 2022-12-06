package com.ssafy.algo.live20221206;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BJ1283 {
	static int N;
	static Map<Character, Integer> map;
	static String[][] list;
	static boolean[] visited;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FastReader sc = new FastReader();
		N = sc.nextInt();
		
		map = new HashMap<>();
		list = new String[N][5];
		visited = new boolean[N];
		for(int i = 0; i < N; i++) {
			String str = sc.nextLine();
			list[i] = str.split(" ");
		}
		
		

		for(int i = 0; i < N; i++) {
			StringBuilder sb = new StringBuilder();
			for(int j = 0; j < list[i].length; j++) {
				if(visited[i]) break;
				String str = list[i][j];
				Character ch = str.charAt(0);
				
				if(map.get(Character.toUpperCase(ch)) == null) {
					map.put(Character.toUpperCase(ch), 1);
					sb.append("[").append(ch).append("]").append(str.substring(1, str.length()));
					list[i][j] = sb.toString();
					visited[i] = true;
				}
			}
			if(!visited[i]) {
				StringBuilder sb1 = new StringBuilder();
				for(int j = 0; j < list[i].length; j++) {
					String str = list[i][j];
					if(visited[i]) break;
					for(int z = 1; z < str.length(); z++) {
						Character ch = str.charAt(z);
						if (map.get(Character.toUpperCase(ch)) == null) {
							map.put(Character.toUpperCase(ch), 1);
							sb1.append(str.substring(0, z)).append("[").append(ch).append("]")
									.append(str.substring(z + 1, str.length()));
							list[i][j] = sb1.toString();
							visited[i] = true;
							break;
						}
					}
				}
			}
		}

		StringBuilder sb = new StringBuilder();;
		for(int i = 0; i < N; i++) {
			for(String str : list[i]) {
				sb.append(str).append(" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
		
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
