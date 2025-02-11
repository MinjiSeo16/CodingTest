class Solution {
    public int[] solution(int brown, int yellow) {
        int[] result = new int[2];
        int carpet = brown + yellow;
        
        for(int i = 1; i < carpet; i++){
            int col = i;
            int row = carpet / col;
            
            if(row >= 3 && col >= 3 && row >= col){
                if((row - 2) * (col - 2) == yellow){
                    result[0] = row;
                    result[1] = col;
                    break;
                }
            }
        }
        
        return result;
    }
}