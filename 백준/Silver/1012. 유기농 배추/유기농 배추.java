import java.util.*;
import java.io.*;

public class Main{
    static int N, M;
    static int[][] arr;
    static boolean[][] visit;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        int test = 0;
        while(true){
            if(test == T) break;
         
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            
            arr = new int[N][M];
            visit = new boolean[N][M];
        
            for(int i=0; i<K; i++){
                st = new StringTokenizer(br.readLine());
                int X = Integer.parseInt(st.nextToken());
                int Y = Integer.parseInt(st.nextToken());
                arr[X][Y] = 1;
            }
        
            int count = 0;
            for(int i=0; i<N; i++){
                for(int j=0; j<M; j++){
                    if(arr[i][j] == 1 && !visit[i][j]){
                        dfs(i,j);
                        count++;
                    }
                }
            }
            sb.append(count).append("\n");
            test++;
        }
        System.out.print(sb);
    }

    static void dfs(int x, int y){
        visit[x][y] = true;
        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            if(nx >= 0 && nx < N && ny >= 0 && ny < M){
                if(arr[nx][ny] == 1 && !visit[nx][ny]){
                    dfs(nx, ny);
                }
            }
        }
    }
}