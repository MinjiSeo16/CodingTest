import java.io.*;
import java.util.*;

public class Main{
    static int N,M;
    static StringBuilder sb = new StringBuilder();
    static int[] arr;
    static int[] result;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        result = new int[M];
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(arr);
        dfs(0,0);
        System.out.print(sb.toString());
    }
    
    static void dfs(int start, int count){
        if(count == M){
            for(int n : result){
                sb.append(n).append(' ');
            }
            sb.append('\n');
            return;
        }
        
        for(int i = start; i < N; i++){
            result[count] = arr[i];
            dfs(i, count + 1);
        }
    }
}