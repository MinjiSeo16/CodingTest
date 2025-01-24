import java.util.*;
import java.io.*;

public class Main{
    static int M,N,H;
    static int[][][] arr;
    static int[] dx = {0,0,-1,1,0,0};
    static int[] dy = {1,-1,0,0,0,0};
    static int[] dh = {0,0,0,0,1,-1};
    static Queue<int[]> queue;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        
        arr = new int[H][N][M];
        queue = new LinkedList<>();
        boolean allRipe = true;
        
        for(int i = 0; i < H; i++){
            for(int j = 0; j < N; j++){
                st = new StringTokenizer(br.readLine());
                for(int k = 0; k < M; k++){
                    arr[i][j][k] = Integer.parseInt(st.nextToken());
                    if(arr[i][j][k] == 1){
                        queue.offer(new int[]{i,j,k,0});
                    }
                    if(arr[i][j][k] == 0){
                        allRipe = false;
                    }
                }
            }
        }
        if(allRipe){
            System.out.println(0);
            return;
        }
        
        int days = bfs();
        
        for(int i = 0; i < H; i++){
            for(int j = 0; j < N; j++){
                for(int k = 0; k < M; k++){
                    if(arr[i][j][k] == 0){
                        System.out.println(-1);
                        return;
                    }
                }
            }
        }
        System.out.println(days);
    }
    
    static int bfs(){
        int maxDays = 0;
        while(!queue.isEmpty()){
            int[] current = queue.poll();
            int h = current[0];
            int x = current[1];
            int y = current[2];
            int day = current[3];
            maxDays = Math.max(day, maxDays);
            
            for(int i = 0; i < 6; i++){
                int nh = h + dh[i];
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if(nh >= 0 && nx >= 0 && ny >= 0 && nh < H && nx < N && ny < M){
                    if(arr[nh][nx][ny] == 0){
                        arr[nh][nx][ny] = 1;
                        queue.add(new int[]{nh,nx,ny,day + 1});
                    }
                }
            }
        }
        return maxDays;
    }
}
        