import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BJ16236 {
	static int N, time = 0;
	static int [][] map, visited;
	static Shark baby;
	static int[] dy = {-1, 0, 0, 1};
	static int[] dx = {0, -1, 1, 0};
	
	
	public static void main(String[] args) {
		FastReader sc = new FastReader();
		N = sc.nextInt();

		map = new int[N][N];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
				if(map[i][j] == 9) {
					baby = new Shark(i, j, 2, 2, 0);
					map[i][j] = 0;
				}
			}
		}
		
		pro();
		
		System.out.println(time);
		
		
	}
	static void pro() {
		
		while(true) {
		// 가장 가까운 곳의 물고기를 찾는다.
			visited = new int[N][N];
			if(bfs()) break;
//			for(int i = 0; i < N; i++) {
//				System.out.println(Arrays.toString(visited[i]));
//			}
//			System.out.println(baby.val);
//			System.out.println(time);
		}
		
	}
	
	static boolean bfs() {
		Queue<Shark> q = new LinkedList<>();
		PriorityQueue<Shark> pq = new PriorityQueue<>();
		q.add(baby);
		visited[baby.y][baby.x] = 1;
		
		while(!q.isEmpty()) {
			Shark s = q.poll();
			
			for(int i = 0; i < 4; i++) {
				int r = s.y + dy[i];
				int c = s.x + dx[i];
				
				if(r < 0 || r >= N || c < 0 || c >= N) continue;
				if(map[r][c] > s.val) continue;
				if(visited[r][c] >= 1) continue;
				
				if(map[r][c] != 0 && map[r][c] < s.val) {
					visited[r][c] = s.dist+1;
					s.rest--;
					if(s.rest == 0) {
						s.val++;
						s.rest = s.val;
					}
					pq.add(new Shark(r, c, s.val, s.rest, s.dist + 1));
				}
				
				q.add(new Shark(r, c, s.val, s.rest, s.dist+1));
				visited[r][c] = s.dist+1;
			}
		}
		
		if(pq.isEmpty()) return true;
		else {
			Shark s = pq.poll();
			time += s.dist;
			baby = new Shark(s.y, s.x, s.val, s.rest, 0);
			map[s.y][s.x] = 0;
			return false;
		}
		
	}
	
	static class Shark implements Comparable<Shark>{
		int y, x, val, rest, dist;

		public Shark(int y, int x, int val, int rest, int dist) {
			super();
			this.y = y;
			this.x = x;
			this.val = val;
			this.rest = rest;
			this.dist = dist;
		}

		@Override
		public String toString() {
			return "Shark [y=" + y + ", x=" + x + ", val=" + val + ", rest=" + rest + ", dist=" + dist + "]";
		}

		@Override
		public int compareTo(Shark o) {
			if(this.dist == o.dist) {
				if(this.y == o.y) {
					return this.x - o.x;
				} else{
					return this.y - o.y;
				}
			}else {
				return this.dist - o.dist;	
			}
		}

		
		
	}
	
	static class FastReader{
		BufferedReader br = null;
		StringTokenizer st = null;
		
		public FastReader() {
			br = new BufferedReader(new InputStreamReader(System.in));
			// TODO Auto-generated constructor stub
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
/*
4
0 0 1 0
4 4 0 4
0 9 0 0
0 0 0 1


*/