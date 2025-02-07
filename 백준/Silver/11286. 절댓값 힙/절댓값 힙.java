import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        PriorityQueue<Integer> queue = new PriorityQueue<>(
        (a, b) -> Math.abs(a) == Math.abs(b) ? Integer.compare(a, b) : Integer.compare(Math.abs(a), Math.abs(b))
        );
        
        for(int i = 0; i < N; i++){
            int num = Integer.parseInt(br.readLine());
            if(num != 0){
                queue.add(num);
            }
            else{
                if(queue.isEmpty()){
                    sb.append("0").append("\n");
                }
                else{
                    sb.append(queue.poll()).append("\n");
                }
            }
        }
        
        System.out.print(sb);
    }
}