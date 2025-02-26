import java.util.*;

class Solution {
    public int solution(int N, int number) {
        if(N == number) return 1;
        
        List<Set<Integer>> dp = new ArrayList<>();
        for(int i = 0; i <= 8; i++){
            dp.add(new HashSet<>());
        }
        
        for(int i = 1; i <= 8; i++){
            Set<Integer> set = dp.get(i);
            
            String num = String.valueOf(N).repeat(i);
            set.add(Integer.parseInt(num));
            
            for(int j = 1; j < i; j++){
                for(int n1 : dp.get(j)){
                    for(int n2 : dp.get(i - j)){
                        set.add(n1 + n2);
                        set.add(n1 - n2);
                        set.add(n1 * n2);
                        if(n2 != 0) set.add(n1 / n2);
                    }
                }
            }
            
            if(set.contains(number)){
                return i;
            }
        }
        
        return -1;
    }
}