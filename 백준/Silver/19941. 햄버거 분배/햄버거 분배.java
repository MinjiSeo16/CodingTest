import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        char[] arr = br.readLine().toCharArray();
        
        int count = 0;
        for(int i = 0; i < N; i++){
            if(arr[i] == 'P'){
                for(int j = -K; j <= K; j++){
                    int idx = i + j;
                    if(idx >= 0 && idx < N && arr[idx] == 'H'){
                        count++;
                        arr[idx] = 'X';
                        break;
                    }
                }
            }
        }
        
        System.out.println(count);
    }
}