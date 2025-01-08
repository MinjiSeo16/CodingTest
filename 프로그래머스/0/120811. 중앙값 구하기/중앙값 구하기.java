import java.util.Arrays;

class Solution {
    public int solution(int[] array) {
        int idx = array.length / 2;
        Arrays.sort(array);
        
        return array[idx];
    }
}