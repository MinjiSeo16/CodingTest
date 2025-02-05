import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        HashMap<Integer, Integer> map = new HashMap<>();
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        
        for(int i = 1; i <= N; i++){
            map.put(i, 1);
            graph.put(i, new ArrayList<>());
        }
        
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            graph.get(B).add(A);
        }
        
        for(int i = 1; i <= N; i++){
            for(int n : graph.get(i)){
                map.put(i, Math.max(map.get(i), map.get(n) + 1));
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= N; i++){
            sb.append(map.get(i)).append(" ");
        }
        
        System.out.println(sb.toString());
    }
}