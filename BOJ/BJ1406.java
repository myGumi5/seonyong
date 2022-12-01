package com.ssafy.algo.live20221201;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class BJ1406 {
	static int n = 0;
	static LinkedList<Character> list;
	static ListIterator<Character>  iter;
	public static void main(String[] args) throws IOException {
		FastReader sc = new FastReader();
		String str = sc.nextLine();

		list = new LinkedList<>();
		for(int i = 0; i < str.length(); i++) {
			list.add(str.charAt(i));
		}
		
		n = sc.nextInt();	
		
		iter = list.listIterator();
		while(iter.hasNext()) {
			iter.next();
		}
//		System.out.println(Arrays.toString(arr));
		for(int i = 0; i < n; i++) {
			str = sc.nextLine();
			switch (str.charAt(0)) {
			case 'L':
				if(iter.hasPrevious())
					iter.previous();
				break;
			case 'D':
				if(iter.hasNext())
					iter.next();
				break;
			case 'B':
				delete();
				break;
			default:
				insert(str.charAt(2));
				break;
			}
		}
		
//		System.out.println(list);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for(Character chr : list) {
			bw.write(chr);
		}
		bw.flush();   //남아있는 데이터를 모두 출력시킴
		bw.close(); 
	}
	
	
	private static void insert(char ch) {
		iter.add(ch);
	}

	private static void delete() {
		if(iter.hasPrevious()) {
			iter.previous();
			iter.remove();
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
