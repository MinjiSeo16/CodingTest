import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        int[] V = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++){
            V[i] = Integer.parseInt(st.nextToken());
        }
        
        boolean[] prev = new boolean[M+1];
        prev[S] = true;
        
        for(int i=1; i<=N; i++){
            boolean[] curr = new boolean[M+1];
            for(int j=0; j<=M; j++){
                if(prev[j]){
                    if(j + V[i] <= M){
                        curr[j + V[i]] = true;
                    }
                    if(j - V[i] >= 0){
                        curr[j - V[i]] = true;
                    }
                }
            }
            prev = curr;
        }
        
        int result = -1; 
        for(int i=M; i>=0; i--){
            if(prev[i]){
                result = i;
                break;
            }
        }
        System.out.println(result);
    }
}