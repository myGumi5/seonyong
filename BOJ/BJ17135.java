package com.ssafy.coding.live20220819;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BJ17135 {
	static int N, M, D, max = Integer.MIN_VALUE;
	static int [][] map, copy;
	static int[] dy = {0, -1, -1, -1, 0};
	static int[] dx = {-1, -1, 0, 1, 1};
	
	
	public static void main(String[] args) {
		FastReader sc = new FastReader();
		N = sc.nextInt();
		M = sc.nextInt();
		D = sc.nextInt();
		
		map = new int[N+1][M];
		copy = new int[N+1][M];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
				copy[i][j] = map[i][j];
			}
		}

		combiantation(new int[3+1], 1);
		System.out.println(max);
	}
	static void combiantation(int [] com, int depth) {
		if(depth == 3+1) {
			
			
			//System.out.println(Arrays.toString(Arrays.copyOfRange(com, 1, 3+1)));
			map = new int[N+1][M];
			// 턴을 시작하기 앞서 보드판 초기화
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					map[i][j] = copy[i][j];
				}
			}
			
			
			// 조합에 따른 궁수 배치
			for(int i = 1; i <= 3; i++) {
				map[N][com[i]-1] = 9;
			}
			
			int sum = 0;
			while(gameOver()) {
				ArrayList<int[]> list = new ArrayList<>();
				for(int i = 0; i < 3; i++) {
					// 궁수가 저격한 적의 좌표를 저장
					list.add(attack(com[i+1]-1));
				}
				
				// 궁수가 공격한 적을 게임에서 제외시킨다.
				sum += out(list);
				
				// 한턴이 끝나면 적은 아래로 한 칸 이동한다.
				coming();
				
//				for(int i = 0; i <= N; i++) {
//					System.out.println(Arrays.toString(map[i]));
//				}
//				System.out.println();
			}
			
			max = Math.max(max, sum);
			return;
		}
		
		for(int i = com[depth - 1] + 1; i <= M; i++ ) {
			com[depth] = i;
			combiantation(com, depth + 1);
		}
	}
	
	static int out(ArrayList<int[]> list) {
		int cnt = 0;
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i) == null) continue;
			int y = list.get(i)[0];
			int x = list.get(i)[1];
			
			if(map[y][x] == 1) {
				map[y][x] = 0;
				cnt++;
			}
		}
		return cnt;
	}
	static void coming() {
		int [][] sub = new int[N][M];
		
		for(int i = 1; i < N; i++) {
			for(int j = 0; j < M; j++) {
				sub[i][j] = map[i-1][j];
			}
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				map[i][j] = sub[i][j];
			}
		}
	}
	static int[] attack(int no) {
		int[] coor = new int[2];
		PriorityQueue<Node> q = new PriorityQueue<>((o1, o2) -> {
			if(o1.dis == o2.dis) return o1.x - o2.x;
			else return o1.dis - o2.dis;
				});
		int [][] visited = new int [N+1][M];
		q.add(new Node(N, no, 0));
		
		while(!q.isEmpty()) {
			Node n = q.poll();
			int r = n.y;
			int c = n.x;
			visited[r][c] = 1;
			if(map[r][c] == 1) {
				coor[0] = r;
				coor[1] = c;
				return coor;
			}
			
			for(int i = 0; i < 5; i++) {
				int ry = r + dy[i];
				int cx = c + dx[i];
				
				if(ry < 0 || cx < 0 || ry >= N || cx >= M) continue;
				if(visited[ry][cx] == 1)continue;
				if(Math.abs(N - ry) + Math.abs(no - cx) > D) continue;
				
				
				q.add(new Node(ry, cx, Math.abs(N - ry) + Math.abs(no - cx)));
				
			}
		}
		
		
		return null;
	}
	static boolean gameOver() {
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(map[i][j] == 1) return true;
			}
		}
		return false;
	}
	static class Node{
		int y; int x; int dis;


		public Node(int y, int x, int dis) {
			super();
			this.y = y;
			this.x = x;
			this.dis = dis;
		}


		@Override
		public String toString() {
			return "Node [y=" + y + ", x=" + x + ", dis=" + dis + "]";
		}
		
		
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
		
		int nextInt() {
			return Integer.parseInt(next());
		}
	}
}
/*

3 4 2
0 0 0 0
0 0 0 0
1 0 1 1

*/