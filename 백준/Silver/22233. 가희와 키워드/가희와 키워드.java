import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        Set<String> keywords = new HashSet<>();
        for(int i = 0; i < N; i++){
            String k = br.readLine();
            keywords.add(k);
        }
        
        StringBuilder sb = new StringBuilder();
        while(M-- > 0){
            String[] str = br.readLine().split(",");
            for(int i = 0; i < str.length; i++){
                String s = str[i];
                if(keywords.contains(s)){
                    keywords.remove(s);
                }
            }
            sb.append(keywords.size()).append("\n");
        }
        
        System.out.println(sb);
    } 
}