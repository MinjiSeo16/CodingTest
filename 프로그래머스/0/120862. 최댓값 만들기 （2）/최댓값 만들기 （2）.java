import java.util.Arrays;

class Solution {
    public int solution(int[] numbers) {
        int result = 0;
        Arrays.sort(numbers);
        int max1 = numbers[numbers.length - 1] * numbers[numbers.length - 2];
        int max2 = numbers[0] * numbers[1];
        
        result = Math.max(max1, max2);
        return result;    
    }
}