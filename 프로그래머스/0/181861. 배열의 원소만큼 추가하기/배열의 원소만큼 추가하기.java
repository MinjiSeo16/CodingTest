import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        List<Integer> list = new ArrayList<>();
        
        for(int i = 0; i < arr.length; i++){
            int a = arr[i];
            for(int j = 0; j < a; j++){list.add(a);}
        }
        
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}