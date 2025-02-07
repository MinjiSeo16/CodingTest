import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        Queue<Integer> q = new PriorityQueue<>();
        Queue<Integer> p = new PriorityQueue<>(Collections.reverseOrder());
        int[] result = new int[2];
        
        for(String command : operations){
            if(command.startsWith("I")){
                String[] str = command.split(" ");
                int num = Integer.parseInt(str[1]);
                q.add(num);
                p.add(num);
            }
            
            if(command.equals("D -1")){
                if(!q.isEmpty()){
                    int min = q.poll();
                    p.remove(min);
                }
            }
            
            if(command.equals("D 1")){
                if(!p.isEmpty()){
                    int max = p.poll();
                    q.remove(max);
                }
            }
        }
        
        if(!q.isEmpty()){
            result[0] = p.peek();
            result[1] = q.peek();
        }
        else{
            result[0] = 0;
            result[1] = 0;
        }
        
        return result;
    }
}