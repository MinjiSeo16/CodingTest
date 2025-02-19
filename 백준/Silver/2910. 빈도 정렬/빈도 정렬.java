import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        Map<Integer, Integer> map = new LinkedHashMap<>();
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            int num = Integer.parseInt(st.nextToken());
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        List<int[]> list = new ArrayList<>();
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            list.add(new int[]{entry.getKey(), entry.getValue()});
        }
        
        list.sort((a, b) -> b[1] - a[1]);
        
        StringBuilder sb = new StringBuilder();
        for(int[] n : list){
            int num = n[0];
            int count = n[1];
            for(int i = 0; i < count; i++){
                sb.append(num).append(" ");
            }
        }
        
        System.out.println(sb);
    }
}