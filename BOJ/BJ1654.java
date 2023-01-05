import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BJ1654 {
    public static void main(String[] args) {
        FastReader sc = new FastReader();
        int n = sc.nextInt();
        int k = sc.nextInt();

       ArrayList<Integer> pq = new ArrayList<>();

        for(int i = 0; i < n; i++){
            pq.add(sc.nextInt());
        }

        Collections.sort(pq);
        long left = 1;
        long right = pq.get(pq.size()-1);

        long ans = 0;
        long mid = 0;
        while(left <= right){
            long cnt = 0;

            mid = (long)((long)left + (long)right) / 2;
            for(int i = 0; i < pq.size(); i++){
                long val = pq.get(i) / mid;
                cnt += val;
            }

            if(cnt >= k){
                left = mid + 1;
                ans = mid;
            } else if(cnt < k){
                right = mid - 1;
            }
        }

        System.out.println(ans);

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
