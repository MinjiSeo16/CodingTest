import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Queue<Integer> p = new PriorityQueue<>();
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < N; i++){
            int num = Integer.parseInt(br.readLine());
            if(num == 0){
                if(p.isEmpty()){
                    sb.append("0").append("\n");
                }
                else{
                    sb.append(p.poll()).append("\n");
                }
            }
            
            if(num != 0){
                p.offer(num);
            }
        }
        
        System.out.print(sb.toString());
    }
}