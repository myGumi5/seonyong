import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BJ1966 {
    static Queue<Node>list = null;
    public static void main(String[] args) {
        FastReader sc = new FastReader();
        int T = sc.nextInt();

        for(int t = 0; t < T; t++) {
            list = new LinkedList<>();

            int n = sc.nextInt();
            int m = sc.nextInt();

            PriorityQueue<Integer> pq = new PriorityQueue(Comparator.reverseOrder());
            for(int i = 0; i < n; i++){
                int val = sc.nextInt();
                list.add(new Node(i, val));
                pq.add(val);
            }

            int cnt = 1;
            while(!pq.isEmpty()){
                int num = pq.peek();

                if(list.peek().val == num){
                    if(list.peek().num == m){
                        System.out.println(cnt);
                        break;
                    } else{
                        list.poll();
                        pq.poll();
                        cnt++;
                    }
                } else{
                    list.add(list.poll());
                }

            }

        }

    }
    static class Node implements Comparable<Node>{
        int num, val;

        public Node(int num, int val) {
            this.num = num;
            this.val = val;
        }

        @Override
        public int compareTo(Node o) {
            return this.val - o.val;
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
