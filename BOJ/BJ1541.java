package com.ssafy.coding.live20220817;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BJ1541 {
	static String str;
	static int[] visited;
	static LinkedList<String> cal = new LinkedList<>();
	
	public static void main(String[] args) {
		FastReader sc = new FastReader();
		str = sc.nextLine();
		
		StringTokenizer st = new StringTokenizer(str, "-+", true);
		while(st.hasMoreElements()) {
			cal.add(st.nextToken().trim());
		}
		
		System.out.println(cal);
		
		while(cal.size() > 1) {
			for(int i = 0; i < cal.size(); i++) {
				if(cal.get(i).equals("+")) {
					int num1 = Integer.parseInt(cal.get(i-1));
					int num2 = Integer.parseInt(cal.get(i+1));
					
					cal.remove(i-1);
					cal.remove(i-1);
					cal.remove(i-1);					
					
					cal.add(i-1, Integer.toString(num1 + num2));
					i--;
				}
			}
			for(int i = 0; i < cal.size(); i++) {
				if(cal.get(i).equals("-")) {
					int num1 = Integer.parseInt(cal.get(i-1));
					int num2 = Integer.parseInt(cal.get(i+1));
					
					cal.remove(i-1);
					cal.remove(i-1);
					cal.remove(i-1);
					
					
					cal.add(i - 1, Integer.toString(num1 - num2));
					i--;
				}
			}
			
			
		}
		System.out.println(cal.get(0));
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

/*
50-40-40-40-40 
*/
