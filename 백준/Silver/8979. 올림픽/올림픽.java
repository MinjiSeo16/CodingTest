import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N + 1][4];
        int rank = 1;
        
        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());
            int idx =  Integer.parseInt(st.nextToken());
            arr[idx][1] = Integer.parseInt(st.nextToken());
            arr[idx][2] = Integer.parseInt(st.nextToken());
            arr[idx][3] = Integer.parseInt(st.nextToken());
        }
        
        int[] target = arr[K];
        for(int i = 1; i <= N; i++){
            if(i == K) continue;
            if(arr[i][1] > target[1] || 
               (arr[i][1] == target[1] && arr[i][2] > target[2]) || 
               (arr[i][1] == target[1] && arr[i][2] == target[2] && arr[i][3] > target[3])){
                rank++;
            }
        }
        
        System.out.println(rank);
    }
}