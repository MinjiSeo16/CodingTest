import java.util.Arrays;

class Solution {
    public int solution(int[] citations) {
        int result = 0;
        int count = citations.length;
        Arrays.sort(citations);
        
        for(int i = 0; i < count; i++){
            int h = count - i;
            
            if(citations[i] >= h){
                result = h;
                break;
            }
        }
        
        return result;
    }
}