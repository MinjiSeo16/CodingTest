class Solution {
    public int solution(String A, String B) {
        String s = A;
        
        if(A.equals(B)) return 0;
        
        for(int i = 1; i <= A.length(); i++){
            s = s.charAt(s.length() - 1) + "" + s.substring(0, s.length() - 1);
            if(s.equals(B)){
                return i;
            }
        }
        
        return -1;
    }
}