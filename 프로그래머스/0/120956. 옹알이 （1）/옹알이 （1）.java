class Solution {
    public int solution(String[] babbling) {
        int result = 0;
        
        for(int i = 0; i < babbling.length; i++){
            String s = babbling[i];
            s = s.replace("aya", "k");
            s = s.replace("ye", "k");
            s = s.replace("woo", "k");
            s = s.replace("ma", "k");
            
            s = s.replace("k", "");
            if(s.equals("")) result++;
        }
        
        return result;
    }
}