import java.util.*;

class Solution {
    public int[] solution(int[] arr, int k) {
        int[] result = new int[k];
        Arrays.fill(result, -1);
        Set<Integer> set = new HashSet<>();
        int count = 0;
        
        for(int num : arr){
            if(set.add(num)){ 
                result[count++] = num;
            }
            if(count >= k) break;
        }
        
        return result;
    }
}