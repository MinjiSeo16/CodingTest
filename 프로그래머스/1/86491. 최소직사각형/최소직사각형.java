import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        int[] max = new int[sizes.length];
        int[] min = new int[sizes.length];
        
        for(int i = 0; i < sizes.length; i++){
            max[i] = Math.max(sizes[i][0], sizes[i][1]);
            min[i] = Math.min(sizes[i][0], sizes[i][1]);
        }
        
        Arrays.sort(max);
        Arrays.sort(min);
        
        int result = max[max.length - 1] * min[min.length - 1];
        return result;
    }
}