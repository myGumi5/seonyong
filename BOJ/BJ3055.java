import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.*;

public class BJ3055 {
	static int R, C, Sx, Sy, Dx, Dy;
	static Queue<Integer> list = new LinkedList<>();
	static char[][] map;
	static int[][] visited1, visited2;
	
	static int[] dy = {0,0,1,-1};
	static int[] dx = {1,-1,0,0};
	
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
				if(map[i][j] == '*') {
					list.add(i);
					list.add(j);
				}
				if(map[i][j] == 'S') {
					Sy = i;
					Sx = j;
				}
				if(map[i][j] == 'D') {
					Dy = i;
					Dx = j;
				}
			}
		}
		
		bfs();
		
		for(int i = 0; i < R; i++) {
			System.out.println(Arrays.toString(visited1[i]));
		}
		System.out.println();
		for(int i = 0; i < R; i++) {
			System.out.println(Arrays.toString(visited2[i]));
		}
		System.out.println();
		
		if(visited2[Dy][Dx] >= 1) {
			System.out.println(visited2[Dy][Dx] - 1);
		} else {
			System.out.println("KAKTUS");
		}
	}
	static void bfs() {
		Queue<Node> q = new LinkedList<>();
		while(!list.isEmpty()) {
			int r = list.poll();
			int c = list.poll();
			q.add(new Node(r, c, 1));
			visited1[r][c] = 1;
		}

		// 물부터 퍼트린다.
		while (!q.isEmpty()) {
			Node node = q.poll();

			for (int i = 0; i < 4; i++) {
				int r = node.y + dy[i];
				int c = node.x + dx[i];

				if (r < 0 || r >= R || c < 0 || c >= C)
					continue;
				if (visited1[r][c] >= 1)
					continue;
				if (map[r][c] == 'X')
					continue;
				if(map[r][c] == 'D') continue;

				q.add(new Node(r, c, node.dist + 1));
				visited1[r][c] = node.dist+1;
			}
		}

		q = new LinkedList<>();
		q.add(new Node(Sy, Sx, 1));
		visited2[Sy][Sx] = 1;

		// 다음 고슴도치 퍼트린다.
		while (!q.isEmpty()) {
			Node node = q.poll();
			for (int i = 0; i < 4; i++) {
				int r = node.y + dy[i];
				int c = node.x + dx[i];

				if (r < 0 || r >= R || c < 0 || c >= C) continue;
				if (visited2[r][c] >= 1) continue;
				if(map[r][c] == 'X') continue;
				if (visited1[r][c] != 0 && visited1[r][c] <= node.dist +1) continue;
					
				q.add(new Node(r, c, node.dist + 1));
				visited2[r][c] = node.dist + 1;
			}
		}
	}

	static class Node{
		int y, x, dist;

		public Node(int y, int x, int dist) {
			super();
			this.y = y;
			this.x = x;
			this.dist = dist;
		}

		@Override
		public String toString() {
			return "Node [y=" + y + ", x=" + x + ", dist=" + dist + "]";
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
				// TODO: handle exception
			}
			return str;
		}
		
	}
}
