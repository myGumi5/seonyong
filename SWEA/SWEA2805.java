import java.io.*;
import java.util.*;


class Solution
{
    static int T, ans;
	static int [] N;
	static int [][][] map;
	
	public static void main(String args[]) throws Exception
	{
        input();
		//System.out.println(Arrays.deepToString(map[0]));
		
		for(int t = 0; t < T; t++) {
			ans = 0;
			harvestFarm(t);
			System.out.printf("#%d %d\n", t+1, ans);
		}
	}
    public static void harvestFarm(int t) {
		int c = N[t] / 2;
		
		int range = 1;
		for(int i = 0, j = N[t] - 1; i < N[t] / 2; i++, j--) {
			int count = 0;
			while(count < range) {
				ans += map[t][i][c];
				ans += map[t][j][c++];
				count++;
			}
			c -= range + 1;
			range += 2;
		}
		for(int i = 0; i < N[t]; i++) {
			ans += map[t][N[t] / 2][i];
		}
		
	}
	
	public static void input() {
		FastReader sc = new FastReader();
		T = sc.nextInt();
		N = new int[T];
		map = new int[T][][];
		for(int t = 0; t < T; t++) {
			N[t] = sc.nextInt();
			map[t] = new int[N[t]][N[t]];
			for(int i = 0; i < N[t]; i++) {
				String str = sc.nextLine();
				for(int j = 0; j < N[t]; j++) {
					map[t][i][j] = str.charAt(j) - 48;
				}
			}
		}
	}

	static class FastReader {
		BufferedReader br;
		StringTokenizer st;

		public FastReader() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		public FastReader(String s) throws FileNotFoundException {
			br = new BufferedReader(new FileReader(new File(s)));
		}

		String next() {
			while (st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(next());
		}

		long nextLong() {
			return Long.parseLong(next());
		}

		double nextDouble() {
			return Double.parseDouble(next());
		}

		String nextLine() {
			String str = "";
			try {
				str = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return str;
		}
	}
}