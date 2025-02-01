import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N][20];
        
        while(M-- > 0){
            st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());
            int train = Integer.parseInt(st.nextToken()) - 1;
            
            if(command == 1){
                int index = Integer.parseInt(st.nextToken());
                arr[train][index - 1] = 1;
            }
            
            if(command == 2){
                int index = Integer.parseInt(st.nextToken());
                arr[train][index - 1] = 0;
            }
            
            if(command == 3){
                for(int i = 19; i > 0; i--){
                    arr[train][i] = arr[train][i - 1];
                }
                arr[train][0] = 0;
            }
            
            if(command == 4){
                for(int i = 0; i < 19; i++){
                    arr[train][i] = arr[train][i + 1];
                }
                arr[train][19] = 0;
            }
        }
        
        Set<String> trains = new HashSet<>();
        int count = 0;
        for(int i = 0; i < N; i++){
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < 20; j++){
                sb.append(arr[i][j]);
            }
            String s = sb.toString();
            if(trains.add(s)){
                count++;
            }
        }
        System.out.println(count);
    }
}