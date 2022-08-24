import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BJ17471 {
	static int N, min = Integer.MAX_VALUE;
	static int [] per, parents;
	static int [] visited;
	static HashMap<Integer, ArrayList<Integer>> map;
	
	public static void main(String[] args) {
		FastReader sc = new FastReader();
		N = sc.nextInt();
		
		per = new int[N+1];
		
		map = new HashMap<>();
		for(int i = 1; i <= N; i++) {
			per[i] = sc.nextInt();
		}
		
		for(int i = 1; i <= N; i++) {
			int len = sc.nextInt();
			for(int j = 0; j < len; j++) {
				int num = sc.nextInt();
				if (map.get(i) == null) {
					map.put(i, new ArrayList<>(Arrays.asList(num)));
				} else {
					map.get(i).add(num);
				}
			}
		}
		
		//System.out.println(map);
		permutation(new int[N+1], 1);
		if(min ==Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(min);
	}
	
	static void bfs(ArrayList<Integer> list) {
		Queue<Integer> q = new LinkedList<>();
		q.add(list.get(0));
		visited[list.get(0)] = 1;
		
		while(!q.isEmpty()) {
			int n = q.poll();
			
			if(map.get(n) == null) continue;
			for(int i : map.get(n)) {
				if(!list.contains(i)) continue;
				if(visited[i] == 1) continue;
				
				visited[i] = 1;
				q.add(i);
				
			}
		}
	}
	
	static void permutation(int [] arr, int depth) {
		if(depth == N+1) {
			//System.out.println(Arrays.toString(Arrays.copyOfRange(arr, 1, N+1)));;
			ArrayList<Integer> zero = new ArrayList<>();
			ArrayList<Integer> one = new ArrayList<>();
			visited = new int[N+1];
			
			for(int i = 1; i <= N; i++) {
				if(arr[i] == 0) zero.add(i);
				else one.add(i);
			}
			
			if(zero.size() == 0 || one.size() == 0) return;
			
			bfs(zero);
			for(int z : zero) {
				if(visited[z] != 1) return;
			}
			
			bfs(one);			
			for(int o : one) {
				if(visited[o] != 1) return;
			}
			
			int sum = 0;
			for(int z : zero) {
				sum += per[z];
			}
			for(int o : one) {
				sum -= per[o];
			}
			
			min = Math.min(min, Math.abs(sum));
			//System.out.println(min);
			return;
		}
		
		for(int i = 0; i <= 1; i++) {
			arr[depth] = i;
			permutation(arr, depth+1);
		}
		
	}
	
	static class FastReader{
		BufferedReader br = null;
		StringTokenizer st = null;
		
		public FastReader() {
			br = new BufferedReader(new InputStreamReader(System.in));
			// TODO Auto-generated constructor stub
		}
		
		String next() {
			while(st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
			return st.nextToken();
		}
		
		int nextInt() {
			return Integer.parseInt(next());
		}
	}
}
