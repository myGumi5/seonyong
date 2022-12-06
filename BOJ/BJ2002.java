package com.ssafy.algo.live20221206;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BJ2002 {
	static int N;
	static LinkedList<String> start, end;
	
	
	public static void main(String[] args) {
		FastReader sc = new FastReader();
		N = sc.nextInt();
		
		start = new LinkedList<>();
		end = new LinkedList<>();
		for(int i = 0; i < N; i++) {
			start.add(sc.nextLine());
		}
		for(int i = 0; i < N; i++) {
			end.add(sc.nextLine());
		}
		
		int ans = 0;
		int sp = 0, ep = 0;
		while(ep < end.size()) {
			sp = 0;
			if(start.get(sp).equals(end.get(ep))) {
				start.remove(sp);
				ep++;
			} else {
				ans++;
				for(int i = ++sp; i < start.size(); i++) {
					if(start.get(i).equals(end.get(ep))) {
						start.remove(i);
						break;
					}
				}
				ep++;
			}
		}
		
		System.out.println(ans);
		
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
