import java.util.*;

class Solution {
    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        
        for(int i = 0; i < 5; i++) {
            char[][] board = new char[5][5];
            for(int j = 0; j < 5; j++) {
                board[j] = places[i][j].toCharArray();
            }
            answer[i] = isSafe(board) ? 1 : 0;
        }
        return answer;
    }
    
    private boolean isSafe(char[][] b) {
       for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (b[i][j] == 'P') {
                    if (violates(b, i, j)) return false;
                }
            }
        }
        return true;
    }
    
    private boolean violates(char[][] b, int x, int y) {
        int[][] dists = {{1,0},{-1,0},{0,1},{0,-1}};
        boolean[][] visit = new boolean[5][5];
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.offer(new int[] {x, y, 0});
        visit[x][y] = true;
        
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int curX = cur[0];
            int curY = cur[1];
            int d = cur[2];
            
            if(d >= 1 && d <= 2 && b[curX][curY] == 'P') {
                return true;
            }
            
            if(d == 2) continue;
            
            for(int[] dist : dists) {
                int nx = curX + dist[0];
                int ny = curY + dist[1];
                if(0 <= nx && nx < 5 && 0 <= ny && ny < 5 && !visit[nx][ny]) {
                    if(b[nx][ny] != 'X') {
                        visit[nx][ny] = true;
                        q.offer(new int[]{nx,ny,d+1});
                    }
                }
            }
        }
        
        return false;
    }
}
