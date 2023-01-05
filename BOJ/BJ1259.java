import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1259 {
    public static void main(String[] args) {
        FastReader sc  = new FastReader();


        while(true) {
            String str = sc.nextLine();
            if(str.equals("0")){
                return;
            }
            boolean flag = false;
            for (int i = 0, j = str.length() - 1; i < str.length(); i++, j--) {
                if (str.charAt(i) != str.charAt(j)) {
                    flag = true;
                    break;
                }
            }
            if(flag) System.out.println("no");
            else System.out.println("yes");
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
