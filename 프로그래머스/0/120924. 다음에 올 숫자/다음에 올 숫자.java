class Solution {
    public int solution(int[] common) {
        int result = 0;
        
        if((common[2] - common[1]) == (common[1] - common[0])){
            int min = common[2] - common[1];
            result = common[common.length - 1] + min;
        }
        else{
            int mul = common[1] / common[0];
            result = common[common.length - 1] * mul;
        }
        
        return result;
    }
}