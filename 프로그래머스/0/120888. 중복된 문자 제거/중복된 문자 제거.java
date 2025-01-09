class Solution {
    public String solution(String my_string) {
        String result = "";
        
        for(char c : my_string.toCharArray()){
            if(!result.contains(c + "")) result += c + "";
        }
        
        return result;
    }
}