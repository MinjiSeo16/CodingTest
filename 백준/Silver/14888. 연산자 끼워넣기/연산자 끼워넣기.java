import java.util.*;
import java.io.*;

public class Main{
    static int N;
    static int[] arr;
    static int[] operators;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        operators = new int[4];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<4; i++){
            operators[i] = Integer.parseInt(st.nextToken());
        }
        
        dfs(arr[0], 1);
        System.out.println(max);
        System.out.println(min);
    }
    
    public static void dfs(int current, int index){
        if(index == N){
            max = Math.max(max,current);
            min = Math.min(min,current);
            return;
        }
        
        for(int i=0; i<4; i++){
            if(operators[i] > 0){
                operators[i]--;
                switch(i){
                    case 0:
                        dfs(current + arr[index], index + 1);
                        break;
                    case 1: 
                        dfs(current - arr[index], index + 1);
                        break;
                    case 2: 
                        dfs(current * arr[index], index + 1);
                        break;
                    case 3:
                        dfs(current / arr[index], index + 1);
                        break;
                }
                operators[i]++;
            }
        }
    }
}