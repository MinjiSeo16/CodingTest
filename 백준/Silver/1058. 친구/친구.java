import java.io.*;
import java.util.*;

public class Main {
	private static char[][] graph;
	private static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		graph = new char[N][N];

		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			graph[i] = st.nextToken().toCharArray();
		}

		int result = 0;
		int max = 0;
		for (int i = 0; i < N; i++) {
			result = bfs(i);
			if (result > max) {
				max = result;
			}
		}

		System.out.println(max);
	}

	public static int bfs(int num1){
		Queue<Integer> queue = new LinkedList<>();
		boolean[] visit = new boolean[N];
		visit[num1] = true;
		int count = 0;

		for (int i = 0; i < N; i++) {
			if(graph[num1][i] == 'Y'){
				queue.add(i);
				visit[i] = true;
				count++;
			}
		}

		while (!queue.isEmpty()) {
			int num2 = queue.poll();
			for (int i = 0; i < N; i++) {
				if (graph[num2][i] == 'Y' && visit[i] == false) {
                    visit[i] = true;
					count++;
				}
			}
		}

		return count;
	}
}