class Solution {
    
    public int[] solution(int[] prices) {
        int[] result = new int[prices.length];
        
        for(int i = 0; i < prices.length; i++){
            result[i] = countBigger(prices, i);
        }
        
        return result;
    }
    
    public static int countBigger(int[] prices, int index){
        int count = 0;
        for(int i = index + 1; i < prices.length; i++){
            count++;
            if(prices[i] < prices[index]){
                break;
            }
        }
        return count;
    }
}