import java.util.*;

class Solution {
    public int solution(int n) {
        List<Integer> list = new ArrayList<>();
        
        for(int i = 0; i < 1000; i++){
            if(i % 3 != 0 && !(i + "").contains("3")){
                list.add(i);
            }
        }
        
        return list.get(n - 1);
    }
}