class Solution {
    public int[][] solution(int n) {
        int[][] result = new int[n][n];
        int count = 1;
        int top = 0, bottom = n - 1, left = 0, right = n - 1;
        
        while(n * n >= count){
            for(int i = left; i <= right; i++){
                result[top][i] = count++;
            }
            top++;
            
            for(int i = top; i <= bottom; i++){
                result[i][right] = count++;
            }
            right--;
            
            for(int i = right; i >= left; i--){
                result[bottom][i] = count++;
            }
            bottom--;
            
            for(int i = bottom; i >= top; i--){
                result[i][left] = count++;
            }
            left++;
        }
        
        return result;
    }
}