import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        Queue<Integer> queue = new PriorityQueue<>();
        int count = 0;
        
        for(int s : scoville) {
            queue.offer(s);
        }
        
        while(queue.size() >= 2) {
            int scov1 = queue.poll();
            
            if(scov1 >= K) break;
            else {
                int scov2 = queue.poll();
                int new_scov = scov1 + (scov2 * 2);
                count++;
                queue.offer(new_scov);
            }
        }
        
        if(queue.peek() < K) return -1;
        
        return count;
    }
}