package com.ssafy.algo.live20230105;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ1874 {

	public static void main(String[] args) {
		FastReader sc = new FastReader();
		int n = sc.nextInt();
		
		Stack<Integer> stack = new Stack<>();
		for(int i = n; i >= 1; i--) {
			stack.add(i);
		}
		
		int[] arr = new int[n+1];
		for(int i = 1; i <= n; i++) {
			arr[i] = sc.nextInt();
		}
		
		StringBuilder sb = new StringBuilder();
		int pointer = 1;
		Stack<Integer> sub = new Stack<>();
		while(!stack.isEmpty()) {
			int num = stack.pop();
			
			if(num == arr[pointer]) {
				sb.append("+").append("\n");
				sb.append("-").append("\n");
				pointer++;
				while(!sub.isEmpty()) {
					num = sub.peek();
					if(num == arr[pointer]) {
						sub.pop();
						sb.append("-").append("\n");
						pointer++;
					} else {
						break;
					}
				}
			} else {
				sub.add(num);
				sb.append("+").append("\n");
			}
			
		}
		
		if(stack.isEmpty() && sub.isEmpty()) {
			System.out.println(sb.toString());
		} else {
			System.out.println("NO");
		}
		
	}
	static class FastReader{
        BufferedReader br = null;
        StringTokenizer st = null;

        FastReader(){
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next(){
            while(st == null || !st.hasMoreElements()){
                try{
                    st = new StringTokenizer(br.readLine());
                } catch (Exception e){
                    e.printStackTrace();
                }
            }

            return st.nextToken();
        }

        int nextInt(){
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
