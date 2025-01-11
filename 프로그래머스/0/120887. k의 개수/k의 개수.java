class Solution {
    public int solution(int i, int j, int k) {
        int result = 0;
        
        for(int t = i; t <= j; t++){
            String s = t + "";
            for(char c : s.toCharArray()){
                if(c - '0' == k) result++;
            }
        }
        
        return result;
    }
}