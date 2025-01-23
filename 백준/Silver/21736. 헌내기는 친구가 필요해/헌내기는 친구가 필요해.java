import java.util.*;
import java.io.*;

public class Main{
    static int N, M;
    static char[][] campus;
    static boolean[][] visit;
    static int X, Y;
    static int count = 0;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        campus = new char[N][M];
        visit = new boolean[N][M];
        
        for(int i = 0; i < N; i++){
            String str = br.readLine();
            for(int j = 0; j < M; j++){
                campus[i][j] = str.charAt(j);
                if(str.charAt(j) == 'I'){
                    X = i;
                    Y = j;
                }
            }
        }
        
        bfs(X, Y);
        if(count == 0){
            System.out.println("TT");
        }
        else{
            System.out.println(count);
        }
    }
    
    static void bfs(int startX, int startY){
        visit[startX][startY] = true;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{startX, startY});
        
        while(!queue.isEmpty()){
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            
            for(int i = 0; i < 4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx >= 0 && nx < N && ny >= 0 && ny < M 
                  && !visit[nx][ny] && campus[nx][ny] != 'X'){
                    visit[nx][ny] = true;
                    queue.offer(new int[]{nx, ny});
                    if(campus[nx][ny] == 'P'){
                        count++;
                    }
                }
            }
        }
    }
}