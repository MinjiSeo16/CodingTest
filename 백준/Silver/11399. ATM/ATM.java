import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Integer[] time = new Integer[N];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            time[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(time);
        
        int sum = 0, result = 0;
        for(int i = 0; i < N; i++){
            sum += time[i];
            result += sum;
        }
        
        System.out.println(result);
    }
}