import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        
        Set<String> set = new HashSet<>();
        for(int i=0; i<N; i++){
            set.add(br.readLine());
        }
        
        List<String> list = new ArrayList<>(set);
        
        Collections.sort(list, (e1, e2) -> {
            if(e1.length() == e2.length()){
                return e1.compareTo(e2);
            } else {
                return e1.length() - e2.length();
            }
        });
        
        for(String word : list){
            sb.append(word).append('\n');
        }
        
        System.out.println(sb);
    }
}
