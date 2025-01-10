class Solution {
    public int solution(int[] sides) {
        int count = 0;
        int length = sides[0] + sides[1];
        int max = Math.max(sides[0], sides[1]);
        int min = Math.min(sides[0], sides[1]);
        
        for(int i = max + 1; i < length; i++){
            count++;
        }
        
        for(int i = 1; i <= max; i++){
            if(i + min > max) count++;
        }
        
        return count;
    }
}