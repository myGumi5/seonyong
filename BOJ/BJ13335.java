package com.ssafy.coding.live20220821;

import java.io.*;
import java.util.*;


public class BJ13335 {
	static int N, W, L;
	static Queue<Truck> wait;
	static Queue<Truck> bridge;
	
	public static void main(String[] args) {
		FastReader sc = new FastReader();
		N = sc.nextInt();
		W = sc.nextInt();
		L = sc.nextInt();
		
		wait = new LinkedList<>();
		bridge = new LinkedList<>();
		for(int i = 0; i < N; i++) {
			wait.add(new Truck(0, sc.nextInt()));
		}
		// input process
		
		
		pro();

	}
	
	static void pro() {
// 매 초 마다 단위시간 증가
		int time = 0;
		while(!wait.isEmpty() || !bridge.isEmpty()) {
		// 다리 위에 있는 트럭들을 이동시킨다.	
			go();
		// 다 지나간 트럭 삭제
			end();
		//	트럭을 다리 위로 올린다
			Bridge();
			time++;
		}
		
		System.out.println(time);
	}
	
	
	private static void end() {
		int len = bridge.size();
		for(int i = 0; i < len; i++) {
			Truck t = bridge.poll();
			if(t.km <= W) {
				bridge.add(t);
			}
		}
		
	}

	private static void go() {
		int len = bridge.size();
		for(int i = 0; i < len; i++) {
			Truck t = bridge.poll();
			t.km += 1;
			bridge.add(t);
		}
		
	}

	private static void Bridge() {
		if(wait.isEmpty()) return;
		
		Truck t = wait.peek();
		int sum = t.kg;
		int len = bridge.size();
		for(int i = 0; i < len; i++) {
			Truck sub = bridge.poll();
			sum += sub.kg;
			bridge.add(sub);
		}
		
		if(sum <= L) {
			t.km += 1; 
			bridge.add(t);
			wait.poll();
		}
		
	}


	static class Truck{
		int km, kg;

		public Truck(int km, int kg) {
			super();
			this.km = km;
			this.kg = kg;
		}

		@Override
		public String toString() {
			return "Truck [km=" + km + ", kg=" + kg + "]";
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
					// TODO: handle exception
				}
			}
			return st.nextToken();
		}
		
		int nextInt() {
			return Integer.parseInt(next());
		}
		
	}

}
