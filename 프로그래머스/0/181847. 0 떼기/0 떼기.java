class Solution {
    public String solution(String n_str) {
        int cnt = 0;
        
        while(cnt < n_str.length() && n_str.charAt(cnt) == '0'){
            cnt++;
        }
        
        return n_str.substring(cnt);
    }
}