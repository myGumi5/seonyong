import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.*;

public class BJ4179 {
	static int R, C, cnt = 0;
	static char[][] map;
	static int[][] visited1, visited2;
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	static int[] XY = new int[2];
	static ArrayList<Fire> list = new ArrayList<>();
	
	public static void main(String[] args) {
		FastReader sc = new FastReader();
		R = sc.nextInt();
		C = sc.nextInt();
		
		map = new char[R][C];
		visited1 = new int[R][C];
		visited2 = new int[R][C];
		for(int i = 0; i < R; i++) {
			String str = sc.nextLine();
			for(int j = 0; j < C; j++) {
				map[i][j] = str.charAt(j);
				if(map[i][j] == 'J') {
					XY[0] = j;
					XY[1] = i;
				}
				if(map[i][j] == 'F') {
					list.add(new Fire(j, i,0));
				}
			}
		}
		
		bfs();
		if(cnt == 0) System.out.println("IMPOSSIBLE");
		else System.out.println(cnt);
	}	
	
	static void bfs() {
		Queue<Fire> q = new LinkedList<>();
		for(Fire f : list) {
			q.add(f);
			visited1[f.y][f.x] = 1;
		}
		Queue<Person> qp = new LinkedList<>();
		qp.add(new Person(XY[0], XY[1], 0));
		visited2[XY[0]][XY[1]] = 1;
		
		while (!q.isEmpty()) {
			Fire n = q.poll();
			int r = n.y;
			int c = n.x;

			for (int i = 0; i < 4; i++) {
				int ry = r + dy[i];
				int cx = c + dx[i];

				if (ry < 0 || ry >= R || cx < 0 || cx >= C) {
					continue;
				}
				if(visited1[ry][cx] != 0) continue;
				if (map[ry][cx] != '.')
					continue;

				visited1[ry][cx] = n.depth+1;
				q.add(new Fire(cx, ry, n.depth+1));
			}
		}

		while (!qp.isEmpty()) {
			Person n = qp.poll();
			int r = n.y;
			int c = n.x;

			for (int i = 0; i < 4; i++) {
				int ry = r + dy[i];
				int cx = c + dx[i];

				if (ry < 0 || ry >= R || cx < 0 || cx >= C) {
					if(visited1[r][c] == 0) visited1[r][c] = 1001;
					if((visited2[r][c] < visited1[r][c])) {
						cnt = n.depth + 1;
						return;
					}
					else continue;
				}
				if(visited2[ry][cx] != 0) continue;
				if (map[ry][cx] != '.')
					continue;

				visited2[ry][cx] = n.depth + 1;
				qp.add(new Person(cx, ry, n.depth + 1));
			}
		}
		
	}	

	
	static class Fire{
		int x;
		int y;
		int depth;
		public Fire(int x, int y, int depth) {
			super();
			this.x = x;
			this.y = y;
			this.depth = depth;
		}
		@Override
		public String toString() {
			return "Fire [x=" + x + ", y=" + y + "]";
		}
	}
	
	static class Person {
		int x;
		int y;
		int depth;
		public Person(int x, int y, int depth) {
			this.x = x;
			this.y = y;
			this.depth = depth;
		}
		@Override
		public String toString() {
			return "Person [x=" + x + ", y=" + y + ", depth=" + depth + "]";
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
4 4
..#.
.JF#
..##
..#F

*/