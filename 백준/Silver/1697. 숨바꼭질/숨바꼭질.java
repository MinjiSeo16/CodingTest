import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        
        System.out.println(bfs(n,k));
    }
    
    public static int bfs(int start, int target){
        if(start == target){
            return 0;
        }
        
        boolean[] visited = new boolean[100001];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;
        int time = 0;
        
        while(!queue.isEmpty()){
            int size = queue.size();
            time++;
            
            for(int i=0; i<size; i++){
                int current = queue.poll();
                int[] nextPositions = {current - 1, current + 1, current * 2};
                for(int next : nextPositions){
                    if(next == target){
                        return time;
                    }
                    if(next >= 0 && next <= 100000 && !visited[next]){
                        visited[next] = true;
                        queue.add(next);
                    }
                }
            }
        }
        return -1;
    }
}