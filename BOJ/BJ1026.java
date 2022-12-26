package com.ssafy.algo.live20221226;

import java.io.*;
import java.util.*;


public class BJ1026 {

	public static void main(String[] args) {
		FastReader sc = new FastReader();
		ArrayList<A> listA = new ArrayList<>();
		ArrayList<B> listB = new ArrayList<>();
		
		int n = sc.nextInt();
		for(int i = 0; i < n ; i++) {
			listA.add(new A(sc.nextInt()));
		}
		for(int i = 0; i < n ; i++) {
			listB.add(new B(sc.nextInt()));
		}
		
		
		Collections.sort(listA);
		Collections.sort(listB);
		
		int total = 0;
		for(int i = 0; i < n ; i++) {
			total += listA.get(i).val * listB.get(i).val;
		}
		
		System.out.println(total);
	}
	
	static class A implements Comparable<A>{
		int val;

		public A(int val) {
			super();
			this.val = val;
		}
		
		@Override
		public int compareTo(A o) {
			// TODO Auto-generated method stub
			return this.val - o.val;
		}



		@Override
		public String toString() {
			return "Node [val=" + val + "]";
		}	
	}
	
	static class B implements Comparable<B>{
		int val;

		public B(int val) {
			super();
			this.val = val;
		}
	

		@Override
		public int compareTo(B o) {
			// TODO Auto-generated method stub
			return o.val - this.val;
		}



		@Override
		public String toString() {
			return "Node [val=" + val + "]";
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
