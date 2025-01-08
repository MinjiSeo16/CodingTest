class Solution {
    public String solution(String my_string, int n) {
        StringBuilder sb = new StringBuilder();
        
        for(char c : my_string.toCharArray()){
            String s = c + "";
            sb.append(s.repeat(n));
        }
        
        return sb.toString();
    }
}