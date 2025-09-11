import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		ArrayDeque<Integer> q = new ArrayDeque<>();
		for (int i = 1; i <= N; i++) {
			q.offerLast(i);
		}

		StringBuilder sb = new StringBuilder();
		sb.append("<");
		int cnt = 1;

		while (N > 0) {
			if (cnt == K) {
				int num = q.pollFirst();
				sb.append(num);
				if (!q.isEmpty()) {
					sb.append(", ");
				}
				cnt = 1;
				N--;
			}
			else {
				int num = q.pollFirst();
				q.offerLast(num);
				cnt++;
			}
		}

		sb.append(">");
		System.out.println(sb);
	}
}