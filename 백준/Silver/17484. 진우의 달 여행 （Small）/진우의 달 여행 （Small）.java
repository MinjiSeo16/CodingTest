import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N][M];
        int[] diff = {-1, 0, 1};
        int[][][] dp = new int[N][M][3];
        
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                for(int d = 0; d < 3; d++){
                    dp[i][j][d] = Integer.MAX_VALUE;
                }
            }
        }
        
        for(int i = 0; i < M; i++){
            for(int j = 0; j < 3; j++){
                dp[0][i][j] = arr[0][i];
            }
        }
        
        for(int i = 1; i < N; i++){
            for(int j = 0; j < M; j++){
                for(int d = 0; d < 3; d++){
                    int prev = j + diff[d];
                    if(prev >= 0 && prev < M){
                        for(int k = 0; k < 3; k++){
                            if(k != d && dp[i - 1][prev][k] != Integer.MAX_VALUE){
                                dp[i][j][d] = Math.min(dp[i][j][d], dp[i - 1][prev][k] + arr[i][j]);
                            }
                        }
                    }
                }
            }
        }
        
        int minSum = Integer.MAX_VALUE;
        for(int i = 0; i < M; i++){
            for(int d = 0; d < 3; d++){
                minSum = Math.min(minSum, dp[N - 1][i][d]);
            }
        }
        
        System.out.println(minSum);
    }
}