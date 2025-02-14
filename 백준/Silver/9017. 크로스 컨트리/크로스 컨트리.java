import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        while(T-- > 0){
            int N = Integer.parseInt(br.readLine());
            Map<Integer, List<Integer>> map = new HashMap<>();
            int[] count = new int[201];
            int[] team = new int[N];
            
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++){
                team[i] = Integer.parseInt(st.nextToken());
                count[team[i]]++;
            }
            
            int rank = 1;
            for(int i = 0; i < N; i++){
                int num = team[i];
                if(count[num] >= 6){
                    map.putIfAbsent(num, new ArrayList<>());
                    map.get(num).add(rank++);
                }
            }
            
            Map<Integer, Integer> sum = new HashMap<>();
            for(int i : map.keySet()){
                int total = 0;
                for(int j = 0; j < 4; j++){
                    total += map.get(i).get(j);
                }
                sum.put(i, total);
            }
            
            int min = Integer.MAX_VALUE, idx = -1;
            for(int i : sum.keySet()){
                if(min > sum.get(i)){
                    min = sum.get(i);
                    idx = i;
                }
                if(min == sum.get(i)){
                    if(map.get(idx).get(4) > map.get(i).get(4)){
                        idx = i;
                    }
                }
            }
            System.out.println(idx);
        }
    }
}