class Solution {
    public String solution(String my_string, int s, int e) {
        StringBuilder answer = new StringBuilder(my_string);
        StringBuilder rev = new StringBuilder();
        
        for(int i = s; i <= e; i++){
            rev.append(my_string.charAt(i));
        }
        
        answer.replace(s, e+1, rev.reverse().toString());
        return answer.toString();
    }
}