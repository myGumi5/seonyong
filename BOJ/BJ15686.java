import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BJ15686 {
	static int N, M, cnt = 0, cnt1 = 0, answer = Integer.MAX_VALUE;
	static int[][] map, copy;
	static ArrayList<int []> coordinate = new ArrayList<>();
	static ArrayList<int []> copyCoo;
	
	static int []dx = {1, -1, 0, 0};
	static int []dy = {0, 0, 1, -1};
	
	public static void main(String[] args) {
		FastReader sc  =  new FastReader();
		N = sc.nextInt();
		M = sc.nextInt();
		
		copy = new int [N][N];
		map = new int[N][N];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
				copy[i][j] = map[i][j];
				if(map[i][j] == 2) {
					int[] sub = new int[2];
					sub[0] = i;
					sub[1] = j;
					coordinate.add(sub);
				}
			}
		}
		
		combination(new int[M+1], 1, coordinate.size());

		System.out.println(answer);
	}
	
	static void bfs(int i, int j) {
		int cnt = Integer.MAX_VALUE;
		for(int z = 0; z < copyCoo.size(); z++) {
			int r = Math.abs(i - copyCoo.get(z)[0]);
			int c = Math.abs(j - copyCoo.get(z)[1]);
			
			cnt = Math.min(cnt, r + c);
		}
		
		cnt1 += cnt;
		
	}
	
	static void combination(int[] arr, int depth, int size) {
		if(depth == M+1) {
			copyCoo = new ArrayList<>();
			for(int i = 1; i <= M; i++) {
				copyCoo.add(coordinate.get(arr[i]-1));
			}
			
			
//			for(int i = 0; i < N; i++) {
//				System.out.println(Arrays.toString(map[i]));
//			}
			cnt = Integer.MAX_VALUE;
			cnt1 = 0;
			for(int z = 0; z < N; z++) {
				for(int j = 0; j < N; j++) {
					if(map[z][j] == 1) {
						bfs(z, j);
					}
				}
			}
			
			answer = Math.min(answer, cnt1);
			
			cnt = 0;
			for(int z = 0; z < N; z++) {
				for(int j = 0; j < N; j++) {
					map[z][j] = copy[z][j];
				}
			}
			
			return;
		}
		
		for(int i = arr[depth-1]+1; i <= size; i++) {
			arr[depth] = i;
			combination(arr, depth + 1, size);
		}
	}
	
	
	static class Node{
		int r;
		int c;
		int dist;
		public Node(int r, int c, int dist) {
			super();
			this.r = r;
			this.c = c;
			this.dist = dist;
		}
		
		@Override
		public String toString() {
			return "Node [r=" + r + ", c=" + c + ", dist=" + dist + "]";
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
