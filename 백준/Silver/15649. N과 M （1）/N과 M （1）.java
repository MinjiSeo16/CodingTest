import java.util.*;
import java.io.*;

public class Main{
    public static int N;
    public static int M;
    public static int[] arr;
    public static boolean[] visit;
    public static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[M];
        visit = new boolean[N + 1];
        
        dfs(0);
        System.out.println(sb);
    }
    
    public static void dfs(int count){
        if(count == M){
            for(int number : arr){
                sb.append(number).append(' ');
            }
            sb.append('\n');
            return;
        }
        
        for(int i = 1; i <= N; i++){
            if(!visit[i]){
                visit[i] = true;
                arr[count] = i;
                dfs(count + 1);
                visit[i] = false;
            }
        }
    }
}