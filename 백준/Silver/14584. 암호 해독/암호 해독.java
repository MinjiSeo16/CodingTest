import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String password = br.readLine();
        int N = Integer.parseInt(br.readLine());
        String[] arr = new String[N];
        
        for(int i = 0; i < N; i++){
            arr[i] = br.readLine();
        }
        
        for(int i = 1; i <= 26; i++){
            StringBuilder string = new StringBuilder();
            for(int j = 0; j < password.length(); j++){
                char ch = password.charAt(j);
                char decode = (char)('a' + (ch - 'a' + i) % 26);
                string.append(decode);
            }
            String decodeString = string.toString();
            for(String word : arr){
                if(decodeString.contains(word)){
                    System.out.println(decodeString);
                    return;
                }
            }
        }
    }
}