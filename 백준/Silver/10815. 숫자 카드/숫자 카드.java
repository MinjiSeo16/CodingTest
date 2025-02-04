import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int N = Integer.parseInt(br.readLine());
        HashSet<Integer> sangCard = new HashSet<>(); 
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            sangCard.add(Integer.parseInt(st.nextToken()));
        }
        
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < M; i++){
            int num = Integer.parseInt(st.nextToken());
            if(sangCard.contains(num)){
                sb.append("1 ");
            } else{
                sb.append("0 ");
            }
        }
        System.out.println(sb.toString());
    }
}