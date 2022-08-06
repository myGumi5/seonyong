package com.ssafy.coding.BJ20220806;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ2493 {

	public static void main(String[] args) {
		FastReader sc = new FastReader();
		
		int N = sc.nextInt();
		Stack<int []> s = new Stack<>();
		
		for(int i = 1; i <= N; i++) {
			int num = sc.nextInt();
			
			while(!s.isEmpty()) {
				if(s.peek()[0] > num) {
					System.out.print(s.peek()[1] + " ");
					break;
				}
				s.pop();
			}
			
			if(s.empty()) {
				System.out.print("0 ");
			}
			
			s.push(new int[] {num, i});
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
