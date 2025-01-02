class Solution {
    public String solution(String my_string, String overwrite_string, int s) {
        String answer = "";
        char[] c = my_string.toCharArray();
        
        for(int i = 0; i < s; i++){
            answer += c[i];
        }
        answer += overwrite_string;
        
        for(int i = overwrite_string.length() + s; i < my_string.length(); i++){
            answer += c[i];
        }
        
        return answer;
    }
}