import java.util.*;
import java.io.*;

public class Main{
    static int N,M;
    static ArrayList<ArrayList<Integer>> list;
    static boolean[] visit;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visit = new boolean[N+1];
        
        list = new ArrayList<>();
        for(int i=0; i<=N; i++){
            list.add(new ArrayList<>());
        }
        
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            list.get(u).add(v);
            list.get(v).add(u);
        }
        
        int count = 0;
        for(int i=1; i<=N; i++){
            if(!visit[i]){
                dfs(i);
                count++;
            }
        }
        System.out.println(count);
    }
    
    static void dfs(int node){
        visit[node] = true;
        for(int n : list.get(node)){
            if(!visit[n]){
                dfs(n);
            }
        }
    }
    
}