import java.util.*;

public class Main{
    static int N, M;
    static boolean[] visit;
    static int[] arr;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        visit = new boolean[N + 1];
        arr = new int[M];
        
        dfs(0);
    }
    
    static void dfs(int count){
        if(count == M){
            for(int n : arr){
                System.out.print(n + " ");
            }
            System.out.println();
            return;
        }
        
        for(int i = 1; i <= N; i++){
            if(!visit[i]){
                visit[i] = true;
                arr[count] = i;
                dfs(count + 1);
                for(int j = i + 1; j <= N; j++){
                    visit[j] = false;
                }
            }
        }
    }
}