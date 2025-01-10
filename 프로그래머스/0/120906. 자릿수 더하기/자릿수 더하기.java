class Solution {
    public int solution(int n) {
        String str = n + "";
        int result = 0;
        
        for(char c : str.toCharArray()){
            result += c - '0';
        }
        
        return result;
    }
}