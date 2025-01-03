class Solution {
    public String solution(String code) {
        StringBuilder ret = new StringBuilder();
        int mode = 0;
        int idx = 0;

        for(char c : code.toCharArray()){
            if(mode == 0){
                if(c == '1') mode = 1;
                else{
                    if(idx % 2 == 0) ret.append(c);
                    }
            }
            else{
                if(c == '1') mode = 0;
                else{
                    if(idx % 2 != 0) ret.append(c);
                }
            }
            idx++;
        }
        
        if(ret.length() == 0){
            return "EMPTY";
        }
        
        return ret.toString();
    }
}