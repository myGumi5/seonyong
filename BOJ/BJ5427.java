import java.io.*;
import java.util.*;

public class BJ5427 {
	static int T, N, M, cnt;
	static char[][] map;
	static int[][] visited1, visited2;
	
	static ArrayList<int []> list = new ArrayList<>();
	static int [] minsu;
	
	
	static int [] dy = {0, 1, 0, -1};
	static int [] dx = {1, 0, -1, 0};
	
	public static void main(String[] args) {
		FastReader sc = new FastReader();
		T = sc.nextInt();
		
		for(int t = 0; t < T; t++) {
			N = sc.nextInt();
			M = sc.nextInt();
			
			cnt = 0;
			list = new ArrayList<>();
			visited1 = new int [M][N];
			visited2 = new int [M][N];
			minsu = new int[2];
			map = new char[M][N];
			for(int i = 0; i < M; i++) {
				String str = sc.nextLine();
				for(int j = 0; j < N; j++) {
					map[i][j] = str.charAt(j);
					if(map[i][j] == '*') {
						list.add(new int[] {i,j});
					} else if(map[i][j] == '@') {
						minsu[0] = i;
						minsu[1] = j;
					}
				}
			}
			
			bfs();
			
			
//			for(int i = 0; i < M; i++) {
//				System.out.println(Arrays.toString(visited1[i]));
//			}
//			System.out.println();
//			for(int i = 0; i < M; i++) {
//				System.out.println(Arrays.toString(visited2[i]));
//			}
//			System.out.println();
			
			if(cnt == 0) System.out.println("IMPOSSIBLE");
			else System.out.println(cnt);
		}
		
	}
	static void bfs() {
		Queue<Node> q = new LinkedList<>();
		for(int i = 0; i < list.size(); i++) {
			q.add(new Node(list.get(i)[0], list.get(i)[1], 1));
			visited1[list.get(i)[0]][list.get(i)[1]] = 1;
		}
		
		while(!q.isEmpty()) {
			Node n = q.poll();
			
			for(int i = 0; i < 4; i++) {
				int r = n.y + dy[i];
				int c = n.x + dx[i];
				
				if(r < 0 || r >= M || c < 0 || c >= N) continue;
				if(map[r][c] == '#') continue;
				if(visited1[r][c] >= 1) continue;
				
				visited1[r][c] = n.dist + 1;
				q.add(new Node(r, c, n.dist + 1));
			}
		}
		
		q = new LinkedList<>();
		q.add(new Node(minsu[0], minsu[1], 1));
		visited2[minsu[0]][minsu[1]] = 1;
		
		while(!q.isEmpty()) {
			Node n = q.poll();
			
			for(int i = 0; i < 4; i++) {
				int r = n.y + dy[i];
				int c = n.x + dx[i];
				
				if(r < 0 || r >= M || c < 0 || c >= N) {			
					if(visited1[n.y][n.x] == 0)visited1[n.y][n.x] = Integer.MAX_VALUE;
					if((visited2[n.y][n.x] < visited1[n.y][n.x])) {
						cnt = n.dist;
						return;
					} else continue;
				}
				if(map[r][c] != '.') continue;
				if(visited2[r][c] >= 1) continue;
				
				
				visited2[r][c] = n.dist + 1;
				q.add(new Node(r, c, n.dist + 1));
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
					// TODO: handle exception
				}
			}
			
			return st.nextToken();
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
		
		int nextInt() {
			return Integer.parseInt(next());
		}
	}
}

/*
1
4 4
*."#
.*.#
#.@#
####
 */
