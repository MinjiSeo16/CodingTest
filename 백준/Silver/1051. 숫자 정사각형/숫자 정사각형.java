import java.io.*;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int maxSize = 1;
        
        int[][] arr = new int[N][M];
        for(int i=0; i<N; i++){
            String line = br.readLine();
            for(int j=0; j<M; j++){
                arr[i][j] = line.charAt(j) - '0';
            }
        }
        
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                for(int size=1; i+size < N && j+size < M; size++){
                    if(arr[i][j] == arr[i + size][j] && 
                       arr[i][j] == arr[i][j + size] &&
                       arr[i][j] == arr[i + size][j + size]){
                       maxSize = Math.max(maxSize, (size+1)*(size+1));
                    }
                }
            }
        }
        System.out.println(maxSize);
    }
}