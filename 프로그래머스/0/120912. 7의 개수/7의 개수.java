class Solution {
    public int solution(int[] array) {
        String str = "";
        int result = 0;
        
        for(int i = 0; i < array.length; i++){
            str += array[i] + "";
        }
        
        for(char c : str.toCharArray()){
            if(c == '7') result++;
        }
        
        return result;
    }
}