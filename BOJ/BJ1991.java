package com.ssafy.coding.BJ20220728;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BJ1991 {
	static int N;
	static HashMap<Character, ArrayList<Character>> map = new HashMap<>();
	
	public static void main(String[] args) {
		FastReader sc = new FastReader();
		N = sc.nextInt();
		
		for(int i = 0; i < N; i++) {
			char c1 = sc.nextChar();
			char c2 = sc.nextChar();
			char c3 = sc.nextChar();
			
			map.put(c1, new ArrayList<Character>(Arrays.asList(c2, c3)));
			
		}
	
		pre();
		System.out.println();
		mid('A');
		System.out.println();
		tail('A');
	}
	static void pre() {
		char start = 'A';
		
		LinkedList<Character> q = new LinkedList<>();
		q.add(start);
		
		while(!q.isEmpty()) {
			char node = q.remove(0);
			
			System.out.printf("%c", node);
			for(int i = 1; i >= 0; i--) {
				if(map.get(node) == null) continue;
				if(map.get(node).get(i) != '.')
					q.add(0, map.get(node).get(i));
			}
		}
		
	}
	
	static void mid(char node) {
		if(map.get(node) == null) return;
		mid(map.get(node).get(0));
		System.out.print(node);
		mid(map.get(node).get(1));
	}
	
	static void tail(char node) {
		for(int i = 0; i < 2; i++) {
			if(map.get(node) == null) continue;
			if(map.get(node).get(i) != '.')
				tail(map.get(node).get(i));
		}
		System.out.printf("%c", node);
		
	}
	
	static class FastReader{
		BufferedReader br;
		StringTokenizer st;
		
		public FastReader(){
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
		
		char nextChar() {
			return next().charAt(0);
		}
	}
}
