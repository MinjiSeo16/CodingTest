import java.io.*;
import java.util.*;

public class Main {
	private static LinkedList<Integer>[] graph;
	private static boolean[] visit;
	private static int n;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		graph = new LinkedList[n + 1];
		for (int i = 1; i <= n; i++) {
			graph[i] = new LinkedList<>();
		}

		StringTokenizer st = new StringTokenizer(br.readLine());
		int person1 = Integer.parseInt(st.nextToken());
		int person2 = Integer.parseInt(st.nextToken());

		int m = Integer.parseInt(br.readLine());
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			graph[x].add(y);
			graph[y].add(x);
		}

		visit = new boolean[n + 1];
		int count = dfs(person1, person2, 0);
		System.out.println(count);
	}

	private static int dfs(int start, int target, int depth){
		if (start == target) {
			return depth;
		}
		visit[start] = true;

		for (int next : graph[start]) {
			if (!visit[next]) {
				int c = dfs(next, target, depth + 1);
				if (c != -1) {
					return c;
				}
			}
		}
		return -1;
	}
}