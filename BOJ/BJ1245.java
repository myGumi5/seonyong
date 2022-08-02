import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ1245 {
	static int[][] map, visited;
	static int N, M, cnt;
					// 상  하    좌   우   좌상  우상     우하  좌하
	static int[] dx = {0, 0, -1, 1, -1, 1,    1, -1};
	static int[] dy = {1, -1, 0, 0, -1, -1,   1,  1};
	
	public static void main(String[] args) {
		FastReader sc = new FastReader();
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		map = new int[N][M];
		visited = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(visited[i][j] == 1)continue;
				bfs(i, j);	
			}
		}
		
		System.out.println(cnt);

	}
	static void bfs(int r, int c) {
		boolean check = false;
		Queue<Integer> q = new LinkedList<>();
		q.add(r);
		q.add(c);
		
		while(!q.isEmpty()) {
			int i = q.poll();
			int j = q.poll();
			visited[i][j] = 1;
			
			for(int x = 0; x < 8; x++) {
				int ry = i + dy[x];
				int cx = j + dx[x];
				
				if(ry < 0 || ry >= N || cx < 0 || cx >= M) continue;
				if(map[i][j] < map[ry][cx]) {
					check = true;
					continue;
				}
				if(visited[ry][cx] == 1) continue;
				if(map[i][j] == map[ry][cx]) {
					q.add(ry);
					q.add(cx);
				}	
			}
		}
		
		if(!check)
			cnt++;
		
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
