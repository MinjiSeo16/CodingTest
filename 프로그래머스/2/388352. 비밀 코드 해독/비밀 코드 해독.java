import java.util.*;

class Solution {
    public int solution(int n, int[][] q, int[] ans) {
        List<int[]> list = new ArrayList<>();
        comb(new ArrayList<>(), 1, n, list);
        int result = 0;
        
        for(int[] nums : list){
            boolean match = true;
            
            for(int i = 0; i < q.length; i++){
                int count = 0;
                
                for(int num : nums){
                    for(int j = 0; j < q[i].length; j++){
                        if(num == q[i][j]) count++;
                    }
                }
                if(ans[i] != count){
                    match = false;
                    break;
                }
            }
            
            if(match) result++;
        }
        
        return result;
    }
    
    public static void comb(List<Integer> current, int start, int n, List<int[]>  list){
        if(current.size() == 5){
            list.add(current.stream().mapToInt(i->i).toArray());
            return;
        }
        
        for(int i = start; i <= n; i++){
            current.add(i);
            comb(current, i + 1, n, list);
            current.remove(current.size() - 1);
        }
    }
}