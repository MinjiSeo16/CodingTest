class Solution {
    public double solution(int[] numbers) {
        double result = 0;
        int sum = 0;
        
        for(int i = 0; i < numbers.length; i++){
            sum += numbers[i];
        }
        
        result = (double)sum / numbers.length;
        return result;
    }
}