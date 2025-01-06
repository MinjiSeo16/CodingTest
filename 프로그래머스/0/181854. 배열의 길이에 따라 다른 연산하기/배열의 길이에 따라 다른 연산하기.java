class Solution {
    public int[] solution(int[] arr, int n) {
        int[] result = arr.clone();
        
        if(arr.length % 2 == 0){
            for(int i = 1; i < arr.length; i += 2){
                result[i] = result[i] + n;
            }
        } else{
            for(int i = 0; i < arr.length; i += 2){
                result[i] = result[i] + n; 
            }
        }
        
        return result;
    }
}