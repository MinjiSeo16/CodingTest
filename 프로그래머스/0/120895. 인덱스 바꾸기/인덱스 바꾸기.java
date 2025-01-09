import java.util.Arrays;

class Solution {
    public String solution(String my_string, int num1, int num2) {
        StringBuilder sb = new StringBuilder();
        String[] str = my_string.split("");
        
        String tmp = "";
        tmp = str[num1];
        str[num1] = str[num2];
        str[num2] = tmp;
        
        for(String s : str){
            sb.append(s);
        }
        
        return sb.toString();
    }
}