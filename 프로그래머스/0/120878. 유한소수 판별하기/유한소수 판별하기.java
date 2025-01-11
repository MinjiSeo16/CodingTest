class Solution {
    public int solution(int a, int b) {
        int max = Math.max(a, b);
        int k = 0; 
        
        for(int i = 1; i <= max; i++){
            if(a % i == 0 && b % i == 0){
                k = i;
            }
        }
        
        b = b / k;
        while(b != 1){
            if(b % 2 == 0) b /= 2;
            else if(b % 5 == 0) b /= 5;
            else break;
        }
        
        return b == 1 ? 1 : 2;
    }
}