import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        List<Integer>[] graph = new ArrayList[N + 1];
        int[] before = new int[N + 1];
        Queue<Integer> queue = new PriorityQueue<>();
        StringBuilder sb = new StringBuilder();
        
        for(int i = 1; i <= N; i++){
            graph[i] = new ArrayList<>();
        }
        
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            
            graph[A].add(B);
            before[B]++;
        }
        
        for(int i = 1 ; i <= N; i++){
            if(before[i] == 0){
                queue.add(i);
            }
        }

        while(!queue.isEmpty()){
            int c = queue.poll();
            sb.append(c).append(" ");
            
            for(int next : graph[c]){
                before[next]--;
                if(before[next] == 0){
                    queue.add(next);
                }
            }
        }
        System.out.println(sb);
    }
}