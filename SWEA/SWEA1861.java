import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class SWEA1861 {
	static int T, N, num, cnt;
	static int[][] map, visited;
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	
	
	public static void main(String[] args) {
		FastReader sc = new FastReader();
		T = sc.nextInt();
		
		for(int t = 0; t < T; t++) {
			N = sc.nextInt();
			num = Integer.MAX_VALUE;
			cnt = 0;
			
			map = new int[N][N];
			for(int i = 0; i < N; i++){
				for(int j = 0; j < N; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					visited = new int [N][N];
					bfs(i, j);
				}
			}
		
			System.out.printf("#%d %d %d\n", t+1, num, cnt);
		}
		
	}
	static void bfs(int i, int j) {
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(j, i, 1));
		visited[i][j] = 1;
		
		while(!q.isEmpty()) {
			Node n = q.poll();
			int x = n.x;
			int y = n.y;
			
			for(int c = 0; c < 4; c++) {
				int ry = y + dy[c];
				int cx = x + dx[c];
				
				if(ry < 0 || ry >= N || cx < 0 || cx >= N) continue;
				if(visited[ry][cx] == 1) continue;
				if(map[ry][cx] - map[y][x] == 1) {
					if(cnt <= n.depth+1) {
						if(cnt == n.depth+1)
							num = Math.min(map[i][j], num);
						else num = map[i][j];
						cnt = n.depth+1; 
					}
					q.add(new Node(cx, ry, n.depth+1));
					visited[ry][cx] = 1;
				}
			}
			
		}
		
	}
	
	static class Node{
		int x;
		int y;
		int depth;
		
		public Node(int x, int y, int depth) {
			super();
			this.x = x;
			this.y = y;
			this.depth = depth;
		}

		@Override
		public String toString() {
			return "Node [x=" + x + ", y=" + y + ", depth=" + depth + "]";
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
