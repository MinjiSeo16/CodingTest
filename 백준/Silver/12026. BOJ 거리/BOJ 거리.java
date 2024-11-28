import java.io.*;

public class Main{
    static int N;
    static char[] block;
    static int[] dp;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());  
        block = new char[N+1];
        dp = new int[N+1];
        
        String input = br.readLine();
        for(int i=1; i<=N; i++){
            block[i] = input.charAt(i-1);
        }
        
        for (int i=2; i<=N; i++){
            dp[i] = Integer.MAX_VALUE;
        }
        
        System.out.println(solve());
    }
    
    public static int solve(){
        dp[1] = 0;
        
        for(int i=1; i<=N; i++){
            if (dp[i] == Integer.MAX_VALUE) continue;
            char nextChar = getNextChar(block[i]);
            for(int j=i+1; j<=N; j++){
                if(block[j] == nextChar){
                    int energy = (j-i) * (j-i);
                    dp[j] = Math.min(dp[j], dp[i]+energy);
                }
            }
        }
        
        return dp[N] == Integer.MAX_VALUE ? -1 : dp[N];
    }
    
    public static char getNextChar(char current){
        if(current == 'B') return 'O';
        if(current == 'O') return 'J';
        return 'B';
    }
}