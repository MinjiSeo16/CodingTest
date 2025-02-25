import java.util.*;

class Solution {
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static boolean[][] visit;
    
    public int solution(int[][] maps) {
        visit = new boolean[maps.length][maps[0].length];
        return bfs(0, 0, maps);
    }
    
    public static int bfs(int x, int y, int[][] maps){
        int n = maps.length; 
        int m = maps[0].length;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y, 1});
        visit[x][y] = true;
        
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int cx = cur[0];
            int cy = cur[1];
            int dist = cur[2];
            
            if(cx == n - 1 && cy == m - 1){
                return dist;
            }
            
            for(int i = 0; i < 4; i++){
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                
                if(nx >= 0 && nx < n && ny >= 0 && ny < m && !visit[nx][ny] && maps[nx][ny] == 1){
                    visit[nx][ny] = true;
                    queue.add(new int[]{nx, ny, dist + 1});
                }
            }
        }
        
        return -1;
    }
}