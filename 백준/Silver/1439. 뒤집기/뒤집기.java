import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        
        int oneCount = 0, zeroCount = 0;
        
        for(int i = 0; i < input.length() - 1; i++){
            if(input.charAt(i) == '1' && input.charAt(i + 1) == '0'){
                oneCount++;
            }
            
            if(input.charAt(i) == '0' && input.charAt(i + 1) == '1'){
                zeroCount++;
            }
        }
        
        if(input.charAt(input.length() - 1) == '0'){
            zeroCount++;
        } else{
            oneCount++;
        }
        
        int result = Math.min(zeroCount, oneCount);
        System.out.println(result);
    }
}