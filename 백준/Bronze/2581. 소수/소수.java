import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());
        
        int sum = 0;
        List<Integer> list = new ArrayList<>();
        
        for(int i=M; i<=N; i++){
            if(i == 1) continue;
            
            boolean isPrime = true;
            for(int j=2; j<i; j++){
                if(i % j == 0){
                    isPrime = false;
                    break;
                }
            }
            if(isPrime){
                list.add(i);
                sum += i;
            }
        }
        
        if(list.size() == 0) System.out.println(-1);
        else{
            System.out.println(sum);
            System.out.println(list.get(0));
        }
    }
}