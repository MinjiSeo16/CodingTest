class Solution {
    public int[] solution(int[] num_list) {
        int[] result = new int[2];
        int odd = 0; 
        int even = 0;
        
        for(int i = 0; i < num_list.length; i++){
            if(num_list[i] % 2 == 0) even++;
            else odd++;
        }
        
        result[0] = even;
        result[1] = odd;
        
        return result;
    }
}