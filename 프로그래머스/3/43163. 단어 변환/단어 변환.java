import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        boolean[] visit = new boolean[words.length];
        Queue<String> q = new LinkedList<>();
        Queue<Integer> dist = new LinkedList<>();
        
        q.add(begin);
        dist.add(0);
        
        while(!q.isEmpty()) {
            String now = q.poll();
            int cnt = dist.poll();
            
            if(now.equals(target)) return cnt;
            
            for(int i = 0; i < words.length; i++) {
                if(!visit[i] && canChange(now, words[i])) {
                    visit[i] = true;
                    q.add(words[i]);
                    dist.add(cnt + 1);
                }
            }
        }
        
        return 0;
    }
    
    private boolean canChange(String a, String b) {
        int diff = 0;
        for(int i = 0; i < a.length(); i++) {
            if(a.charAt(i) != b.charAt(i)) diff++;
            if(diff > 1) return false;
        }
        return diff == 1;
    }
}