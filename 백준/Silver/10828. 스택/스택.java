import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        Stack<Integer> stack = new Stack<>();
        
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String word = st.nextToken();
     
            if(word.equals("push")){
                int number = Integer.parseInt(st.nextToken());
                stack.push(number);
            } else if(word.equals("pop")){
                if(stack.isEmpty()){
                    System.out.println(-1);
                }else{
                    System.out.println(stack.pop());
                }
            } else if(word.equals("size")){
                System.out.println(stack.size());
            } else if(word.equals("empty")){
                System.out.println(stack.isEmpty() ? 1 : 0);
            } else if(word.equals("top")){
                if(stack.isEmpty()){
                    System.out.println(-1);
                } else{
                    System.out.println(stack.peek());
                }
            }
        }
    }
}