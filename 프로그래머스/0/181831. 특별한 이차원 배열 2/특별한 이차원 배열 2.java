class Solution {
    public int solution(int[][] arr) {
        boolean isValid = true;
        
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr.length; j++){
                if(arr[i][j] != arr[j][i]){
                    isValid = false;
                    return 0;
                }
            }
        }
        
        return 1;
    }
}