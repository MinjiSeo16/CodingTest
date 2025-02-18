import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        HashMap<Long, Integer> map = new HashMap<>();
        
        for(int i = 0; i < N; i++){
            Long num = Long.parseLong(br.readLine());
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        ArrayList<Long> list = new ArrayList<>(map.keySet());
        list.sort((o1, o2) -> {
            if(map.get(o1).equals(map.get(o2))){
                return Long.compare(o1, o2);
            }
            return map.get(o2) - map.get(o1);
        });
        
        System.out.println(list.get(0));
    }
}