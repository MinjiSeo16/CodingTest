import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] order = new int[N];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            order[i] = Integer.parseInt(st.nextToken());
        }
        
        List<Integer> result = new ArrayList<>();
        for(int i = N - 1; i >= 0; i--){
            result.add(order[i], i + 1);
        }
        
        for(int num : result){
            System.out.print(num + " ");
        }
    }
}