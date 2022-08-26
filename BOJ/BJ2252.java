import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BJ2252 {
	static StringBuilder result = new StringBuilder();
	static int N; // 학생수
	static int M; // 관계수
	static ArrayList<Integer>[] list = null;
	static int[] inDegree;
	
	public static void main(String[] args) {
		FastReader sc = new FastReader();
		N = sc.nextInt();
		M = sc.nextInt();
		
		list = new ArrayList[N+1];
		for(int i = 1; i <= N; i++) {
			list[i] = new ArrayList<Integer>();
		}
	
		inDegree = new int[N+1];
		for(int i = 0; i < M; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			list[x].add(y);
			inDegree[y]++;
		}
		
		Queue<Integer> q = new LinkedList<>();
		for(int i = N; i >= 1; i--) {
			if(inDegree[i] == 0) q.add(i);
		}
		
		while(!q.isEmpty()) {
			int n = q.poll();
			
			result.append(n).append(" ");
			 
			for(int num : list[n]) {
				inDegree[num]--;
				if(inDegree[num] == 0) q.add(num);
			}
		}
	
		System.out.println(result);
		
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
