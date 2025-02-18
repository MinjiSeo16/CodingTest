import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Map<String, Integer> map = new HashMap<>();
        
        for(int i = 0; i < N; i++){
            String word = br.readLine();
            if(word.length() < M) continue;
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        
        List<String> words = new ArrayList<>(map.keySet());
        words.sort((o1, o2) -> {
            int freq = Integer.compare(map.get(o2), map.get(o1));
            if(freq != 0) return freq;
            
            int len = Integer.compare(o2.length(), o1.length());
            if(len != 0) return len;
            
            return o1.compareTo(o2);
        });
        
        StringBuilder sb = new StringBuilder();
        for(String str : words){
            sb.append(str).append("\n");
        }
        
        System.out.println(sb);
    }
}