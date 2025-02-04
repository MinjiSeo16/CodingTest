import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        
        while(T-- > 0){
            int n = Integer.parseInt(br.readLine());
            HashMap<String, Integer> map = new HashMap<>();
            
            for(int i = 0; i < n; i++){
                st = new StringTokenizer(br.readLine());
                String name = st.nextToken();
                String type = st.nextToken();
                
                if(map.containsKey(type)){
                    map.put(type, map.get(type) + 1);
                }
                else{
                    map.put(type, 1);
                }
            }
            
            int result = 1;
            for(int count : map.values()){
                result *= (count + 1);
            }
            
            System.out.println(result - 1);
        }
    }
}