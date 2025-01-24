import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        
        int[][] stores = new int[N][3];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            stores[i][0] = Integer.parseInt(st.nextToken());
            stores[i][1] = Integer.parseInt(st.nextToken());
            stores[i][2] = Integer.parseInt(st.nextToken());
        }
        int count = 0;
        for(int i = 123; i <= 987; i++){
            if(!isValid(i)){
                continue;
            }
            boolean possible = true;
            for(int[] store : stores){
                if(!match(i, store[0], store[1], store[2])){
                    possible = false;
                    break;
                }
            }
            if(possible){
                count++;
            }
        }
        System.out.println(count);
    }
    
    static boolean isValid(int num){
        String s = num + "";
        if(s.charAt(0) != s.charAt(1) && s.charAt(0) != s.charAt(2) && s.charAt(1) != s.charAt(2) 
          && !s.contains("0")){
            return true;
        }
        return false;
    }
    
    static boolean match(int random, int input, int strike, int foul){
        String randomNum = random + "";
        String inputNum = input + "";
        
        int s = 0, f = 0;
        for(int i = 0; i < 3; i++){
            if(randomNum.charAt(i) == inputNum.charAt(i)){
                s++;
            }
            else if(inputNum.contains(randomNum.charAt(i) + "")){
                f++;
            }
        }
        
        if(strike == s && foul == f){
            return true;
        }
        return false;
    }
}