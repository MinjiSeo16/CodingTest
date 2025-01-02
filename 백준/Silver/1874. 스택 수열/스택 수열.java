import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        int start = 1;
        
        while(T-- > 0){
            int N = Integer.parseInt(br.readLine());
            
            for(int i = start; i <= N; i++){
                stack.push(i);
                sb.append("+").append("\n");
                start++;
            }
            
            if(stack.peek() == N){
                stack.pop();
                sb.append("-").append("\n");
            } else{
                System.out.println("NO");
                return;
            }
        }
        System.out.println(sb);
    }
}