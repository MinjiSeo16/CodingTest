import java.io.*;
import java.util.*;

public class Main {
	static LinkedList<Integer>[] graph;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		graph = new LinkedList[N + 1];
		for(int i = 1; i <= N; i++) {
			graph[i] = new LinkedList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			graph[u].add(v);
			graph[v].add(u);
		}

		int answer = 0;
		int minCount = Integer.MAX_VALUE;
		for (int i = 1; i <= N; i++) {
			int sum = 0;
			for(int j = 1; j <= N; j++) {
				if(i != j) {
					boolean[] visit = new boolean[N + 1];
					sum += bfs(i, j, visit);
				}
			}
			if(sum < minCount) {
				minCount = sum;
				answer = i;
			}
		}
		System.out.println(answer);
	}

	public static int bfs(int start, int end, boolean[] visit) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[]{start, 0});
		visit[start] = true;

		while (!q.isEmpty()) {
			int[] cur = q.poll();
			int now = cur[0];
			int dist = cur[1];

			if(now == end) return dist;

			for(int next : graph[now]) {
				if (!visit[next]) {
					visit[next] = true;
					q.offer(new int[]{next, dist + 1});
				}
			}
		}
		return 0;
	}
}