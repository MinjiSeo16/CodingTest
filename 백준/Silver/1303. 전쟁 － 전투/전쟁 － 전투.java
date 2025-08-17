import java.io.*;
import java.util.*;

public class Main {
	private static char[][] graph;
	private static boolean[][] visit;
	private static int N, M;
	private static int[] dx = {0, 0, 1, -1};
	private static int[] dy = {1, -1, 0, 0};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		graph = new char[M][N];
		visit = new boolean[M][N];
		for (int i = 0; i < M; i++) {
			String input = br.readLine();
			graph[i] = input.toCharArray();
		}

		int white = 0;
		int blue = 0;
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (!visit[i][j]) {
					int power = bfs(i, j);
					if (graph[i][j] == 'W') {
						white += power * power;
					} else {
						blue += power * power;
					}
				}
			}
		}

		System.out.println(white + " " + blue);
	}

	private static int bfs(int x, int y) {
		char color = graph[x][y];
		Queue<int[]> q = new ArrayDeque<>();
		visit[x][y] = true;
		int count = 1;
		q.add(new int[] {x, y});

		while (!q.isEmpty()) {
			int[] xy = q.poll();
			int X = xy[0];
			int Y = xy[1];

			for (int i = 0; i < 4; i++) {
				int nextX = X + dx[i];
				int nextY = Y + dy[i];

				if (nextX >= 0 && nextX < M && nextY >= 0 && nextY < N){
					if (!visit[nextX][nextY] && graph[nextX][nextY] == color) {
						count++;
						visit[nextX][nextY] = true;
						q.add(new int[] {nextX, nextY});
					}
				}
			}
		}
		return count;
	}
}