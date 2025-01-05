class Solution {
    public String solution(String my_string, String alp) {
        
        String upper = alp.toUpperCase();
        return my_string.replace(alp , upper);
        
    }
}