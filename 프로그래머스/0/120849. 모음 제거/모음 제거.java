class Solution {
    public String solution(String my_string) {
        
        my_string = my_string.replace("a", "")
                             .replace("e", "")
                             .replace("i", "")
                             .replace("o", "")
                             .replace("u", "");
        
        return my_string;
    }
}