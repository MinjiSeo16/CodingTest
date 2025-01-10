class Solution {
    public int solution(int[][] lines) {
        int[] range = new int[201];
        
        for(int[] line : lines){
            int s = line[0] + 100;
            int e = line[1] + 100;
            
            for(int i = s; i < e; i++){
                range[i]++;
            }
        }
        
        int result = 0;
        for(int c : range){
            if(c >= 2) result++;
        }
        
        return result;
    }
}