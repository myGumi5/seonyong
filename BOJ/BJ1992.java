package algostudy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1992 {

	static int N;
	static int[][] map;

	public static void main(String[] args) {
		FastReader sc = new FastReader();
		N = sc.nextInt();

		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			String str = sc.nextLine();
			for (int j = 0; j < str.length(); j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}

		merge(0, 0, N);

	}

	static void merge(int x, int y, int size) {
		if (canPress(x, y, size)) {
			System.out.print(map[y][x]);
			return;
		}

		System.out.print("(");
		merge(x, y, (size / 2));
		merge(x + (size / 2), y, (size / 2));
		merge(x, y + (size / 2), (size / 2));
		merge(x + (size / 2), y + (size / 2), (size / 2));
		System.out.print(")");
	}

	static boolean canPress(int x, int y, int size) {

		int num = map[y][x];
		for (int i = y; i < y + size; i++) {
			for (int j = x; j < x + size; j++) {
				if (map[i][j] != num)
					return false;
			}
		}

		return true;
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
 * 4 1100 1100 0011 0011
 * 
 */
