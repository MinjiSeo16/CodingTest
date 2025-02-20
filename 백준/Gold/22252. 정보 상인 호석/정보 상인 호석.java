import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int Q = Integer.parseInt(br.readLine());
        Map<String, PriorityQueue<Integer>> map = new HashMap<>();
        long total = 0;
        
        for(int i = 0; i < Q; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int q = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            
            if(q == 1){
                int k = Integer.parseInt(st.nextToken());
                if(map.containsKey(name)){
                    for(int j = 0; j < k; j++){
                        int C = Integer.parseInt(st.nextToken());
                        map.get(name).add(C);
                    }
                }
                else{
                    PriorityQueue<Integer> p = new PriorityQueue<>(Collections.reverseOrder());
                    for(int j = 0; j < k; j++){
                        int C = Integer.parseInt(st.nextToken());
                        p.add(C);
                    }
                    map.put(name, p);
                }
            }
            if(q == 2){
                if(!map.containsKey(name)) continue;
                
                int b = Integer.parseInt(st.nextToken());
                for(int j = 0; j < b && !map.get(name).isEmpty(); j++){
                    total += map.get(name).poll();
                }
            }
        }
        
        System.out.println(total);
    }
}