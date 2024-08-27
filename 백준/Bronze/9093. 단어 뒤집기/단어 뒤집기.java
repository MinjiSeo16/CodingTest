import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        
        while(T-- > 0){
            Stack<Character> stack = new Stack<>();
            String string = br.readLine() + "\n";
            for(char c : string.toCharArray()){
                if(c == ' ' || c == '\n'){
                    while(!stack.isEmpty()){
                        sb.append(stack.pop());
                    }
                    sb.append(c);
                }
                else{
                    stack.push(c);
                }
            }
        }
        System.out.println(sb);
    }
}