class Solution {
    public int solution(int n, int w, int num) {
        int row = (num - 1) / w;
        int col = (num - 1) % w;
        if (row % 2 == 1) { 
            col = w - 1 - col;
        }

        int result = 0;
        for (int i = row; i < (n + w - 1) / w; i++) {
            if(i % 2 == 0){
                if(col < (n - i * w)) result++;
            }
            else{
                if((w - 1 - col) < (n - i * w)) result++;
            }
        }

        return result;
    }
}
