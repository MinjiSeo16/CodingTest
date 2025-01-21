import java.util.*;
import java.io.*;

public class Main{
    static int N,K;
    static int[] arr;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[100001];
        
        System.out.println(bfs(N));
    }
    
    public static int bfs(int startX){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(startX);
        arr[startX] = 0;
        
        while(!queue.isEmpty()){
            int position = queue.poll();
            
            if(position == K) return arr[position];
            
            int[] nextPositions = {position + 1, position - 1, position * 2};
            for(int next : nextPositions){
                if(next >= 0 && next <= 100000 && arr[next] == 0 && next != startX){
                    arr[next] = arr[position] + 1;
                    queue.offer(next);
                }
            }
        }
        return -1;
    }
}