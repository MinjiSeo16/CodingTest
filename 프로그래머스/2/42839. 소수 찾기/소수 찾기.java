import java.util.*;

class Solution {
    public int solution(String numbers) {
        Set<Integer> set = new HashSet<>();
        int count = 0;
        
        createNum("", numbers, set);
        
        for(int num : set) {
            if(isPrime(num)) {
                count++;
            }
        }
        
        return count;
    }
    
    private void createNum(String prefix, String num, Set<Integer> set) {
        if(!prefix.isEmpty()) {
            set.add(Integer.parseInt(prefix));
        }
        
        for(int i = 0; i < num.length(); i++) {
            createNum(prefix + num.charAt(i), num.substring(0, i) + num.substring(i + 1), set);
        }
    }
    
    private boolean isPrime(int num) {
        if(num < 2) return false;
        for(int i = 2; i <= Math.sqrt(num); i++) {
            if(num % i == 0) return false;
        }
        return true;
    }
}
