import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
        while(true){
            int N = Integer.parseInt(br.readLine());
            if(N == -1) break;
            
            List<Integer> list = new ArrayList<>();
            int sum = 0;
            
            for(int i=1; i<N; i++){
                if(N % i == 0){
                    list.add(i);
                    sum += i;
                }
            }
            
            if(sum == N){
               System.out.print(N + " = ");
               for(int i=0; i<list.size(); i++){
                   System.out.print(list.get(i));
                   if(i < list.size() - 1){
                       System.out.print(" + ");
                   }
               }
               System.out.println(); 
            } else{
                System.out.println(N + " is NOT perfect.");
            }
        }
    }
}