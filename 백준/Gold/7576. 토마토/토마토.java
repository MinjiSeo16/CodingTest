import java.util.*;
import java.io.*;

public class Main{
    static int N,M;
    static int[][] warehouse;
    static int[][] days;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,-1,1};
    static Queue<int[]> queue = new LinkedList<>();
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        
        warehouse = new int[N][M];
        days = new int[N][M];
        boolean all = true;
        
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                warehouse[i][j] = Integer.parseInt(st.nextToken());
                if(warehouse[i][j] == 1) queue.offer(new int[]{i,j});
                if(warehouse[i][j] == 0){
                    days[i][j] = -1;
                    all = false;
                }
            }
        }
        
        if(all){
            System.out.println(0);
            return;
        }
        
        bfs();
        int result = 0;
        
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(days[i][j] == -1){
                    System.out.println(-1);
                    return;
                }
                result = Math.max(result, days[i][j]);
            }
        }
        System.out.println(result);
    }
    
    public static void bfs(){
        while(!queue.isEmpty()){
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            
            for(int i=0; i<4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if(nx >= 0 && nx < N && ny >= 0 && ny < M){
                    if(days[nx][ny] == -1){
                        days[nx][ny] = days[x][y] + 1;
                        queue.offer(new int[]{nx,ny});
                    }
                }
            }
        }
    }
}