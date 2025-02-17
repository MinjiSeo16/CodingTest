import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] price = new long[N];
        long[] distance = new long[N - 1];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N - 1; i++){
            distance[i] = Long.parseLong(st.nextToken());
        }
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            price[i] = Long.parseLong(st.nextToken());
        }
        
        long result = 0;
        long minPrice = price[0];
        for(int i = 0; i < N - 1; i++){
            if(price[i] < minPrice){
                minPrice = price[i];
            }
            result += minPrice * distance[i];
        }
        
        System.out.println(result);
    }
}