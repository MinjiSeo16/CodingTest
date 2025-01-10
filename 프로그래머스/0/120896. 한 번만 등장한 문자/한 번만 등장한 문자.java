class Solution {
    public String solution(String s) {
        String result = "";
        int[] alphabet = new int[26];
        
        for(char c : s.toCharArray()){
            alphabet[c - 'a']++;
        }
        
        for(int i = 0; i < alphabet.length; i++){
            if(alphabet[i] == 1) result += (char)(i + 'a');
        }
        
        return result;
    }
}