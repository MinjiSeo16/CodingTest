import java.util.*;

public class Main{
    static int N, M;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        arr = new int[M];
        
        dfs(1, 0);
        System.out.print(sb);
    }
    
    static void dfs(int start, int count){
        if(count == M){
            for(int n : arr){
                sb.append(n).append(' ');
            }
            sb.append('\n');
            return;
        }
        
        for(int i = start; i <= N; i++){
            arr[count] = i;
            dfs(i, count + 1);
        }
    }
}