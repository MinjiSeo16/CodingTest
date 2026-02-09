import java.io.*;
import java.util.*;

public class Main {

	static int N, L, R;
	static int[][] country;
	static boolean[][] visit;
	static int[] dx = {0, 1, -1, 0};
	static int[] dy = {1, 0, 0, -1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		country = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				country[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int days = 0;

		while (true) {
			visit = new boolean[N][N];
			boolean moved = false;

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(!visit[i][j]) {
						if(bfs(i, j)) {
							moved = true;
						}
					}
				}
			}

			if (!moved) break;
			days++;
		}

		System.out.println(days);
	}

	private static boolean bfs(int sx, int sy) {
		Queue<int[]> q = new LinkedList<>();
		List<int[]> union = new ArrayList<>();

		q.add(new int[]{sx, sy});
		union.add(new int[]{sx, sy});
		visit[sx][sy] = true;
		int sum = country[sx][sy];

		while (!q.isEmpty()) {
			int[] cur = q.poll();
			int x = cur[0];
			int y = cur[1];

			for (int d = 0; d < 4; d++) {
				int nx = x + dx[d];
				int ny = y + dy[d];

				if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
				if (visit[nx][ny]) continue;

				int diff = Math.abs(country[x][y] - country[nx][ny]);
				if (diff >= L && diff <= R) {
					visit[nx][ny] = true;
					q.add(new int[]{nx, ny});
					union.add(new int[]{nx, ny});
					sum += country[nx][ny];
				}
			}
		}

		if(union.size() <= 1) return false;

		int avg = sum / union.size();
		for (int[] p : union) {
			country[p[0]][p[1]] = avg;
		}
		return true;
	}
}