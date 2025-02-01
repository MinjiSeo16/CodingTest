import java.util.*;

class Solution {
    public ArrayList<Integer> solution(int[] progresses, int[] speeds) {
        Queue<Integer> queue = new LinkedList<>();
        ArrayList<Integer> result = new ArrayList<>();
        
        for(int i = 0; i < speeds.length; i++){
            queue.offer(getRestDays(progresses[i], speeds[i]));
        }
        
        int max = queue.poll();
        int count = 1;
        while(!queue.isEmpty()){
            int restDays = queue.poll();
            
            if(restDays <= max){
                count++;
            }
            
            if(restDays > max){
                result.add(count);
                max = restDays;
                count = 1;
            }
        }
        result.add(count);
        
        return result;
    }
    
    public static int getRestDays(int p, int s){
        if((100 - p) % s != 0){
            return (100 - p) / s + 1;
        }
        return (100 - p) / s;
    }
}