import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int max = N > M ? N : M;

		HashSet<String> set = new HashSet<>();
		for (int i = 0; i < N; i++) {
			set.add(br.readLine());
		}

		List<String> list = new ArrayList<>();
		for (int i = 0; i < M; i++) {
			String name = br.readLine();
			if (set.contains(name)) {
				list.add(name);
			}
		}

		Collections.sort(list);
		StringBuilder sb = new StringBuilder();
        sb.append(list.size()).append('\n');
		for (String name : list) {
			sb.append(name).append('\n');
		}
		
		System.out.println(sb);
	}
}