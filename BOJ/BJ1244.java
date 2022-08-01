package com.ssafy.BJ20220801.conding;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ1244 {
	static int Len, Cnt;
	static int[] btn;
	static ArrayList<Integer> G = new ArrayList<>(), M = new ArrayList<>();
	static ArrayList<int[]> student = new ArrayList<>();
	
	public static void main(String[] args) {
		FastReader sc = new FastReader();
		Len = sc.nextInt();
		
		btn = new int[Len + 1];
		for(int i = 1; i <= Len; i++) {
			btn[i] = sc.nextInt();
		}
		
		Cnt = sc.nextInt();
		for(int i = 0; i < Cnt; i++) {
			int [] info = new int[2];
			info[0] = sc.nextInt();
			info[1] = sc.nextInt();
			
			student.add(info);
		}
			
		selectSwitch();
		
		int c = 1;
		for(int i = 1; i <= Len; i++) {			
			System.out.print(btn[i]+" ");
			if(c == 20) {
				System.out.println();
				c = 0;
			}
			c++;
		}
/*		
[0, 0, 1, 0, 1, 0, 0, 0, 1]
[0, 0, 1, 1, 1, 0, 1, 0, 1]
 */
	}
	
	static void selectSwitch() {
		for(int i = 0; i < Cnt; i++) {
			if(student.get(i)[0] == 1) {
				int n = 1;
				int num = student.get(i)[1];
				while (num * n <= Len) {
					if (btn[num * n] == 1) {
						btn[num * n] = 0;
					} else {
						btn[num * n] = 1;
					}
					n++;
				}
			} else {
				int n = 0;
				int num = student.get(i)[1];
				while(num + n <= Len && num - n > 0) {
					if(btn[num+n] == btn[num - n]) {
						if(btn[num+n] == 1) {
							btn[num+n] = 0;
							btn[num-n] = 0;
						} else {
							btn[num+n] = 1;
							btn[num-n] = 1;
						}
					} else {
						break;
					}
					n++;
				}
			}
		}
	}

	static class FastReader{
		BufferedReader br = null;
		StringTokenizer st = null;
		
		public FastReader() {
			try {
				br = new BufferedReader(new InputStreamReader(System.in));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		String next() {
			while(st ==  null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				}catch (Exception e) {
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
