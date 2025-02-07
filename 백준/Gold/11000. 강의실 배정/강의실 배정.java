import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] time = new int[N][2];
        int count = 0;
        
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int T = Integer.parseInt(st.nextToken());
            time[i][0] = S;
            time[i][1] = T;
        }
        
        Arrays.sort(time, (a, b) -> Integer.compare(a[0], b[0]));
        
        PriorityQueue<Integer> classes = new PriorityQueue<>();
        for(int[] t : time){
            int start = t[0], end = t[1];
            
            if(!classes.isEmpty() && classes.peek() <= start){
                classes.poll();
            }
            
            classes.add(end);
        }
        
        System.out.println(classes.size());
    }
}