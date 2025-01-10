class Solution {
    public int solution(int[][] board) {
        int n = board.length;
        int[][] danger = new int[n][n];
        int count = 0;
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == 1){
                    for(int dx = -1; dx <= 1; dx++){
                        for(int dy = -1; dy <= 1; dy++){
                            int X = i + dx;
                            int Y = j + dy;
                            if(X >= 0 && X < n && Y >= 0 && Y < n){
                                danger[X][Y] = 1;
                            }
                        }
                    }
                }
            }
        }
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(danger[i][j] == 0) count ++;
            }
        }
        
        return count;
    }
}