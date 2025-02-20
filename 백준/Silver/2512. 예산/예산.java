import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        long sum = 0;
        
        int max = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            sum += arr[i];
            if(max < arr[i]){
                max = arr[i];
            }
        }
        
        int M = Integer.parseInt(br.readLine());
        if(M >= sum){
            System.out.println(max);
            return;
        }
        
        int left = 1;
        int right = max;
        int answer = 0;
        
        while(left <= right){
            int mid = (left + right) / 2;
            long total = 0;
            
            for(int n : arr){
                total += Math.min(n, mid);
            } 
            if(total <= M){
                answer = mid;
                left = mid + 1;
            } else{
                right = mid - 1;
            }
        }
        
        System.out.println(answer);
    }
}