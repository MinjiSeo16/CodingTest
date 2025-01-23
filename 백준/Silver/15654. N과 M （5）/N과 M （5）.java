import java.io.*;
import java.util.*;

public class Main{
    static int N,M;
    static StringBuilder sb = new StringBuilder();
    static int[] arr;
    static int[] result;
    static boolean[] visit;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        result = new int[M];
        visit = new boolean[N];
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(arr);
        dfs(0);
        System.out.print(sb.toString());
    }
    
    static void dfs(int count){
        if(count == M){
            for(int n : result){
                sb.append(n).append(' ');
            }
            sb.append('\n');
            return;
        }
        
        for(int i = 0; i < N; i++){
            if(!visit[i]){
                visit[i] = true;
                result[count] = arr[i];
                dfs(count + 1);
                visit[i] = false;
            }
        }
    }
}