package com.ssafy.algo.live20220930;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BJ12101 {
	static int N, K, cnt = 0;
	static String[] dp;
	public static void main(String[] args) {
		FastReader sc = new FastReader();
		N = sc.nextInt();
		K = sc.nextInt();
		
		dfs(0, "");
		if(cnt < K) System.out.println(-1);
	}
	static void dfs(int num, String str) {
		if(num > N) {
			return;
		}
		if(num == N) {
			cnt++;
			if(cnt == K) {
				StringBuilder sb = new StringBuilder();
				for(int i = 0; i < str.length(); i++) {
					sb.append(str.charAt(i));
					if(i == str.length()-1) break;
					sb.append("+");
				}
				
				System.out.println(sb.toString());
			}
			return;
		}
		
		dfs(num + 1, str + "1");
		dfs(num + 2, str + "2");
		dfs(num + 3, str + "3");
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
