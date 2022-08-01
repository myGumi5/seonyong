package com.ssafy.BJ20220801.conding;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ17478 {
	static int N;
	
	static StringBuilder sb = new StringBuilder();
	static StringBuilder sb1 = new StringBuilder();
	static StringBuilder sb2 = new StringBuilder();
	static StringBuilder sb3 = new StringBuilder();
	static StringBuilder sb4 = new StringBuilder();
	public static void main(String[] args) {
		FastReader sc = new FastReader();

		sb1.append("\"재귀함수가 뭔가요?\"");
		sb2.append("\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.");
		sb3.append("마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.");
		sb4.append("그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"");
		
		N = sc.nextInt();
		System.out.println("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.");
		rec(0);
		
	}
	static void rec(int num) {
		if(num == N) {
			System.out.println(sb+sb1.toString());
			System.out.println(sb+"\"재귀함수는 자기 자신을 호출하는 함수라네\"");
			System.out.println(sb + "라고 답변하였지.");
			sb.delete(0, 4);
			return;
		}
		
		System.out.println(sb+sb1.toString());
		System.out.println(sb+sb2.toString());
		System.out.println(sb+sb3.toString());
		System.out.println(sb+sb4.toString());
		sb.append("____");
		
		rec(num+1);
		
		System.out.println(sb + "라고 답변하였지.");
		sb.delete(0, 4);
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
