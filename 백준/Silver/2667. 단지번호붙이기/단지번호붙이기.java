import java.util.*;
import java.io.*;

public class Main{
    static int N;
    static int[][] arr;
    static boolean[][] visit;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static int total_count = 0;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        visit = new boolean[N][N];
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0; i<N; i++){
            String line = br.readLine();
            for(int j=0; j<N; j++){
                arr[i][j] = line.charAt(j) - '0';
            }
        }
        
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(arr[i][j] == 1 && !visit[i][j]){
                    int count = dfs(i,j);
                    list.add(count);
                    total_count ++;
                }
            }
        }
        System.out.println(total_count);
        Collections.sort(list);
        for(int n : list){
            System.out.println(n);
        }
    }
    
    static int dfs(int x,int y){
        visit[x][y] = true;
        int count = 1;
        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            if(nx >= 0 && nx < N && ny >= 0 && ny < N){
                if(arr[nx][ny] == 1 && !visit[nx][ny]){
                     count += dfs(nx,ny);
                }
            }
        }
        return count;
    }
}