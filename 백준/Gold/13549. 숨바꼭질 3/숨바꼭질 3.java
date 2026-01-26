import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int MAX = 100000;
		int[] dist = new int[MAX + 1];
		Arrays.fill(dist, -1);

		Deque<Integer> deque = new ArrayDeque<>();
		deque.add(N);
		dist[N] = 0;

		while (!deque.isEmpty()) {
			int cur = deque.pollFirst();
			if(cur == K) break;

			//순간이동 0초
			int next = cur * 2;
			if(next <= MAX && dist[next] == -1) {
				dist[next] = dist[cur];
				deque.addFirst(next);
			}

			//걷기 1초
			next = cur - 1;
			if(next >= 0 && dist[next] == -1) {
				dist[next] = dist[cur] + 1;
				deque.addLast(next);
			}
			next = cur + 1;
			if (next <= MAX && dist[next] == -1) {
				dist[next] = dist[cur] + 1;
				deque.addLast(next);
			}
		}

		System.out.println(dist[K]);
	}
}