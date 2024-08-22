import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int count = 0;
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            int k = Integer.parseInt(st.nextToken());
            boolean isPrime = true;
            
            if(k==1) continue;
            
            for(int j=2; j<k; j++){
                if(k % j == 0){
                    isPrime = false;
                }
            }
            if(isPrime) count++;
        }
        System.out.println(count);
    }        
}