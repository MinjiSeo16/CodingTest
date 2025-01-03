import java.util.*;
import java.io.*; 

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int M = Integer.parseInt(br.readLine());
        
        StringBuilder sb = new StringBuilder(str);
        int idx = str.length();
        
        for(int i = 0; i < M; i++){
            String word = br.readLine();
            char c = word.charAt(0);
            
            switch(c){
                case 'L': 
                    if(idx > 0) idx--;
                    break;
                case 'D':
                    if(idx < sb.length()) idx++;
                    break;
                case 'B':
                    if(idx > 0){
                        sb.deleteCharAt(idx - 1);
                        idx--;
                    }
                    break;
                case 'P':
                    char t = word.charAt(2);
                    sb.insert(idx,t);
                    idx++;
                    break;
            }
        }
        
        System.out.print(sb.toString());
    }
}