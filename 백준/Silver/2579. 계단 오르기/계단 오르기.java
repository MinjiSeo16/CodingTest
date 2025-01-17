import java.io.*;

public class Main{
    static int N;
    static int[] arr;
    static int[] dp;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N+1];
        dp = new int[N+1];
        
        for(int i=1; i<=N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        
        System.out.println(solve());
    }
    
    public static int solve(){
        if(N==1) return arr[1];
        if(N==2) return arr[1] + arr[2];
        
        dp[1] = arr[1];
        dp[2] = arr[1] + arr[2];
        
        for(int i=3; i<=N; i++){
            dp[i] = Math.max(dp[i-2], dp[i-3] + arr[i-1]) + arr[i];
        }
        
        return dp[N];
    }
}