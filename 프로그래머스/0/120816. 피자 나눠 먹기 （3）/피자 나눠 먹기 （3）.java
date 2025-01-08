class Solution {
    public int solution(int slice, int n) {
        int result = n / slice;
        if(n % slice != 0) result++;
        
        return result;
    }
}