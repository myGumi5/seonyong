import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	static int TC, ans, num, len = 100;
	static int[][] ladder, visited;
	public static void main(String[] args) {
		FastReader sc = new FastReader();
		TC = 10;
		
		
		for(int t = 0; t < TC; t++) {
			ladder = new int[len][len];
			num = sc.nextInt();
			ans = 0;
			
			for(int i = 0; i < len; i++) {
				for(int j = 0; j < len; j++) {
					ladder[i][j] = sc.nextInt();
				}
			}
			
			for(int j = 0; j < len; j++) {
				if(ladder[len -1][j] == 2) {
					visited = new int[len][len];
					dfs(len-1, j);
				}
			}
			
			System.out.printf("#%d %d\n", t+1, ans);
		}

	}
	
	
	/*
1
1 0 0 0 1 0 1 0 0 1
1 0 0 0 1 0 1 1 1 1
1 0 0 0 1 0 1 0 0 1
1 0 0 0 1 1 1 0 0 1
1 0 0 0 1 0 1 0 0 1
1 1 1 1 1 0 1 1 1 1
1 0 0 0 1 0 1 0 0 1
1 1 1 1 1 0 1 0 0 1
1 0 0 0 1 1 1 0 0 1
1 0 0 0 1 0 1 0 0 2
	 */
	static void dfs(int i, int j) {
		Queue<Integer> q = new LinkedList<>();
		q.add(i);
		q.add(j);
		
		int r = 0;
		int c = 0;
		while(!q.isEmpty()) {
			r = q.poll();
			c = q.poll();
			visited[r][c] = 1;
				
			if((c - 1 >= 0 && c - 1 < len) && visited[r][c-1] == 0 && ladder[r][c-1] == 1) {
				q.add(r);
				q.add(c-1);
			} else if((c + 1 >= 0 && c + 1 < len) && visited[r][c+1] == 0 && ladder[r][c+1] == 1){
				q.add(r);
				q.add(c+1);
			} else if((r - 1 >= 0 && r - 1 < len)){
				q.add(r-1);
				q.add(c);
			}
		}
		
		ans = c;
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


