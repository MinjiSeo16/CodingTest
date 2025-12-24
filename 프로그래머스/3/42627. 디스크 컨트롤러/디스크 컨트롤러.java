import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);
        
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> {
            if(a[1] != b[1]) return Integer.compare(a[1], b[1]); 
            return Integer.compare(a[0], b[0]);
        });
        
        int currentTime = 0;
        int total = 0;
        int index = 0;
        int cnt = 0;
        
        while(cnt < jobs.length) {
            while(index < jobs.length && jobs[index][0] <= currentTime) {
                q.add(jobs[index]);
                index++;
            }
            
            if(!q.isEmpty()) {
                int[] job = q.poll();
                currentTime += job[1];
                total += (currentTime - job[0]);
                cnt++;
            } else {
                currentTime = jobs[index][0];
            }
        }
        
        return total/ jobs.length;
    }
}