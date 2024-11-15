import java.io.*;
import java.util.*;

public class Main{
    static int N;
    static int[][] arr;
    static boolean[] visited;
    static int minDifference = Integer.MAX_VALUE;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        visited = new boolean[N];
        
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        calculateMin(0,0);
        System.out.println(minDifference);
    }
    
    public static void calculateMin(int index, int count){
        if(count == N/2){
            int startTeam = 0;
            int linkTeam = 0;
            
            for(int i=0; i<N-1; i++){
                for(int j=i+1; j<N; j++){
                    if(visited[i] && visited[j]){
                        startTeam += arr[i][j];
                        startTeam += arr[j][i];
                    } else if(!visited[i] && !visited[j]){
                        linkTeam += arr[i][j];
                        linkTeam += arr[j][i];
                    }
                }
            }
 
            minDifference = Math.min(minDifference, Math.abs(startTeam - linkTeam));
            return;
        }
    
        for(int i=index; i<N; i++){
            if(!visited[i]){
                visited[i] = true;
                calculateMin(i+1,count+1);
                visited[i] = false;
            }
        }
    }
}