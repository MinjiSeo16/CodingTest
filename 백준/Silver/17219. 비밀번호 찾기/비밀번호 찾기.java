import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        HashMap<String, String> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            String address = st.nextToken();
            String password = st.nextToken();
            map.put(address, password);
        }
        
        
        for(int i = 0; i < M; i++){
            String input = br.readLine();
            String output = map.get(input);
            sb.append(output).append("\n");
        }
        
        System.out.println(sb.toString());
    }
}