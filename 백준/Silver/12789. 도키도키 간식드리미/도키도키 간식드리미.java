import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		ArrayDeque<Integer> side = new ArrayDeque<>();
		int expected = 1;

		for (int i = 0; i < N; i++) {
			int cur = Integer.parseInt(st.nextToken());

			while (!side.isEmpty() && side.peek() == expected) {
				side.pop();
				expected++;
			}

			if (cur == expected) {
				expected++;
			} else {
				side.push(cur);
			}
		}
		
		while (!side.isEmpty() && side.peek() == expected) {
			side.pop();
			expected++;
		}
		
		System.out.println(expected == N + 1 ? "Nice" : "Sad");
	}
}