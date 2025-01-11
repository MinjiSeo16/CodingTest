class Solution {
    public int[] solution(int[][] score) {
        int[] sum = new int[score.length];
        int[] result = new int[score.length];
        
        for(int i = 0; i < score.length; i++){
            sum[i] = score[i][0] + score[i][1];
        }
        
        for(int i = 0; i < sum.length; i++){
            int rank = 1;
            for(int j = 0; j < sum.length; j++){
                if(sum[i] < sum[j]) rank++;
            }
            result[i] = rank;
        }
        
        return result;
    }
}