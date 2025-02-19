import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        StringBuilder result = new StringBuilder();
        StringBuilder word = new StringBuilder();
        boolean isTag = false;
        
        for(char c : input.toCharArray()){
            if(c == '<'){
                result.append(word.reverse());
                word = new StringBuilder();
                isTag = true;
                result.append(c);
            }
            else if(c == '>'){
                isTag = false;
                result.append(c);
            }
            else if(isTag){
                result.append(c);
            }
            else{
                if(c == ' '){
                    result.append(word.reverse());
                    result.append(c);
                    word = new StringBuilder();
                }
                else{
                    word.append(c);
                }
            }
        }
        
        result.append(word.reverse());
        System.out.println(result);
    }
}