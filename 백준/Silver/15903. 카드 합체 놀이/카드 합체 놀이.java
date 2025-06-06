import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Queue<Long> queue = new PriorityQueue<>();
        long minSum = 0;
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            queue.add(Long.parseLong(st.nextToken()));
        }
        
        while(m-- > 0){
            long a = queue.poll();
            long b = queue.poll();
            long sum = a + b;
            queue.add(sum);
            queue.add(sum);
        }
        
        while(!queue.isEmpty()){
            minSum += queue.poll();
        }
        
        System.out.println(minSum);
    }
}