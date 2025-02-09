import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        Queue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2){
                if(o1[0] == o2[0]) return o1[1] - o2[1];
                return o1[0] - o2[0];
            }
        });

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            queue.add(new int[]{x, y});
        }
        
        long sum = 0;
        int[] current = queue.poll();
        sum += current[1] - current[0];
        
        while(!queue.isEmpty()){
            int[] next = queue.poll();
            if(current[1] > next[0] && current[1] < next[1]){
                sum += (next[1] - current[1]);
                current = next;
            }
            
            if(current[1] <= next[0]){
                sum += (next[1] - next[0]);
                current = next;
            }
        }
        
        System.out.println(sum);
    }
}