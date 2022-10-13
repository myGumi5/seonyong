package com.ssafy.coding.live20221013;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA5650 {
	static int T, N, ans;
	static int[][] map;
	
	static int[] dy = {99, -1, 1, 0, 0};
	static int[] dx = {99, 0, 0, -1, 1};
	
	static HashMap<Integer, ArrayList<int[]>> worm;

	public static void main(String[] args) {
		FastReader sc = new FastReader();
		T = sc.nextInt();
		
		for(int t = 1; t <= T; t++) {
			N = sc.nextInt();
			ans = Integer.MIN_VALUE;
			worm = new HashMap<>();
			
			map = new int[N][N];
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					map[i][j] = sc.nextInt();
					if(map[i][j] >= 6) {
						if(worm.get(map[i][j]) == null) {
							worm.put(map[i][j], new ArrayList<int[]>(Arrays.asList(new int[] {i, j})));
						} else {
							worm.get(map[i][j]).add(new int[] {i, j});
						}
					}
				}
			}
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(map[i][j] == 0) {
						for(int d = 1; d <= 4; d++) {
							bfs(i, j, d);
						}
					}
				}
			}
			
//			Ball b = new Ball(5 ,0 , 0, 2);
//			b.d = block(b.d, b.y, b.x);
//			System.out.println(b.d);
			
			
			System.out.println("#"+t+" "+ans);
		}
		
	}
	
	static void bfs(int i, int j, int dir) {
		Queue<Ball> q = new LinkedList<>();
		q.add(new Ball(i, j, 0, dir));
		
		
		while(!q.isEmpty()) {
			Ball b = q.poll();
			b.y += dy[b.d];
			b.x += dx[b.d];
			
			if(b.y < 0 || b.y >= N || b.x < 0 || b.x >= N) {
				int d = wall(b.d, b.y, b.x);
				if(d != b.d) {
					q.add(new Ball(b.y, b.x, b.s+1, d));
				} else {
					q.add(new Ball(b.y, b.x, b.s, b.d));
				}
				continue;
			}
			
			if((b.y == i && b.x == j)) {
				ans = Math.max(ans, b.s);
				continue;
			}
			
			if(map[b.y][b.x] == -1) {
				ans = Math.max(ans, b.s);
				continue;
			}
			
			if(map[b.y][b.x] >= 1 && map[b.y][b.x] <= 5) {
				b.d = block(b.d, b.y, b.x);
				q.add(new Ball(b.y, b.x, b.s+1, b.d));
				continue;
			}
			
			if(map[b.y][b.x] >= 6) {
				worm(b);
				q.add(new Ball(b.y, b.x, b.s, b.d));
				continue;
			}
			

			int d = wall(b.d, b.y, b.x);
			if(d != b.d) {
				q.add(new Ball(b.y, b.x, b.s+1, d));
			} else {
				q.add(new Ball(b.y, b.x, b.s, b.d));
			}
		}
	}

	private static void worm(Ball b) {
		for(int[] list : worm.get(map[b.y][b.x])) {
			if(list[0] == b.y && list[1] == b.x) continue;
			else {
				b.y = list[0];
				b.x = list[1];
				break;
			}
 		}
		
	}

	private static int block(int d, int y, int x) {
		if(d == 1) {
			if(map[y][x] == 2) {
				return 4;
			} else if(map[y][x] == 3) {
				return 3;
			} else {
				return 2;
			}
		} else if(d == 2) {
			if(map[y][x] == 1) {
				return 4;
			} else if(map[y][x] == 4) {
				return 3;
			} else {
				return 1;
			}
		} else if(d == 3) {
			if(map[y][x] == 1) {
				return 1;
			} else if(map[y][x] == 2) {
				return 2;
			} else {
				return 4;
			}
		} else {
			if(map[y][x] == 3) {
				return 2;
			} else if(map[y][x] == 4) {
				return 1;
			} else {
				return 3;
			}
		}
	}

	private static int wall(int d, int y, int x) {
		if(d == 1  && y <= 0) {
			return 2;
		}
		if(d == 2 && y >= N - 1) {
			return 1;
		}
		if(d == 3  && x <= 0) {
			return 4;
		}
		if(d == 4 && x >= N-1) {
			return 3;
		}
		
		return d;
	}

	static class Ball{
		int y, x, s, d;

		public Ball(int y, int x, int s, int d) {
			super();
			this.y = y;
			this.x = x;
			this.s = s;
			this.d = d;
		}

		@Override
		public String toString() {
			return "ball [y=" + y + ", x=" + x + ", s=" + s + ", d=" + d + "]";
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
	}
}
