import java.io.*;
import java.util.*;

public class Main{
    static int n, m;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,1,-1};
    static int[][] paint;
    static boolean[][] isVisited;
    
    public static void  main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        paint = new int[n][m];
        isVisited = new boolean[n][m];
        int maxArea = 0;
        int count = 0;
        
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                paint[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(paint[i][j] == 1 && !isVisited[i][j]){
                    int area = dfs(i, j);
                    count++;
                    if(maxArea < area) maxArea = area;
                }
            }
        }
        System.out.println(count);
        System.out.println(maxArea);
    }
    
    public static int dfs(int x, int y){
        isVisited[x][y] = true;
        int area = 1;
        
        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
                
            if(nx >= 0 && nx < n && ny >= 0 && ny < m){
                if(paint[nx][ny] == 1 && !isVisited[nx][ny]){
                    area += dfs(nx, ny);
                 }
             }
        }
        return area;
    }
}