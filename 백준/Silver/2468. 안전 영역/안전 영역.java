import java.io.*;
import java.util.*;

public class Main {
	private static int[][] height;
	private static int N;
	private static int[] dx = {0, 1, -1, 0};
	private static int[] dy = {1, 0, 0, -1};
	private static boolean[][] visit;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int min = 0;
		int max = 0;
		N = Integer.parseInt(st.nextToken());
		height = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int h = Integer.parseInt(st.nextToken());
				height[i][j] = h;
				if (min > h) {
					min = h;
				}
				if (max < h) {
					max = h;
				}
			}
		}

		int count;
		int maxCount = 0;
		for (int h = min; h <= max; h++) {
			visit = new boolean[N][N];
			count = 0;
			for (int x = 0; x < N; x++) {
				for (int y = 0; y < N; y++) {
					if (height[x][y] > h && !visit[x][y]) {
						bfs(x, y, h);
						count++;
					}
				}
			}
			if (count > maxCount) {
				maxCount = count;
			}
		}

		System.out.println(maxCount);
	}

	public static void bfs(int x, int y, int h){
		Queue<int[]> q = new LinkedList<int[]>();
		q.add(new int[] {x, y});
		visit[x][y] = true;

		while (!q.isEmpty()) {
			int[] xy = q.poll();
			int X = xy[0];
			int Y = xy[1];

			for (int i = 0; i < 4; i++) {
				int nextX = X + dx[i];
				int nextY = Y + dy[i];

				if (nextX >= 0 && nextX < N && nextY >= 0 && nextY < N) {
					if (height[nextX][nextY] > h && !visit[nextX][nextY]) {
						q.add(new int[] {nextX, nextY});
						visit[nextX][nextY] = true;
					}
				}
			}
		}
	}
}
