import java.util.*;
import java.io.*;

public class Main{
    static int N, M, V;
    static ArrayList<ArrayList<Integer>> list;
    static boolean[] visit;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());
        
        list = new ArrayList<>();
        for(int i=0; i<=N; i++){
            list.add(new ArrayList<>());
        }
        
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            list.get(node1).add(node2);
            list.get(node2).add(node1);
        }
        
        for(int i=1; i<=N; i++){
            Collections.sort(list.get(i));
        }
        
        visit = new boolean[N+1];
        dfs(V);
        System.out.println();
        
        visit = new boolean[N+1];
        bfs(V);
    }
        
    public static void dfs(int node){
            visit[node] = true;
            System.out.print(node + " ");
            
            for(int k : list.get(node)){
                if(!visit[k]) dfs(k);
            }
     }
        
     public static void bfs(int node){
            Queue<Integer> queue = new LinkedList<>();
            queue.add(node);
            visit[node] = true;
            
            while(!queue.isEmpty()){
                int point = queue.poll();
                System.out.print(point + " ");
                
                for(int k : list.get(point)){
                    if(!visit[k]){
                        visit[k] = true;
                        queue.add(k);
                    }
                }
            }
       }
}