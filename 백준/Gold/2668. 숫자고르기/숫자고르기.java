import java.io.IOException;
import java.util.*;

public class Main {

	static boolean[] visit;
	static int[] graph;
	static List<Integer> answer;
	static int count;

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		graph = new int[N + 1];
		visit = new boolean[N + 1];
		answer = new ArrayList<>();
		count = 0;

		for (int i = 1; i <= N; i++) {
			graph[i] = sc.nextInt();
		}

		for (int i = 1; i <= N; i++) {
			if(!visit[i]) {
				dfs(i);
			}
		}

		Collections.sort(answer);

		StringBuilder sb = new StringBuilder();
		sb.append(count).append("\n");
		for (int i = 0; i < answer.size(); i++) {
			sb.append(answer.get(i)).append("\n");
		}

		System.out.println(sb);
	}

	private static void dfs(int start) {
		int cur = start;
		List<Integer> path = new ArrayList<>();

		while(!visit[cur]) {
			visit[cur] = true;
			path.add(cur);
			cur = graph[cur];
		}

		if(path.contains(cur)) {
			int idx = path.indexOf(cur);
			for(int i = idx; i < path.size(); i++) {
				answer.add(path.get(i));
				count++;
			}
		}
	}
}