import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int count = 0;
        int endTime = 0;
        
        List<int[]> list = new ArrayList<>();
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            list.add(new int[]{start, end});
        }
        
        list.sort((a,b) -> {
            if(a[1] == b[1]){
                return Integer.compare(a[0],b[0]);
            }
            return Integer.compare(a[1], b[1]);
        });
        
        for(int[] meet : list){
            if(endTime <= meet[0]){
                count++;
                endTime = meet[1];
            }
        }
        
        System.out.println(count);
    }
}