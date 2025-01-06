class Solution {
    public int solution(String[] strArr) {
        int max_l = 0;
        int max_count = 0;
        for(int i = 0; i < strArr.length; i++){
            if(strArr[i].length() > max_l){
                max_l = strArr[i].length(); 
            }
        }
        
        int[] count = new int[max_l + 1];
        for(int i = 0; i < strArr.length; i++){
            count[strArr[i].length()]++;
        }
        
        for(int i = 0; i < count.length; i++){
            if(max_count < count[i]) max_count = count[i];
        }
        
        return max_count; 
    }
}