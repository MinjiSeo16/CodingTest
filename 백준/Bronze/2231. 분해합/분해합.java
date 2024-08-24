import java.io.*;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int result = 0;
        
        for(int i=1; i<N; i++){
            int sum = i; 
            int n = i;
            
            while(n != 0){
                sum += n % 10;
                n /= 10;
            }
            
            if(sum == N){
                result = i;
                break;
            }
        }
        System.out.println(result);
    }
}