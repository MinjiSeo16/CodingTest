import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[] position = new int[M];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++){
            position[i] = Integer.parseInt(st.nextToken());
        }
        
        int heightMax = position[0];
        
        for(int i = 1; i < M; i++){
            int h = position[i] - position[i - 1];
            heightMax = Math.max(heightMax, (h + 1) / 2);
        }
        heightMax = Math.max(heightMax, N - position[M - 1]);
        
        System.out.println(heightMax);
    }
}