import java.util.*;
import java.io.*;

public class Main{
    static int N, T;
    static ArrayList<ArrayList<Integer>> list;
    static boolean[] visit;
    static int count = 0;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        T = Integer.parseInt(br.readLine());
        visit = new boolean[N + 1];
        
        list = new ArrayList<>();
        for(int i = 0; i <= N; i++){
            list.add(new ArrayList<>());
        }
        
        StringTokenizer st;
        for(int i = 0; i < T; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.get(a).add(b);
            list.get(b).add(a);
        }
        
        dfs(1);
        System.out.println(count);
    }
    
    public static void dfs(int start){
        visit[start] = true;
        for(int n : list.get(start)){
            if(!visit[n]){
                count++;
                dfs(n);
            }
        }
    }
}