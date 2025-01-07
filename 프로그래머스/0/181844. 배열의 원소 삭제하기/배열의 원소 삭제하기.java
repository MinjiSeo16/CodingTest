import java.util.*;

class Solution {
    public int[] solution(int[] arr, int[] delete_list) {
        List<Integer> list = new ArrayList<>();
        
        for(int i = 0; i < arr.length; i++){
            boolean isValid = true;
            
            for(int j = 0; j < delete_list.length; j++){
                if(arr[i] == delete_list[j]){
                    isValid = false;
                    break;
                }
            }
            
            if(isValid) list.add(arr[i]);
        }
        
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}