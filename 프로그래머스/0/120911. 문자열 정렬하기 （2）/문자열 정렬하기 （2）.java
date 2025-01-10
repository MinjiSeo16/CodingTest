import java.util.Arrays;

class Solution {
    public String solution(String my_string) {
        StringBuilder sb = new StringBuilder();
        my_string = my_string.toLowerCase();
        char[] sort_string = my_string.toCharArray();
        Arrays.sort(sort_string);
        
        for(int i = 0; i < sort_string.length; i++){
            sb.append(sort_string[i]);
        }
        
        return sb.toString();
    }
}