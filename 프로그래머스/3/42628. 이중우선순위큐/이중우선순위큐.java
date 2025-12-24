import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        Queue<Integer> p = new PriorityQueue<>();
        Queue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        int[] result = new int[2];
        
        for(String command : operations) {
            if(command.startsWith("I")) {
                String[] str = command.split(" ");
                int num = Integer.parseInt(str[1]);
                p.add(num);
                q.add(num);
            }
            
            if(command.equals("D 1")) {
                if(q.isEmpty()) continue;
                int num = q.poll();
                p.remove(num);
            }
            
            if(command.equals("D -1")) {
                if(p.isEmpty()) continue;
                int num = p.poll();
                q.remove(num);
            }
        }
        
        if(p.isEmpty()) {
            result[0] = 0;
            result[1] = 0;
        } else {
            result[0] = q.peek();
            result[1] = p.peek();
        }
        
        return result;
    }
}