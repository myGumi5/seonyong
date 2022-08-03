import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ11659 {
	static int N, M;
	static int[] arr;
	static int[][] arr1;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) {
		FastReader sc = new FastReader();
		N = sc.nextInt();
		M = sc.nextInt();
		
		arr = new int [N+1];
		for(int i = 1 ; i <= N; i++) {
			arr[i] = arr[i-1] + sc.nextInt();
		}
		
		for(int i = 0; i < M; i++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			
			System.out.println(arr[m] - arr[n - 1]);
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

	}
}
