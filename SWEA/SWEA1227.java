import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class SWEA1227 {
	static int N, T = 10;
	static int[][] map, visited;
	
	static int [] dx = {1, -1, 0, 0};
	static int [] dy = {0, 0, 1, -1};
	
	public static void main(String[] args) {
		FastReader sc = new FastReader();
		
		for(int t = 0; t < T; t++) {
			N = sc.nextInt();
			
			int r = 0;
			int c = 0;
			map = new int[100][100];
			visited = new int[100][100];
			for(int i =0; i < 100; i++) {
				String str = sc.nextLine();
				for(int j = 0; j < str.length(); j++) {
					map[i][j] = str.charAt(j) - '0';
					if(map[i][j] == 2) {
						r = i;
						c = j;
					}
					
				}
			}
			System.out.print("#"+(t+1)+" ");
			bfs(r, c);
		}
	}
	static void bfs(int i, int j) {
		Queue<Integer> q = new LinkedList<>();
		q.add(i);
		q.add(j);
		visited[i][j] = 1;
		
		while(!q.isEmpty()) {
			int r = q.poll();
			int c = q.poll();
			
			for(int d = 0; d < 4; d++) {
				int rd = r + dy[d];
				int cd = c + dx[d];
				
				if(rd < 0 || rd >= 100 || cd < 0 || cd >= 100) continue;
				if(visited[rd][cd] == 1) continue;
				if(map[rd][cd] == 1) continue;
				if(map[rd][cd] == 3) {
					System.out.println(1);
					return;
				}
				
				visited[rd][cd] = 1;
				q.add(rd);
				q.add(cd);
				
			}
			
		}
		
		System.out.println(0);
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
