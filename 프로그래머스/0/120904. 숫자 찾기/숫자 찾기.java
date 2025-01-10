class Solution {
    public int solution(int num, int k) {
        int idx = -1;
        String Snum = num + "";
        
        for(int i = 0; i < Snum.length(); i++){
            if(Snum.charAt(i) - '0' == k){
                idx = i + 1;
                break;
            }
        }
    
        return idx;
    }
}