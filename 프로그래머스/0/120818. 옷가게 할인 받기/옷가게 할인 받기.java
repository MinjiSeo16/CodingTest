class Solution {
    public int solution(int price) {
        int result = price;
        
        if(100000 <= price && price < 300000){
            result = (int)(price * 0.95);
        }
        else if(300000 <= price && price < 500000){
            result = (int)(price * 0.9);
        }
        else if(500000 <= price){
            result = (int)(price * 0.8);
        }
        
        return result;
    }
}