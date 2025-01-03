class Solution {
    public boolean solution(boolean x1, boolean x2, boolean x3, boolean x4) {
        
        boolean a1 = (x1 || x2);
        boolean a2 = (x3 || x4);
        boolean answer = (a1 && a2);
        
        return answer;
    }
}