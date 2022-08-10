import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1010 {
	static int N, M, T;
	static int[][] dp;
	
	public static void main(String[] args) {
		FastReader sc = new FastReader();
		T = sc.nextInt();
		
		for(int t = 0; t < T; t++) {
			N = sc.nextInt();
			M = sc.nextInt();
			
			dp = new int[31][31];

			for(int i = 0; i <= M; i++) {
				dp[1][i] = i;
			}
			
			for(int i = 2; i <= N; i++) {
				for(int j = i; j <= M; j++) {
					dp[i][j] = dp[i-1][j-1] + dp[i][j-1];
				}
			}
			
			System.out.println(dp[N][M]);
			
		}
		
		
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
