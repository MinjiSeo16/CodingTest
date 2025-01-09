class Solution {
    public int solution(int n) {
        int result = 0;
        
        for(int i = 1; i <= 10; i++){
            if(n >= factorial(i)) result = i;
        }
        
        return result;
    }
    
    public static int factorial(int k){
        if(k > 1) return k * factorial(k - 1);
        return k;
    }
}