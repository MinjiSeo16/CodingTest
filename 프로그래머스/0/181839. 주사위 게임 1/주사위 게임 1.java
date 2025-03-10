class Solution {
    public int solution(int a, int b) {
        int result = 0;
        
        if(a % 2 == 0 && b % 2 == 0){
            result = Math.abs(a - b);
        }
        else if(a % 2 != 0 && b % 2 != 0){
            result = a*a + b*b;
        }
        else{
            result = 2 * (a + b);
        }
        
        return result;
    }
}