class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int[] count = new int[n + 1];
        
        for(int i = 1; i <= n; i++) {
            count[i] = 1;
        }
        
        for(int r : reserve) {
            count[r]++;
        }
        
        for(int l : lost) {
            count[l]--;
        }
        
        for(int i = 1; i <= n; i++) {
            if(count[i] == 0) {
                if(i - 1 > 0 && count[i - 1] == 2) {
                    count[i] = 1;
                    count[i - 1] = 1;
                } else if(i + 1 <= n && count[i + 1] == 2) {
                    count[i] = 1;
                    count[i + 1] = 1;
                }
            }
        }
        
        int result = 0;
        for(int i = 1; i <= n; i++) {
            if(count[i] > 0) result++;
        }
        
        return result;
    }
}