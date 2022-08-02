import java.io.*;
import java.util.*;



class Solution
{
    static int[][] place = new int[10][100];
	static int[] dump = new int[10];
	static int ans = 0;
	public static void main(String args[]) throws Exception
	{
    	input();
		//System.out.println(Arrays.deepToString(place));
		//System.out.println(Arrays.toString(dump));
		for(int t = 0; t < 10; t++) {
			doDump(t);
			System.out.printf("#%d %d\n", t+1, ans);
		}
	}
    public static void doDump(int t) {
		for (int i = 0; i <= dump[t]; i++) {
			// 최대, 최소 값 구하기
			int max = Arrays.stream(place[t]).max().getAsInt();
			int min = Arrays.stream(place[t]).min().getAsInt();
			
			ans = max - min;
			// 평탄화가 완료되면 덤프 중지
			if (ans < 1) {
				return;
			}
			
			// 물건 옮기기
			for (int j = 0; j < 100; j++) {
				if (place[t][j] == max) {
					place[t][j]--;
					break;
				}
			}
			for(int z = 0; z < 100; z++) {
				if (place[t][z] == min) {
					place[t][z]++;
					break;
				}
			}
			
			
		}
	}

	public static void input() {
		FastReader sc = new FastReader();

		for (int i = 0; i < 10; i++) {
			dump[i] = sc.nextInt();
			for (int j = 0; j < 100; j++) {
				place[i][j] = sc.nextInt();
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