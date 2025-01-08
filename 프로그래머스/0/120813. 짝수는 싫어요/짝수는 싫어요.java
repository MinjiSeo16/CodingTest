class Solution {
    public int[] solution(int n) {
        int size = n % 2 == 0 ? (n / 2) : (n / 2 + 1);
        int[] result = new int[size];
        int cnt = 0;
        
        for(int i = 1; i <= n; i+=2){
            result[cnt++] = i;
        }
        
        return result;
    }
}