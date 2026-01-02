import java.io.*;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] cost = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(i == j) cost[i][j] = 0;
				else cost[i][j] = Integer.MAX_VALUE;
			}
		}

		int m = Integer.parseInt(br.readLine());
		for(int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			cost[a - 1][b - 1] = Math.min(cost[a - 1][b - 1], c);
	}

		for (int k = 0; k < n; k++) {
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					if(cost[i][k] != Integer.MAX_VALUE && cost[k][j] != Integer.MAX_VALUE) {
						cost[i][j] = Math.min(cost[i][j], cost[i][k] + cost[k][j]);
					}
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (cost[i][j] == Integer.MAX_VALUE) sb.append(0);
				else sb.append(cost[i][j]);
				sb.append(" ");
			}
			sb.append('\n');
		}

		System.out.println(sb);
	}
}