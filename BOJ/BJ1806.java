import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ1806 {
	static int N,S;
	static long ans = Long.MAX_VALUE;
	static long[] arr;
	public static void main(String[] args) {
		FastReader sc  = new FastReader();
		N = sc.nextInt();
		S = sc.nextInt();
		
		arr = new long[N+1];
		for(int i = 1; i <= N; i++) {
			arr[i] = sc.nextInt() + arr[i-1];
		}
		
		
		
		twoPointer();
		
		if(ans == Long.MAX_VALUE) System.out.println(0);
		else System.out.println(ans);
		
	}
	static void twoPointer() {
		
		int r = 1;
		for(int i = 0; i <= N; i++) {
			while(r < N && arr[r] - arr[i] < S) {
				r++;
			}
			
			if(arr[r] - arr[i] >= S) {
				ans = Math.min(ans, r - i);
				//System.out.println(r + " " + i);
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

	}
}
