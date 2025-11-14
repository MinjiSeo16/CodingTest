import java.io.*;
import java.util.StringTokenizer;

public class Main {
	static int N, K;
	static int[][] cost;
	static boolean[] visit;
	static int answer = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		cost = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				cost[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		//플로이드-워셜
		for (int k = 0; k < N; k++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(cost[i][j] > cost[i][k] + cost[k][j]) {
						cost[i][j] = cost[i][k] + cost[k][j];
 					}
				}
			}
		}

		visit = new boolean[N];
		visit[K] = true;
		dfs(K, 1, 0); // (현재위치, 방문항 행성 수, 누적비용)

		System.out.println(answer);
	}

	private static void dfs(int curr, int count, int sum) {
		if(count == N) {
			answer = Math.min(answer, sum);
			return;
		}

		for(int next = 0; next < N; next++) {
			if(!visit[next]) {
				visit[next] = true;
				dfs(next, count + 1, sum + cost[curr][next]);
				visit[next] = false;
			}
		}
	}
}