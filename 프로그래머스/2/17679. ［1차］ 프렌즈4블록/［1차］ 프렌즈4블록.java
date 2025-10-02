class Solution {
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        
        char[][] arr = new char[m][n];
        for(int i = 0; i < m; i++) {
            arr[i] = board[i].toCharArray();
        }
        
        while(true) {
            int removeCount = 0;
            boolean[][] check = new boolean[m][n];
            
            //지울 블록 찾기
            for(int i = 0; i < m - 1; i++) {
                for(int j = 0; j < n - 1; j++) {
                    char c = arr[i][j];
                    if(c == '.') continue;
                    
                    if(arr[i][j + 1] == c && arr[i + 1][j] == c && arr[i + 1][j + 1] == c) {
                        check[i][j] = true;
                        check[i][j + 1] = true;
                        check[i + 1][j] = true;
                        check[i + 1][j + 1] = true;
                    } 
                }
            }
            
            //지우기
            for(int i = 0; i < m; i++) {
                for(int j = 0; j < n; j++) {
                    if(check[i][j]) {
                        arr[i][j] = '.';
                        removeCount++;
                    }
                }
            }
            
            if(removeCount == 0) break;
            answer += removeCount;
            
            //재배치
            for(int j = 0; j < n; j++) {
                for(int i = m - 1; i >= 0; i--) {
                    if(arr[i][j] == '.') {
                        int k = i - 1;
                        while(k >= 0 && arr[k][j] == '.') {
                            k--;
                        }
                        if(k >= 0) {
                            arr[i][j] = arr[k][j];
                            arr[k][j] = '.';
                        }
                    }
                }
            }            
        }
        
        return answer;
    }
}