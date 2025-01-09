import java.util.Arrays;

class Solution {
    public int solution(int[] array, int n) {
        int min = 100;
        int result = 0;
        
        Arrays.sort(array);
        for(int i = 0; i < array.length; i++){
            if(Math.abs(array[i] - n) < min){
                min = Math.abs(array[i] - n);
                result = array[i];
            }
        }
        
        return result; 
    }
}