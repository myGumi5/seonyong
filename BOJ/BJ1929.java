import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1929 {
    public static void main(String[] args) {
        FastReader sc = new FastReader();
        int start = sc.nextInt();
        int end = sc.nextInt();

        boolean[] arr = new boolean[end+1];
        arr[1] = true;
        for(int i = 2; i <= end; i++){
            if(!arr[i]){
                for(int j = i * 2; j <= end; j += i){
                    arr[j] = true;
                }
            }
        }

        for(int i = start; i <= end; i++){
            if(!arr[i]) System.out.println(i);
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
