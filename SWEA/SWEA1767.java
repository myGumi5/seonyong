import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class SWEA1767 {
	static int T, N, M, min, max, one;
	static int[][] map, copy;
	static ArrayList<Node> list = new ArrayList<>();
		
	static int[] dy = {0, 0, 1, -1};
	static int[] dx = {1, -1, 0, 0};
	
	public static void main(String[] args) {
		FastReader sc = new FastReader();
		
		T = sc.nextInt();
		
		for(int t = 0; t < T; t++) {
			N = sc.nextInt();
			list = new ArrayList<>();
			map = new int[N][N];
			copy = new int[N][N];
			min = Integer.MAX_VALUE;
			max = Integer.MIN_VALUE;
			one = 0;
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					map[i][j] = sc.nextInt();
					copy[i][j] = map[i][j];
					if(map[i][j] == 1) {
						one++;
						if(i == 0 || i == N-1 || j == 0 || j == N-1) continue;
						list.add(new Node(i, j));
					}
				}
			}
			
			for(int i = 1; i <= list.size(); i++) {
				M = i;
				combination(new int[i+1], 1);
			}
			
			System.out.printf("#%d %d\n", t+1, min);
			
		}
		
	}
	static int countOne() {
		int cnt = 0;
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(map[i][j] == 1) cnt++;
			}
		}
		
		return cnt - one;
	}
	
	static void origindraw(int dir, Node n) {
		int r = n.y;
		int c = n.x;
		while(true) {
			r += dy[dir];
			c += dx[dir];
			
			if(r < 0 || r >= N || c < 0 || c >= N) break;
			map[r][c] = 0;
		}
	}
	
	static void draw(int dir, Node n) {
		int r = n.y;
		int c = n.x;
		while(true) {
			r += dy[dir];
			c += dx[dir];
			
			if(r < 0 || r >= N || c < 0 || c >= N) break;
			map[r][c] = 1;
		}
	}
	
	static boolean isCan(int dir, Node n) {
		int r = n.y;
		int c = n.x;
		while(true) {
			r += dy[dir];
			c += dx[dir];
			
			if(r < 0 || r >= N || c < 0 || c >= N) break;
			if(map[r][c] == 1) return true;
		}
		
		return false;
	}
	
	static void permutation(int[] com, int depth, int[] arr) {
		if(depth == arr.length) {
//			System.out.println(Arrays.toString(Arrays.copyOfRange(com, 1, arr.length)));
			
			if(max == arr.length) {
				min = Math.min(min, countOne());
			} else if(arr.length > max) {
				max = arr.length;
				min = countOne();
			}
			
			return;
		}
		
		for(int i = 0; i < 4; i++) {
			com[depth] = i;
			if(isCan(com[depth], list.get(arr[depth] - 1))) continue;
			draw(com[depth], list.get(arr[depth] - 1));
			permutation(com, depth+1, arr);
			origindraw(com[depth], list.get(arr[depth] - 1));
		}
	}
	
	static void combination(int[] arr, int depth) {
		if(depth == M+1) {
			//System.out.println(Arrays.toString(Arrays.copyOfRange(arr, 1, M+1)));
			
			// 선택된 렉시노스 전선 연결
			permutation(new int[arr.length], 1, arr);

			return;
		}
		
		for(int i = arr[depth - 1] + 1; i <= list.size(); i++) {
			arr[depth] = i;
			combination(arr, depth + 1);
		}
		
	}
	
	static class Node{
		int y; int x;


		public Node(int y, int x) {
			super();
			this.y = y;
			this.x = x;
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
1
7
0 0 0 0 0 0 0
0 0 0 0 0 0 0
0 0 0 1 0 0 0
0 0 1 1 1 0 0
0 0 0 1 0 0 0
0 0 0 0 0 0 0
0 0 0 0 0 0 0
*/