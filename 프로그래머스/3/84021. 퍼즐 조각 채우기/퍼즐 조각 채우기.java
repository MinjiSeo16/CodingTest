import java.util.*;

class Solution {
    static int n;
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    
    public int solution(int[][] game_board, int[][] table) {
        n = game_board.length;
        List<List<int[]>> blanks = new ArrayList<>();
        List<List<int[]>> pieces = new ArrayList<>();
        
        //game_board에서 빈칸(0) 찾기
        boolean[][] visitBoard = new boolean[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(!visitBoard[i][j] && game_board[i][j] == 0){
                    blanks.add(bfs(i, j, game_board, visitBoard, 0));
                }
            }
        }
        
        //table에서 퍼즐조각(1) 찾기
        boolean[][] visitTable = new boolean[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(!visitTable[i][j] && table[i][j] == 1) {
                    pieces.add(bfs(i, j, table, visitTable, 1));
                }
            }
        }
        
        //퍼즐 매칭하기
        boolean[] used = new boolean[pieces.size()];
        int answer = 0;
        
        for(List<int[]> blank : blanks) {
            for(int i = 0; i < pieces.size(); i++) {
                if(used[i]) continue;
                List<int[]> piece = pieces.get(i);
                
                //4방향 회전
                for(int r = 0; r < 4; r++) {
                    if(isSame(blank, piece)) {
                        answer += piece.size();
                        used[i] = true;
                        break;
                    }
                    piece = rotate(piece);
                }
                
                if(used[i]) break;
            }
        }
        
        return answer;
    }
    
    private List<int[]> bfs(int x, int y, int[][] board, boolean[][] visit, int target) {
        Queue<int[]> q = new LinkedList<>();
        List<int[]> shape = new ArrayList<>();
        q.offer(new int[]{x, y});
        visit[x][y] = true;
        
        while(!q.isEmpty()) {
            int[] now = q.poll();
            shape.add(now);
            
            for(int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                
                if(nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
                if(!visit[nx][ny] && board[nx][ny] == target) {
                    visit[nx][ny] = true;
                    q.offer(new int[]{nx, ny});
                }
            }
        }
        //정규화 (0,0) 기준으로 맞추기
        shape.sort((a,b) -> a[0] == b[0] ? a[1]-b[1] : a[0]-b[0]);
        int minX = shape.get(0)[0];
        int minY = shape.get(0)[1];
        
        List<int[]> normalized = new ArrayList<>();
        for(int[] s : shape) {
            normalized.add(new int[]{s[0] - minX, s[1] - minY});
        }
        
        return normalized;
    }
    
    //도형이 같은지 검사
    private boolean isSame(List<int[]> a, List<int[]> b) {
        if(a.size() != b.size()) return false;
        for(int i = 0; i < a.size(); i++) {
            if(a.get(i)[0] != b.get(i)[0] || a.get(i)[1] != b.get(i)[1]) return false;
        }
        return true;
    }
    
    //90도 회전하기
    private List<int[]> rotate(List<int[]> shape) {
        List<int[]> rotate = new ArrayList<>();
        for(int[] s : shape) {
            rotate.add(new int[]{s[1], -s[0]});
        }
        rotate.sort((a,b) -> a[0] == b[0] ? a[1]-b[1] : a[0]-b[0]);
        int minX = rotate.get(0)[0];
        int minY = rotate.get(0)[1];
        
        List<int[]> normalized = new ArrayList<>();
        for(int[] s : rotate) {
            normalized.add(new int[]{s[0] - minX, s[1] - minY});
        }
        return normalized;
    }
}