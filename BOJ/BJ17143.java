package com.ssafy.coding.live20221010;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class BJ17143 {
	static int R, C, M, pc = 0, ans = 0;
	static Node[][] map;
	
	static int[] dy = {99, -1, 1, 0, 0};
	static int[] dx = {99, 0, 0, 1, -1};
	
	public static void main(String[] args) {
		FastReader sc = new FastReader();
		
		R = sc.nextInt();
		C = sc.nextInt();
		M = sc.nextInt();
		
		map = new Node[R+1][C+1];
		for(int i = 1; i <= M; i++) {
			int r = sc.nextInt();
			int c = sc.nextInt();
			
			map[r][c] = new Node(sc.nextInt(), sc.nextInt(), sc.nextInt());
		}

//		fishing();
//		for(int i = 1; i <= R; i++) {
//			System.out.println(Arrays.toString(Arrays.copyOfRange(map[i], 1, C+1)));
//		}System.out.println();
//		pc++;
//		fishing();
//		for(int i = 1; i <= R; i++) {
//			System.out.println(Arrays.toString(Arrays.copyOfRange(map[i], 1, C+1)));
//		}
//		System.out.println();
//		move();
//		for(int i = 1; i <= R; i++) {
//			System.out.println(Arrays.toString(Arrays.copyOfRange(map[i], 1, C+1)));
//		}
		 pro();
	}
	
	static void pro() {
		while(pc < C) {
			pc++;
			// 상어 낚시
			fishing();
			
			// 상어 이동
			move();
		}
		
		System.out.println(ans);
	}
	
	private static void move() {
		Node[][] sub = new Node[R+1][C+1];
		
		for(int i = 1; i <= R; i++) {
			for(int j = 1; j <= C; j++) {
				if(map[i][j] != null) {
					Node n = map[i][j];
					int mv = 0;
					int r = i, c = j;
					if(n.d == 1 || n.d == 2) {
						mv = n.s % ((R*2)-2);
						for(int z = 0; z < mv; z++) {
							if(n.d == 1 && r == 1) n.d = direct(n.d);
							if(n.d == 2 && r == R) n.d = direct(n.d);
							r += dy[n.d];
							c += dx[n.d];
						}
					}
					else {
						mv = n.s % ((C*2)-2);
						for(int z = 0; z < mv; z++) {
							if(n.d == 4 && c == 1 ) n.d = direct(n.d);
							if(n.d == 3 && c == C) n.d = direct(n.d);
							r += dy[n.d];
							c += dx[n.d];
						}
					}
					
					
					if(sub[r][c] != null) {
						if(sub[r][c].z < n.z) {
							sub[r][c] = n;
						}
					} else {
						sub[r][c] = n;
					}
				}
			}
		}
		
		for(int i = 1; i <= R; i++) {
			for(int j = 1; j <= C; j++) {
				map[i][j] = sub[i][j];
			}
		}
		
	}

	private static int direct(int d) {
		if(d == 1) {
			return 2;
		} else if(d == 2) {
			return 1;
		} else if(d == 3) {
			return 4;
		} else {
			return 3;
		}

	}

	private static void fishing() {
		for(int i = 1; i <= R; i++) {
			if(map[i][pc] != null) {
				ans += map[i][pc].z;
				//System.out.println("catch : "+map[i][pc]);
				map[i][pc] = null;
				break;
			}
		}
		
	}

	static class Node{
		int s, d, z;

		public Node(int s, int d, int z) {
			super();
			this.s = s;
			this.d = d;
			this.z = z;
		}

		@Override
		public String toString() {
			return "[z=" + z + "]";
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
				} catch (IOException e) {
					// TODO Auto-generated catch block
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
