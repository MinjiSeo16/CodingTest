import java.io.*;
import java.util.*;

public class Main {

	static int N, M;
	static int[][] map;
	static boolean[][][] visited;
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		visited = new boolean[N][M][2];

		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = line.charAt(j) - '0';
			}
		}

		System.out.println(bfs());
	}

	private static int bfs() {
		Queue<int[]> q = new ArrayDeque<>();

		// {x, y, 벽부숨여부, 거리}
		q.offer(new int[]{0, 0, 0, 1});
		visited[0][0][0] = true;

		while (!q.isEmpty()) {
			int[] cur = q.poll();
			int x = cur[0];
			int y = cur[1];
			int broke = cur[2];
			int dist = cur[3];

			if (x == N - 1 && y == M - 1) {
				return dist;
			}

			for (int d = 0; d < 4; d++) {
				int nx = x + dx[d];
				int ny = y + dy[d];

				if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;

				//빈칸
				if(map[nx][ny] == 0) {
					if(!visited[nx][ny][broke]) {
						visited[nx][ny][broke] = true;
						q.offer(new int[]{nx, ny, broke, dist + 1});
					}
				}
				//벽
				else {
					if(broke == 0 && !visited[nx][ny][1]) {
						visited[nx][ny][1] = true;
						q.offer(new int[]{nx, ny, 1, dist + 1});
					}
				}
			}
		}
		return -1;
	}
}