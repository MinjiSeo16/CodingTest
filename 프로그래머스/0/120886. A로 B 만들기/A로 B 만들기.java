class Solution {
    public int solution(String before, String after) {
        
        for(char c : before.toCharArray()){
            String s = c + "";
            after = after.replaceFirst(s, "");
        }
        
        if(after.equals("")) return 1;
        else return 0;
    }
}