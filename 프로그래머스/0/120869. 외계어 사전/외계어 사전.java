class Solution {
    public int solution(String[] spell, String[] dic) {
        int count = 0;
        
        for(String s : dic){
            boolean contain = true;
            
            for(int i = 0; i < spell.length; i++){
                if(!s.contains(spell[i])){
                    contain = false;
                    break;
                }
            }
            
            if(contain) count++;
        }
        
        return count == 0 ? 2 : 1;
    }
}