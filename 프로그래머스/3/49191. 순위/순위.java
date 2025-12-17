class Solution {
    public int solution(int n, int[][] results) {
        int count = 0;
		int[][] graph = new int[n + 1][n + 1];

		for(int i = 0; i < results.length; i++) {
			int[] ab = results[i];
			int a = ab[0];
			int b = ab[1];
			graph[a][b] = 1;
		}

		for (int k = 1; k <= n; k++) {
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					if(graph[i][k] == 1 && graph[k][j] == 1) {
						graph[i][j] = 1;
					}
				}
			}
		}

		for (int i = 1; i <= n; i++) {
			int lose = 0;
			int win = 0;

			for (int j = 1; j <= n; j++) {
				if(graph[i][j] == 1) win++;
				if(graph[j][i] == 1) lose++;
			}

			if(lose + win == n - 1) {
				count++;
			}
		}

		return count;
    }
}