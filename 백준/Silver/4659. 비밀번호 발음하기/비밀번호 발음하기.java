import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        while(true){
            String password = br.readLine();
            if(password.equals("end")) break;
            
            boolean vowel = false;
            boolean isAccept = true;
            int countV = 0, countC = 0;
            
            for(int i = 0; i < password.length(); i++){
                char c = password.charAt(i);
                
                if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 
                  'u'){
                    vowel = true;
                    countV++;
                    countC = 0;
                }
                else{
                    countC++;
                    countV = 0;
                }
                
                if(countC >= 3 || countV >= 3){
                    isAccept = false;
                    break;
                }
                
                if(i > 0 && password.charAt(i) == password.charAt(i - 1)){
                    if(c != 'e' && c != 'o'){
                        isAccept = false;
                        break;
                    }
                }
            }
            
            if(vowel && isAccept){
                sb.append("<").append(password).append("> is acceptable.\n");
            } else{
                sb.append("<").append(password).append("> is not acceptable.\n");
            }
        }
        System.out.print(sb.toString());
    }
}