class Solution {
    public int solution(int order) {
        String str = order + "";
        int count = 0;
        
        for(char c : str.toCharArray()){
            if(c == '3' || c == '6' || c == '9'){
                count++;
            }
        }
        
        return count;
    }
}