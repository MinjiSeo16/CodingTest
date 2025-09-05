import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] dice = {1, 2, 3, 4, 5, 6};

		int[] mov = new int[101]; // 사다리,뱀 이동 번호 (없으면 0)
		for (int i = 0; i < N + M; i++) {
			st = new StringTokenizer(br.readLine());
			mov[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
		}

		int[] dist = new int[101];  // idx까지 도달하기 위한 최소 행동 횟수
		Arrays.fill(dist, -1);
		ArrayDeque<Integer> q = new ArrayDeque<>();
		dist[1] = 0;
		q.add(1);

		while (!q.isEmpty()) {
			int cur = q.poll();
			if(cur == 100) break;

			for (int d : dice) {
				int next = cur + d;
				if (next > 100) continue;
				if (mov[next] != 0) {
					next = mov[next];
				}

				if (dist[next] == -1) {
					dist[next] = dist[cur] + 1;  // 주사위 + 1회
					q.add(next);
				}
			}
		}
		System.out.println(dist[100]);
	}
}