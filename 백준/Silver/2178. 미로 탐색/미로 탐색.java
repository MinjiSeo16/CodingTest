import java.io.*;
import java.util.*;

public class Main{
    static int N,M;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int[][] maze;
    static boolean[][] isVisited;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        maze = new int[N][M];
        isVisited = new boolean[N][M];
        
        for(int i = 0; i < N; i++){
            String line = br.readLine();
            for(int j = 0; j < M; j++){
                maze[i][j] = line.charAt(j) - '0';
            }
        }
        
        System.out.println(bfs(0,0));
    }
        
    static int bfs(int startX, int startY){
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{startX, startY, 1});
        isVisited[startX][startY] = true;
        
        while(!queue.isEmpty()){
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            int distance = current[2];
            
            if(x == N - 1 && y == M - 1) return distance;
            
            for(int i = 0; i < 4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if(nx >= 0 && nx < N && ny >= 0 && ny < M){
                    if(!isVisited[nx][ny] && maze[nx][ny] == 1){
                        isVisited[nx][ny] = true;
                        queue.offer(new int[]{nx, ny, distance + 1});
                    }
                }
            }
        }
        return -1;
    }
}