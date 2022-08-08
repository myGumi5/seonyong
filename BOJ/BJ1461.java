package com.ssafy.coding.BJ20220806;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BJ1461 {
	static int N, K, min = Integer.MIN_VALUE;

	static LinkedList<Integer> pos = new LinkedList<>();
	static LinkedList<Integer> neg = new LinkedList<>();
	
	
	public static void main(String[] args) {
		FastReader sc = new FastReader();
		N = sc.nextInt();
		K = sc.nextInt();
		
		for(int i = 0; i < N; i++) {
			int num = sc.nextInt();
			if(num < 0) {
				neg.add(num);
			} else {
				pos.add(num);
			}
		}
		
		Collections.sort(pos, (o1, o2)-> -(o1-o2));
		Collections.sort(neg, (o1, o2)-> -(Math.abs(o1)-Math.abs(o2)));
	
		int sum = 0;
		int max =0;
		if(neg.isEmpty() || pos.isEmpty()) {
			if(pos.isEmpty())
				max = Math.abs(neg.get(0));
			else
				max =  pos.get(0);
		}else if(Math.abs(neg.get(0)) > pos.get(0)){
			max = Math.abs(neg.get(0));
			while(!pos.isEmpty()) {
				int num = pos.get(0);
				for(int i = 0; i < K; i++) {
					if(pos.size() == 0) break;
					pos.remove(0);
				}
				sum += num * 2;
			}
		} else {
			max =  pos.get(0);
			while(!neg.isEmpty()) {
				int num = Math.abs(neg.get(0));
				for(int i = 0; i < K; i++) {
					if(neg.size() == 0) break;
					neg.remove(0);
				}
				sum += num * 2;
			}
		}
		
		if(neg.isEmpty()) {
			while(!pos.isEmpty()) {
				int num = pos.get(0);
				for(int i = 0; i < K; i++) {
					if(pos.size() == 0) break;
					pos.remove(0);
				}
				sum += num * 2;
				if(pos.isEmpty()) {
					sum -= max;
				}
			}
		} else {
			while(!neg.isEmpty()) {
				int num = Math.abs(neg.get(0));
				for(int i = 0; i < K; i++) {
					if(neg.size() == 0) break;
					neg.remove(0);
				}
				sum += num * 2;
				if(neg.isEmpty()) {
					sum -= max;
				}
			}
		}
		
		System.out.println(sum);
	
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
