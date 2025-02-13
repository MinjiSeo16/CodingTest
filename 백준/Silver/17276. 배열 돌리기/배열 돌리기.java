import java.io.*;
import java.util.*;

public class Main {
    static int n, angle;
    static int[][] arr, copy;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        
        while(T-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            angle = Integer.parseInt(st.nextToken());
            if(angle < 0){
                angle += 360;
            }
            angle /= 45;
            
            arr = new int[n][n];
            copy = new int[n][n];
            for(int i = 0; i < n; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < n; j++){
                    arr[i][j] = Integer.parseInt(st.nextToken());
                    copy[i][j] = arr[i][j];
                }
            }
            
            while(angle-- > 0){
                rotate();
            }
            
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    sb.append(arr[i][j]).append(" ");
                }
                sb.append('\n');
            }
        }
        
        System.out.println(sb);
    }
    
    public static void rotate(){
        for(int i = 0; i < n; i++){
            copy[i][n / 2] = arr[i][i];
            copy[i][i] = arr[n / 2][i];
            copy[n / 2][i] = arr[n - i - 1][i];
            copy[n - i - 1][i] = arr[n - i - 1][n / 2];
        }
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                arr[i][j] = copy[i][j];
            }
        }
    }
}