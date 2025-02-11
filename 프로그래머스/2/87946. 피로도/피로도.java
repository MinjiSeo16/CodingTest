import java.util.*;

class Solution {
    static Queue<int[]> queue = new LinkedList<>();
    
    public int solution(int k, int[][] dungeons) {
        int maxCount = 0; 
        getOrder(dungeons.length, new int[dungeons.length], new boolean[dungeons.length], 0);
        
        while(!queue.isEmpty()){
            int[] n = queue.poll();
            int count = 0; 
            int current_k = k;
            for(int i = 0; i < n.length; i++){
                int index = n[i];
                if(current_k >= dungeons[index][0]){
                    current_k -= dungeons[index][1];
                    count++;
                }
                else{
                    break;
                }
            }
            
            maxCount = Math.max(maxCount, count);
        }
        
        return maxCount;
    }
    
    public static void getOrder(int l, int[] current, boolean[] visited, int depth){
        if(depth == l){
            queue.offer(current.clone());
            return;
        }
        
        for(int i = 0; i < l; i++){
            if(!visited[i]){
                visited[i] = true;
                current[depth] = i;
                getOrder(l, current, visited, depth + 1);
                visited[i] = false;
            }
        }
    }
}