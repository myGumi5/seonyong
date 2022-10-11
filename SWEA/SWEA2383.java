package com.ssafy.coding.live20221011;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class SWEA2383 {
	static int T, N, ans, a, b;
	static int[][] map;
	static boolean[] visited;
	static ArrayList<Person> list;

	static int[][] one;

	public static void main(String[] args) {
		FastReader sc = new FastReader();
		T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			N = sc.nextInt();

			int cnt = 0;
			ans = Integer.MAX_VALUE;
			list = new ArrayList<>();
			map = new int[N][N];
			one = new int[2][];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = sc.nextInt();
					if (map[i][j] == 1)
						list.add(new Person(i, j, 0, 0));
					if (map[i][j] != 0 && map[i][j] != 1) {
						one[cnt++] = new int[] { i, j, map[i][j] };
					}
				}
			}
			visited = new boolean[list.size()];
			dfs(0);
			System.out.println("#"+t+" "+ans);
		}

	}

	/*
1
5
0 1 1 0 0
0 0 1 0 3
0 1 0 1 0
0 0 0 0 0
1 0 5 0 0

1
5
0 0 1 1 0
0 0 1 0 2
0 0 0 1 0
0 1 0 0 0
1 0 5 0 0
	 */
	static void dfs(int depth) {
		if (depth == list.size()) {
			LinkedList<Person> stair1 = new LinkedList<>();
			LinkedList<Person> stair2 = new LinkedList<>();

			
			
			for (int i = 0; i < list.size(); i++) {
				Person p = list.get(i);

				if (visited[i]) {
					p.time += one[0][2] + 1;
					p.dist = Math.abs(p.y - one[0][0]) + Math.abs(p.x - one[0][1]);
					stair1.add(p);
				} else {
					p.time += one[1][2] + 1;
					p.dist = Math.abs(p.y - one[1][0]) + Math.abs(p.x - one[1][1]);
					stair2.add(p);
				}
			}
//			if(visited[0] && visited[1] && visited[2]&&visited[3] && !visited[4] && !visited[5]) {
//				System.out.println("start");
//			}
			ans = Math.min(ans, getTime(stair1, stair2));

			return;
		}

		// 1번 계단 선택
		visited[depth] = true;
		dfs(depth + 1);

		// 2번 계단 선택
		visited[depth] = false;
		dfs(depth + 1);
	}

	private static int getTime(LinkedList<Person> stair1, LinkedList<Person> stair2) {
		Collections.sort(stair1);
		Collections.sort(stair2);
		
		int time = 0;
		while (!stair1.isEmpty() || !stair2.isEmpty()) {
			time++;
			for (int i = 0; i < stair1.size(); i++) {
				if(i == 3) break;
				Person s1 = stair1.get(i);
				
				if (s1.dist < time) {
					s1.time--;
					if (s1.time == 0) {
						stair1.remove(i);
						i--;
					}
				} else {
					break;
				}

			}

			for (int i = 0; i < stair2.size(); i++) {
				if(i == 3) break;
				Person s2 = stair2.get(i);
				
				if (s2.dist < time) {
					s2.time--;
					if (s2.time == 0) {
						stair2.remove(i);
						i--;
					}
				} else {
					break;
				}
			}
			
		}

		return time;
	}

	static class Person implements Comparable<Person> {
		int y, x, dist, time;

		public Person(int y, int x, int dist, int time) {
			super();
			this.y = y;
			this.x = x;
			this.dist = dist;
			this.time = time;
		}

		@Override
		public String toString() {
			return "Person [y=" + y + ", x=" + x + ", dist=" + dist + ", time=" + time + "]";
		}

		@Override
		public int compareTo(Person o) {
			return this.dist - o.dist;
		}

	}

	static class FastReader {
		BufferedReader br = null;
		StringTokenizer st = null;

		public FastReader() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() {
			while (st == null || !st.hasMoreElements()) {
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
