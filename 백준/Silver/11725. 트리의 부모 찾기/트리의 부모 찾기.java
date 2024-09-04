import java.util.*;
import java.io.*;

public class Main{
    static int N; 
    static int[] parent; 
    static ArrayList<ArrayList<Integer>> list; 
    static boolean[] visit;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());  
        
        parent = new int[N+1];
        visit = new boolean[N+1];
        list = new ArrayList<>();

        for(int i=0; i<=N; i++){
            list.add(new ArrayList<>());
        }
        
        for(int i=1; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            
            list.get(node1).add(node2);
            list.get(node2).add(node1);
        }
        dfs(1);

        StringBuilder sb = new StringBuilder(); 
        for(int i=2; i<=N; i++){ 
            sb.append(parent[i]).append('\n');
        }
        System.out.print(sb.toString());
    }

    public static void dfs(int node){
        visit[node] = true; 
        for(int k : list.get(node)){  
            if(!visit[k]){ 
                parent[k] = node;  
                dfs(k);
            }
        }
    }
}
