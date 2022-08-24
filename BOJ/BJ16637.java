import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BJ16637 {
	static int N; static long res = Long.MIN_VALUE;
	static String str;
	static Deque<Long> nums = new ArrayDeque<Long>();
	static Deque<Character> simbols = new ArrayDeque<Character>();
	
	
	public static void main(String[] args) {
		FastReader sc = new FastReader();
		N = sc.nextInt();
		str = sc.nextLine();
		permutation(new int[N/2 + 1], 1);
		
		System.out.println(res);
	}
	static void permutation(int[] arr, int depth) {
		if(depth == (N / 2) + 1) {
			
			nums = new ArrayDeque<Long>();
			simbols = new ArrayDeque<Character>();
			
			nums.add((long) (str.charAt(0)-'0'));
//			System.out.println(Arrays.toString(Arrays.copyOfRange(arr, 1, depth)));
			int idx = 1;
			for(int i = 1; i < arr.length; i++) {
				if(arr[i] == 1) {
					long num1 = nums.pollLast();
					char ch = str.charAt(idx++);
					long num2 = str.charAt(idx++) - '0';
					
					if(ch == '+') {
						nums.add(num1 + num2);
					} else if(ch == '-') {
						nums.add(num1 - num2);
					} else if(ch == '*') {
						nums.add(num1 * num2);
					}
				} else {
					simbols.add(str.charAt(idx++));
					nums.add((long) (str.charAt(idx++) - '0'));
				}
			}
			
			
			while(!simbols.isEmpty()) {
				long num1 = nums.poll();
				long num2 = nums.poll();
				char ch = simbols.poll();
				
				if(ch == '+') {
					nums.addFirst(num1 + num2);
				} else if(ch == '-') {
					nums.addFirst(num1 - num2);
				} else if(ch == '*') {
					nums.addFirst(num1 * num2);
				}
			}
			
			res = Math.max(res, nums.pop());
			
			return;
		}
		
		for(int i = 0; i <= 1; i++ ) {
			arr[depth] = i;
			if(depth != 1 && arr[depth - 1] == 1 && arr[depth] == 1) return;
			permutation(arr, depth + 1);
		}
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
					// TODO: handle exception
				}
			}
			
			return st.nextToken();
		}
		
		String nextLine() {
			String str = null;
			try {
				str = br.readLine();
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			return str;
		}
		
		int nextInt() {
			return Integer.parseInt(next());
		}
	}
}
