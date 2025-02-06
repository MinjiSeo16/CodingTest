import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int count = 0; 
        Queue<Integer> q = new PriorityQueue<>();
        
        for(int i = 0; i < scoville.length; i++){
            q.offer(scoville[i]);
        }
        
        while(q.size() >= 2 && q.peek() < K){            
            int num1 = q.poll();
            int num2 = q.poll();
            int newValue = num1 + (num2 * 2);
            q.offer(newValue);
            count++;
        }
        
        if(q.peek() < K){
            return -1;
        }
            
        return count;
    }
}