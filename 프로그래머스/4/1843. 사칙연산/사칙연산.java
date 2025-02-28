class Solution {
    public int solution(String arr[]) {
        int n = arr.length / 2 + 1;
        int[][] maxDP = new int[n][n];
        int[][] minDP = new int[n][n];
        int[] numbers = new int[n];
        char[] op = new char[n - 1];
        
        for(int i = 0, j = 0; i < arr.length; i += 2){
            numbers[j++] = Integer.parseInt(arr[i]);
        }
        for(int i = 1, j = 0; i < arr.length; i += 2){
            op[j++] = arr[i].charAt(0);
        }
        
        for(int i = 0; i < n; i++){
            maxDP[i][i] = numbers[i];
            minDP[i][i] = numbers[i];
        }
        
        for(int len = 1; len < n; len++){
            for(int i = 0; i + len < n; i++){
                int j = i + len;
                maxDP[i][j] = Integer.MIN_VALUE;
                minDP[i][j] = Integer.MAX_VALUE;
                
                for(int k = i; k < j; k++){
                    if(op[k] == '+'){
                        maxDP[i][j] = Math.max(maxDP[i][j], maxDP[i][k] + maxDP[k + 1][j]);
                        minDP[i][j] = Math.min(minDP[i][j], minDP[i][k] + minDP[k + 1][j]);
                    }
                    else{
                        maxDP[i][j] = Math.max(maxDP[i][j], maxDP[i][k] - minDP[k + 1][j]);
                        minDP[i][j] = Math.min(minDP[i][j], minDP[i][k] - maxDP[k + 1][j]);
                    }
                }
            }
        }
        
        return maxDP[0][n - 1];
    }
}