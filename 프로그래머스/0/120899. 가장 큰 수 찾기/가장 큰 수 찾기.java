class Solution {
    public int[] solution(int[] array) {
        int[] result = new int[2];
        int max = 0;
        int idx = 0;
        
        for(int i = 0; i < array.length; i++){
            if(max < array[i]){
                max = array[i];
                idx = i;
            }
        }
        
        result[0] = max;
        result[1] = idx;
        
        return result;
    }
}