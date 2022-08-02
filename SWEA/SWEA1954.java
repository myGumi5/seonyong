import java.io.*;
import java.util.*;

class SWEA1954
{
	static int T;
	static int N[];
	static int arr[][][];
	static int visited[][];
	static int dir;
	public static void main(String[] args) {
		input();
		arr = new int[T][][];
		for(int t = 0; t < T; t++) {
			arr[t] = new int[N[t]][N[t]];
			visited = new int [N[t]][N[t]];
			dir = 0;
			dfs(t, 0, 0, 1);
			// 1우측 2좌측 3위측 4아래측
			System.out.printf("#%d\n", t+1);
			for(int i = 0; i < N[t]; i++) {
				for(int j = 0; j < N[t]; j++) {
					System.out.printf("%d ", arr[t][i][j]);
				}
				System.out.println();
			}
		}
	}
	static void dfs(int t, int i, int j, int num) {
		if(i >= N[t] || i < 0 || j < 0 || j >= N[t]) {
			dir++;
			if(dir >= 4)
				dir = 0;
			return;
		}
		if(visited[i][j] == 1) { 
			dir++;
			if(dir >= 4)
				dir = 0;
			return;
		}
		
		visited[i][j] = 1;
		arr[t][i][j] = num;
		
		if(dir == 0) dfs(t, i, j+1, num+1);
		if(dir == 1) dfs(t, i+1, j, num+1);
		if(dir == 2) dfs(t, i, j - 1, num+1);
		if(dir == 3) dfs(t, i-1, j, num+1);
		if(dir == 0) dfs(t, i, j+1, num+1);
		if(dir == 1) dfs(t, i+1, j, num+1);
		if(dir == 2) dfs(t, i, j - 1, num+1);
	}
	
	static void input() {
		FastReader sc = new FastReader();
		T = sc.nextInt();
		N = new int[T];
		for(int t = 0; t< T; t++) {
			N[t] = sc.nextInt();
		}
	}

	static class FastReader{
		BufferedReader br;
		StringTokenizer st;
		
		FastReader(){
			br = new BufferedReader(new InputStreamReader(System.in));
		}
		public String next() {
			while(st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch(Exception e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}
		
		public int nextInt() {
			return Integer.parseInt(next());
		}
	}
}