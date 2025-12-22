import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        Deque<int[]> deque = new LinkedList<>();
        int count = 0;
        
        for(int i = 0; i < priorities.length; i++) {
            deque.offer(new int[]{priorities[i], i});
        }
        
        while(!deque.isEmpty()) {
            int[] current = deque.pollFirst();
            
            if(isExistBigger(current[0], deque)) {
                deque.addLast(current);
            } else {
                count++;
                if(location == current[1]) {
                    return count;
                }
            }
        }
        
        return count;
    }
    
    private boolean isExistBigger(int n, Deque<int[]> deque) {
        for(int[] d : deque) {
            if(d[0] > n) {
                return true;
            }
        }
        
        return false;
    }
}