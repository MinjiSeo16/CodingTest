import java.util.*;

class Solution {
    public int solution(int n, int[][] wires) {
        List<List<Integer>> link = new ArrayList<>();
        
        for(int i = 0; i <= n; i++){
            link.add(new ArrayList<>());
        }
        
        for(int i = 0; i < wires.length; i++){
            int v1 = wires[i][0];
            int v2 = wires[i][1];
            link.get(v1).add(v2);
            link.get(v2).add(v1);
        }
        
        int minDiff = Integer.MAX_VALUE;
        for(int[] wire : wires){
            int v1 = wire[0];
            int v2 = wire[1];
            link.get(v1).remove((Integer)v2);
            link.get(v2).remove((Integer)v1);
            
            boolean[] visited = new boolean[n + 1];
            int size1 = dfs(v1, link, visited);
            int size2 = n - size1;
            
            minDiff = Math.min(minDiff, Math.abs(size1 - size2));
            link.get(v1).add(v2);
            link.get(v2).add(v1);
        }
        
        return minDiff;
    }
    
    public int dfs(int s, List<List<Integer>> link, boolean[] visited){
        visited[s] = true;
        int size = 1;
        for(int next : link.get(s)){
            if(!visited[next]){
                size += dfs(next, link, visited);
            }
        }
        return size;
    }
}