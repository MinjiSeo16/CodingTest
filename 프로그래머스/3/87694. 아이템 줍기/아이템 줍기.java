import java.util.*;

class Solution {
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int[][] map = new int[101][101];
        
        //2배 후 전체 영역 표시
        for(int[] r : rectangle) {
            int x1 = r[0] * 2;
            int y1 = r[1] * 2;
            int x2 = r[2] * 2;
            int y2 = r[3] * 2;
            
            for(int i = x1; i <= x2; i++) {
                for(int j = y1; j <= y2; j++) {
                    map[i][j] = 1; //전체 1표시
                }
            }
        }
        
        //내부 0표시
        for(int[] r : rectangle) {
            int x1 = r[0] * 2;
            int y1 = r[1] * 2;
            int x2 = r[2] * 2;
            int y2 = r[3] * 2;
            
            for(int i = x1 + 1; i < x2; i++) {
                for(int j = y1 + 1; j < y2; j++) {
                    map[i][j] = 0;
                }
            }
        }
        
        //테두리1인곳 경로탐색
        int answer = bfs(map, characterX*2, characterY*2, itemX*2, itemY*2);
        
        return answer;
    }
    
    private int bfs(int[][] map, int sx, int sy, int tx, int ty) {
        boolean[][] visit = new boolean[101][101];
        Queue<int[]> q = new LinkedList<>();
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
            
        q.add(new int[]{sx, sy, 0});
        visit[sx][sy] = true;
        
        while(!q.isEmpty()) {
            int[] now = q.poll();
            int x = now[0];
            int y = now[1];
            int dist = now[2];
            
            if(x == tx && y == ty) return dist / 2;
            
            for(int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if(nx < 0 || ny < 0 || nx > 100 || ny > 100) continue;
                if(visit[nx][ny]) continue;
                if(map[nx][ny] == 1) {
                    visit[nx][ny] = true;
                    q.add(new int[]{nx, ny, dist + 1});
                }
            }
        }
        
        return 0;
    }
}