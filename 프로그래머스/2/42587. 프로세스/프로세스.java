import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        Deque<int[]> deque = new LinkedList<>(); 
        int count = 0;
        
        for(int i = 0; i < priorities.length; i++){
            deque.add(new int[]{priorities[i], i});
        }
        
        while(!deque.isEmpty()){
            int[] current = deque.pollFirst();
            
            if(isExistBigger(current[0], deque)){
                deque.addLast(current);
            } else{
                count++;
                if(current[1] == location){
                    return count;
                }
            }
        }
        return count;
    }
    
    public static boolean isExistBigger(int n, Deque<int[]> deque){
        for(int[] arr : deque){
            if(arr[0] > n){
                return true;
            }
        }
        
        return false;
    }
}