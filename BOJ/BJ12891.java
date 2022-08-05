import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BJ12891 {
	static int S, P, cnt = 0;
	static String str;
	static int[]visited;
	static HashMap<Character, Integer> map = new HashMap<>();
	
	public static void main(String[] args) {
		input();
		twoPointer();
		System.out.println(cnt);
	}
	
	static void twoPointer() {
		int right = 0;
		for(int left = 0; left < str.length(); left++) {
			while(right < S && right - left < P) {
				map.put(str.charAt(right), map.get(str.charAt(right)) - 1);
				right++;
			}
			
			if(check()) cnt++;
				
			map.put(str.charAt(left), map.get(str.charAt(left)) + 1);
			if(right >= S) break;
		}
	}
	
	static boolean check() {
		for(char c : map.keySet()) {
			if(map.get(c) > 0) {
				return false;
			}
		}
		return true;
	}
	
	static void input() {
		FastReader sc = new FastReader();
		
		S = sc.nextInt();
		P = sc.nextInt();
		str = sc.nextLine();
		
		map.put('A', sc.nextInt());
		map.put('C', sc.nextInt());
		map.put('G', sc.nextInt());
		map.put('T', sc.nextInt());
		
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
