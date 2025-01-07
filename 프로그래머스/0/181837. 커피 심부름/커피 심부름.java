class Solution {
    public int solution(String[] order) {
        int am = 0, la = 0;
        int result = 0;
        
        for(int i = 0; i < order.length; i++){
            if(order[i].contains("americano") || order[i].contains("anything")) am ++;
            else{
                la++;
            }
        }
        
        result = (am * 4500) + (la * 5000);
        return result;
    }
}