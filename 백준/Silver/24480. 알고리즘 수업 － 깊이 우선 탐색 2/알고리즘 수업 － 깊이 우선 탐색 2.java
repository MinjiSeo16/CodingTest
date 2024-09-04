import java.util.*;
import java.io.*;

public class Main{
    static int N,M,R;
    static int count = 1; 
    static int[] order; 
    static ArrayList<ArrayList<Integer>> list; 
    static boolean[] visit;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
        
        order = new int[N+1];
        visit = new boolean[N+1];
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
            Collections.sort(list.get(i), Collections.reverseOrder());
        }
        
        dfs(R);

        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=N; i++){
            sb.append(order[i]).append('\n');
        }
        System.out.print(sb);
    }

    public static void dfs(int node){
        visit[node] = true;
        order[node] = count++;
        
        for(int k : list.get(node)){  
            if(!visit[k]){ 
                dfs(k);
            }
        }
    }
}
