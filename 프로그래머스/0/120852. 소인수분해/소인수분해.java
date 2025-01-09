import java.util.*;

class Solution {
    public int[] solution(int n) {
        Set<Integer> set = new TreeSet<>();
        
        for(int i = 2; i <= n; i++){
            while(n % i == 0){
                n /= i;
                set.add(i);
            }
        }
        
        return set.stream().mapToInt(Integer::intValue).toArray();
    }
}