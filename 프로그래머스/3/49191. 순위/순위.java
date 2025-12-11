class Solution {
    public int solution(int n, int[][] results) {
        int[][] graph = new int[n + 1][n + 1];
        
        for(int[] r : results) {
            int a = r[0];
            int b = r[1];
            graph[a][b] = 1;
        }
        
        for(int k = 1; k <= n; k++) {
            for(int i = 1; i <= n; i++) {
                for(int j = 1; j <= n; j++) {
                    if(graph[i][k] == 1 && graph[k][j] == 1) {
                        graph[i][j] = 1;
                    }
                }
            }
        }
        
        int answer = 0;
        
        for(int i = 1; i <= n; i++) {
            int win = 0;
            int lose = 0;
            
            for(int j = 1; j <= n; j++) {
                if(graph[i][j] == 1) win++;
                if(graph[j][i] == 1) lose++;
            }
            
            if(win + lose == n - 1) {
                answer++;
            }
        }
        
        return answer;
    }
}