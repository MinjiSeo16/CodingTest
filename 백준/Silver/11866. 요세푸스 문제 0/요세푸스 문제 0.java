import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		List<Integer> list = new ArrayList<>();
		for (int i = 1; i <= N; i++) {
			list.add(i);
		}

		StringBuilder sb = new StringBuilder();
		sb.append('<');

		int idx = 0;
		while (!list.isEmpty()) {
			idx = (idx + K - 1) % list.size();
			int removed = list.remove(idx);
			sb.append(removed);
			if (!list.isEmpty()) {
				sb.append(", ");
			}
		}

		sb.append('>');
		System.out.println(sb);
	}
}