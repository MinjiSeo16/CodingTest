import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        while(T-- > 0){
            char[] commands = br.readLine().toCharArray();
            int n = Integer.parseInt(br.readLine());
            Deque<Integer> deque = new LinkedList<>();
            
            String input = br.readLine();
            if(n > 0){
                input = input.substring(1,input.length() - 1);
                 String[] numbers = input.split(",");
                 for(String num : numbers){
                     deque.add(Integer.parseInt(num));
                 }
            }
            
            boolean reverse = false;
            boolean isError = false;
            
            for(char command : commands){
                if(command == 'R'){
                    reverse = !reverse;
                }
                if(command == 'D'){
                    if(deque.isEmpty()){
                        sb.append("error\n");
                        isError = true;
                        break;
                    }
                    if(reverse){
                        deque.pollLast();
                    }
                    else{
                        deque.pollFirst();
                    }
                }
            }
            if(!isError){
                sb.append("[");
                while(!deque.isEmpty()){
                    sb.append(reverse ? deque.pollLast() : deque.pollFirst());
                    if(!deque.isEmpty()){
                        sb.append(",");
                    }
                }
                sb.append("]\n");
            }
        }
        System.out.print(sb);
    }
}