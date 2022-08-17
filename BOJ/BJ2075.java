package com.ssafy.coding.live20220817;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BJ2075 {
	static int N;
	static PriorityQueue<Integer> pq = new PriorityQueue<>();
	public static void main(String[] args) {
		FastReader sc = new FastReader();
		N = sc.nextInt();
		
		for(int i = 0; i < N * N; i++) {
			pq.add(sc.nextInt());
			if(pq.size() > N) {
				pq.poll();
			}
		}
		
		System.out.println(pq.poll());
		
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
