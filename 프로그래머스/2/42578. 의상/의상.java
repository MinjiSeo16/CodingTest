import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        HashMap<String, Integer> map = new HashMap<>();
        
        for(int i = 0; i < clothes.length; i++){
            map.put(clothes[i][1], 0);
        }
        
        for(int i = 0; i < clothes.length; i++){
            map.put(clothes[i][1], map.get(clothes[i][1]) + 1);
        }
        
        int result = 1;
        
        for(int n : map.values()){
            result *= (n + 1);
        }
        
        return result - 1;
    }
}