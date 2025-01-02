class Solution {
    public int solution(int a, int b) {
        int F = Integer.valueOf(""+a+b);
        int L = 2 * a * b;
        
        return F > L ? F : L;
    }
}