class Solution {
    String[] vowel = {"A", "E", "I", "O", "U"};
    int count = 0;
    int result = 0;
    
    public int solution(String word) {
        dfs("", word);
        return result;
    }
    
    public void dfs(String current, String target){
        if(current.length() > 5){
            return;
        }
        
        if(current.equals(target)){
            result = count;
            return;
        }
        
        count++;
        
        for(int i = 0; i < vowel.length; i++){
            dfs(current + vowel[i], target);
        }
    }
}