import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class BJ11723 {
	
	public static void main(String[] args) {
		FastReader sc =  new FastReader();
		int N = sc.nextInt();
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int number = 0;
		for(int i = 0; i < N; i++) {
			String str = null;
			int num = 0;
			
			StringTokenizer s =new StringTokenizer(sc.nextLine());
			str = s.nextToken();
			if(s.hasMoreElements())
				num = Integer.parseInt(s.nextToken()) - 1;
			
			
			if(str.equals("add")) {
				number = number | (1 << num);
			} else if(str.equals("check")) {
				if((number & (1 << num)) > 0){
					try {
						bw.write("1\n");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} else {
					try {
						bw.write("0\n");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			} else if(str.equals("remove")) {
				if((number & (1 << num)) > 0) {
					number = number ^ (1 << num);
				}
			} else if(str.equals("toggle")) {
				number = number ^ (1 << num);
			} else if(str.equals("all")) {
				number = number | 1048575;
			} else {
				number = number & 0;
			}
			
			
			//System.out.println(Integer.toBinaryString(number));
			
		}
		
		try {
			bw.flush();
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
