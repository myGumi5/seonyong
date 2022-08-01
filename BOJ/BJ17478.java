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

		sb1.append("\"����Լ��� ������?\"");
		sb2.append("\"�� ����. �������� �� �� ����⿡ �̼��� ��� ������ ����� ������ �־���.");
		sb3.append("���� ������� ��� �� ���ο��� ������ ������ �߰�, ��� �����Ӱ� ����� �־���.");
		sb4.append("���� ���� ��κ� �ǾҴٰ� �ϳ�. �׷��� ��� ��, �� ���ο��� �� ���� ã�ƿͼ� ������.\"");
		
		N = sc.nextInt();
		System.out.println("��� �� ��ǻ�Ͱ��а� �л��� ������ �������� ã�ư� ������.");
		rec(0);
		
	}
	static void rec(int num) {
		if(num == N) {
			System.out.println(sb+sb1.toString());
			System.out.println(sb+"\"����Լ��� �ڱ� �ڽ��� ȣ���ϴ� �Լ����\"");
			System.out.println(sb + "��� �亯�Ͽ���.");
			sb.delete(0, 4);
			return;
		}
		
		System.out.println(sb+sb1.toString());
		System.out.println(sb+sb2.toString());
		System.out.println(sb+sb3.toString());
		System.out.println(sb+sb4.toString());
		sb.append("____");
		
		rec(num+1);
		
		System.out.println(sb + "��� �亯�Ͽ���.");
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
