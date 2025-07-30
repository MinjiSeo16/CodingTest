import java.util.Collections;
import java.util.PriorityQueue;

class Solution {
    public long solution(int n, int[] works) {
        
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

        for(int work : works){
            queue.add(work);
        }
        
        while(n > 0 && !queue.isEmpty()){
            int work = queue.poll();
            if(work > 0) {
                queue.add(work - 1);
            }
            n--;
        }
        
        long sum = 0; 
        while(!queue.isEmpty()){
            int w = queue.poll();
            sum += (long) w * w;
        }
        
        return sum;
    }
}