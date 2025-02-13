import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int[] arr = new int[20];
        
        while(T-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int count = 0;
            
            for(int i = 0; i < 20; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }
            
            for(int i = 0; i < 20; i++){
                for(int j = 0; j < i; j++){
                    if(arr[j] > arr[i]){
                        count++;
                    }
                }
            }
            System.out.println(num + " " + count);
        }
    }
}