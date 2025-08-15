import java.io.*;
import java.util.*;

public class Main {
	private static int[][] height;
	private static int M;
	private static int N;
	private static int K;
	private static int[] dx = {0, 1, -1, 0};
	private static int[] dy = {1, 0, 0, -1};
	private static boolean[][] visit;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		visit = new boolean[M][N];
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());

			for (int x = x1; x < x2; x++) {
				for (int y = y1; y < y2; y++) {
					visit[y][x] = true;
				}
			}
		}

		List<Integer> size = new ArrayList<>();
		for (int y = 0; y < M; y++) {
			for (int x = 0; x < N; x++) {
				if (!visit[y][x]) {
					int s = bfs(y, x);
					size.add(s);
				}
			}
		}

		System.out.println(size.size());
		Collections.sort(size);
		for (int i = 0; i < size.size(); i++) {
			System.out.print(size.get(i) + " ");
		}
	}

	private static int bfs(int y, int x) {
		int count = 1;
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.add(new int[] {y, x});
		visit[y][x] = true;

		while (!queue.isEmpty()) {
			int[] xy = queue.poll();
			int Y = xy[0];
			int X = xy[1];

			for (int i = 0; i < 4; i++) {
				int nextX = X + dx[i];
				int nextY = Y + dy[i];

				if (nextX >= 0 && nextX < N && nextY >= 0 && nextY < M) {
					if (!visit[nextY][nextX]) {
						queue.add(new int[] {nextY, nextX});
						visit[nextY][nextX] = true;
						count++;
					}
				}
			}
		}
		return count;
	}
}
