import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BJ2206 {
	static int N, M;
	static int [][] map;
	static int [][][] visited;
	static int [] dy = {0, 0, 1, -1};
	static int [] dx = {1, -1, 0, 0};
	
	
	public static void main(String[] args) {
		FastReader sc = new FastReader();
		N = sc.nextInt();
		M = sc.nextInt();
	
		map = new int[N][M];
		visited = new int[N][M][2];
		for(int i = 0; i < N; i++) {
			String str = sc.nextLine();
			for(int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}
		
		bfs();
		
	}
	static void bfs(){
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(0, 0, 1, 0));
		visited[0][0][0] = 1;
		
		while(!q.isEmpty()) {
			Node n = q.poll();
			
			if(n.y == N-1 && n.x == M-1) {
				System.out.println(n.dist);
				return;
			}
			
			for(int i = 0; i < 4; i++) {
				int r = n.y + dy[i];
				int c = n.x + dx[i];
				
				if(r < 0 || r >= N || c < 0 || c >= M) continue;
				if(n.cnt >= 2) continue;
				if(visited[r][c][n.cnt] == 1) continue;
				
				visited[r][c][n.cnt] = 1;
				
				if(map[r][c] == 1) {
					q.add(new Node(r, c, n.dist+1, n.cnt+1));
				} else {
					q.add(new Node(r, c, n.dist+1, n.cnt));
				}
				
			}
		}
		
		System.out.println(-1);
		
	}
	
	static class Node{
		int y, x, dist, cnt;

		public Node(int y, int x, int dist, int cnt) {
			super();
			this.y = y;
			this.x = x;
			this.dist = dist;
			this.cnt = cnt;
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
