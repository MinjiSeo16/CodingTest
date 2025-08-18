import java.io.*;
import java.util.*;

public class Main {
	private static int[][] graph;
	private static boolean[][] visit;
	private static int N, M;
	private static int[] dx = {0, 0, 1, -1};
	private static int[] dy = {1, -1, 0, 0};
	private static ArrayList<int[]> cheese;
	private static int cheeseCnt = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		graph = new int[N][M];
		cheese = new ArrayList<int[]>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
				if (graph[i][j] == 1) {
					cheese.add(new int[]{i, j});
					cheeseCnt++;
				}
			}
		}

		int time = 0;
		while (cheeseCnt != 0) {
			time++;
			visit = new boolean[N][M];
			dfs(0, 0);
			melt();
		}
		System.out.println(time);
	}

	private static void dfs(int x, int y) {
		visit[x][y] = true;
		if (graph[x][y] == 0) graph[x][y] = 2;

		for (int i = 0; i < 4; i++) {
			int nextX = x + dx[i];
			int nextY = y + dy[i];

			if (nextX >= 0 && nextX < N && nextY >= 0 && nextY < M){
				if (!visit[nextX][nextY] && graph[nextX][nextY] != 1) {
					dfs(nextX, nextY);
				}
			}
		}
	}

	private static void melt() {
		for (int i = 0; i < cheese.size(); i++) {
			int[] xy = cheese.get(i);
			int x = xy[0];
			int y = xy[1];
			int count = 0;

			for (int j = 0; j < 4; j++) {
				int nextX = x + dx[j];
				int nextY = y + dy[j];

				if (nextX >= 0 && nextX < N && nextY >= 0 && nextY < M) {
					if (graph[nextX][nextY] == 2) {
						count++;
					}
				}
			}

			if (count >= 2) {
				graph[x][y] = 0;
				cheeseCnt--;
				cheese.remove(i);
				i--;
			}
		}
	}
}