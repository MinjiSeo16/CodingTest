import java.io.*;
import java.util.*;

public class Main {
	private static LinkedList<int[]>[] graph;
	private static int n;
	private static boolean[] visit;
	private static int farNode;
	private static int maxDist;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		if (n == 1) {
			System.out.println(0);
			return;
		}

		graph = new LinkedList[n + 1];
		for (int i = 1; i <= n; i++) {
			graph[i] = new LinkedList<>();
		}

		for (int i = 0; i < n - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			graph[a].add(new int[]{b, w});
			graph[b].add(new int[]{a, w});
		}

		visit = new boolean[n + 1];
		maxDist = -1;
		farNode = 1;
		dfs(1, 0);

		visit = new boolean[n + 1];
		maxDist = -1;
		dfs(farNode, 0);

		System.out.println(maxDist);
	}

	private static void dfs(int x, int dist) {
		visit[x] = true;
		if (dist > maxDist) {
			maxDist = dist;
			farNode = x;
		}

		for (int[] next : graph[x]) {
			int y = next[0];
			int w = next[1];
			if (!visit[y]) {
				dfs(y, dist + w);
			}
		}
	}
}