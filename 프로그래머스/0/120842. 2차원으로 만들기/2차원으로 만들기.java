class Solution {
    public int[][] solution(int[] num_list, int n) {
        int[][] result = new int[num_list.length / n][n];
        int count = 0;
        
        for(int i = 0; i < result.length; i++){
            for(int j = 0; j < result[0].length; j++){
                result[i][j] = num_list[count++];
            }
        }
        
        return result;
    }
}