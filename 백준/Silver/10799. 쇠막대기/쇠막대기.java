import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        Stack<Character> stack = new Stack<>();
        int result = 0;
        
        for(int i = 0; i < input.length(); i++){
            if(input.charAt(i) == '('){
                stack.push('(');
                continue;
            }
            if(input.charAt(i) == ')'){
                stack.pop();
                
                if(input.charAt(i - 1) == '('){
                    result += stack.size();
                }
                else{
                    result++;
                }
            }
        }
        
        System.out.println(result);
    }
}