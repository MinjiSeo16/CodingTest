import java.io.*;
import java.util.*;

public class Main{
    static ArrayList<ArrayList<Integer>> tree; 
    static int N; 
    static int leafCount; 

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken()); 

        tree = new ArrayList<>();
        for(int i=0; i<=N; i++){
            tree.add(new ArrayList<>());
        }

        for (int i=0; i<N-1; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken()); 
            int v = Integer.parseInt(st.nextToken()); 
            tree.get(u).add(v);
            tree.get(v).add(u);
        }

        boolean[] visited = new boolean[N + 1]; 
        leafCount = 0; 
      
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1); 
        visited[1] = true; 
        
        while(!queue.isEmpty()){
            int node = queue.poll(); 
            boolean isLeaf = true; 

            for(int next : tree.get(node)){
                if(!visited[next]){ 
                    queue.add(next); 
                    visited[next] = true; 
                    isLeaf = false;
                }
            }
            if(isLeaf){
                leafCount++; 
            }
        }
        double result = (double) W / leafCount; 
        System.out.printf("%.10f\n", result);
    }
}
