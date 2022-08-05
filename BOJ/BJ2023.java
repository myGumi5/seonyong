import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BJ2023 {
	static int N;
	
	public static void main(String[] args) {
		FastReader sc = new FastReader();
		
		N = sc.nextInt();
		for(int i = 2; i < 10; i++) {
			bfs(i);
		}
	}
	static void bfs(int start) {
		if(check(start)) return;
		if(N == 1) {
			System.out.println(start);
			return;
		}
		Queue<Integer> q = new LinkedList<>();
		q.add(start);
		
		while(!q.isEmpty()) {
			int n = q.poll();
			
			for(int i = 0; i < 10; i++) {
				int cal = n*10 + i;
				
				if(check(cal)) continue;
				if(String.valueOf(cal).length() == N) {
					System.out.println(cal);
					continue;
				}
				q.add(cal);
			}
		
			
		}
		
	}
	static boolean check(int cal) {
		int sqrt = (int)Math.sqrt(cal);
		
		for(int i = 2; i <= sqrt; i++) {
			if(cal % i == 0)
				return true;
		}
		
		return false;
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
