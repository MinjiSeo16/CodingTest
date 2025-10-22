import java.io.*;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[][] history = new int[n + 1][n + 1];

		for(int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			history[a][b] = -1;
			history[b][a] = 1;
		}

		for(int mid = 1; mid <= n; mid++) {
			for(int start = 1; start <= n; start++) {
				for(int end = 1; end <= n; end++) {
					if(history[start][mid] == -1 && history[mid][end] == -1) {
						history[start][end] = -1;
						history[end][start] = 1;
					}
				}
			}
		}

		int s = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < s; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			sb.append(history[a][b]).append('\n');
		}
		System.out.println(sb);
	}
}