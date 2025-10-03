import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int time = 0;
        HashSet<String> map = new HashSet<>();  //존재여부확인(miss vs hit)
        Deque<String> deque = new ArrayDeque<>();  //Cache
        
        if (cacheSize == 0) return cities.length * 5;
        
        for(int i = 0; i < cities.length; i++) {
            String city = cities[i].toLowerCase();
            
            //miss
            if(!map.contains(city)) {
                time += 5;
                if(deque.size() < cacheSize) {
                    deque.offer(city);
                    map.add(city);
                } else {
                    String c = deque.pollFirst();
                    map.remove(c);
                    deque.offer(city);
                    map.add(city);
                }
            }
            
            //hit
            else {
                time += 1;
                deque.remove(city);
                deque.offer(city);
            }
        }
        
        return time;
    }
}