package com.ssafy.algo.live20221201;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class BJ5397 {
	static int T;
	
	public static void main(String[] args) throws IOException {
		FastReader sc = new FastReader();
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		T = sc.nextInt();
		
		for(int t = 0; t < T; t++) {
			
			LinkedList<Character> list = new LinkedList<>();
			ListIterator<Character> iter = list.listIterator();
			String str = sc.nextLine();
			
			for(int i = 0; i < str.length(); i++) {
				switch (str.charAt(i)) {
				case '<':
					if(iter.hasPrevious()) {
						iter.previous();
					}
					break;
				case '>':
					if(iter.hasNext()) {
						iter.next();
					}
					break;
				case '-':
					if(iter.hasPrevious()) {
						iter.previous();
						iter.remove();
					}
					break;
				default:
					iter.add(str.charAt(i));
					break;
				}
				
			}

			
			for(Character chr : list) {
				bw.write(chr);
			}
			bw.write("\n");
		}
		bw.flush();   //남아있는 데이터를 모두 출력시킴
		bw.close(); 
		
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
