import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st;
      Queue<Integer> queue = new PriorityQueue<>();
      int n = Integer.parseInt(br.readLine());
      
      for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                int num = Integer.parseInt(st.nextToken());

                if(queue.size() < n){
                    queue.add(num);
                } else if(queue.peek() < num){
                    queue.poll();
                    queue.add(num);
                }
            }
        }

        System.out.println(queue.peek());
    }
}
      
      
