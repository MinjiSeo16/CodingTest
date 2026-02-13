import java.io.*;
import java.util.*;

public class Main {

	static class Building {
		int height;
		int index;

		Building(int height, int index) {
			this.height = height;
			this.index = index;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int[] heights = new int[N + 1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			heights[i] = Integer.parseInt(st.nextToken());
		}

		int[] count = new int[N + 1];
		int[] nearest = new int[N + 1];
		Arrays.fill(nearest, -1);

		Stack<Building> stack = new Stack<>();

		// 왼쪽 -> 오른쪽
		for (int i = 1; i <= N; i++) {
			while (!stack.isEmpty() && stack.peek().height <= heights[i]) {
				stack.pop();
			}

			count[i] += stack.size();

			if (!stack.isEmpty()) {
				nearest[i] = stack.peek().index;
			}

			stack.push(new Building(heights[i], i));
		}

		stack.clear();

		// 오른쪽 -> 왼쪽
		for (int i = N; i >= 1; i--) {
			while (!stack.isEmpty() && stack.peek().height <= heights[i]) {
				stack.pop();
			}

			count[i] += stack.size();

			if (!stack.isEmpty()) {
				int rightIdx = stack.peek().index;

				if (nearest[i] == -1 ||
					Math.abs(i - rightIdx) < Math.abs(i - nearest[i]) ||
					(Math.abs(i - rightIdx) == Math.abs(i - nearest[i]) && rightIdx < nearest[i])) {
					nearest[i] = rightIdx;
				}
			}

			stack.push(new Building(heights[i], i));
		}

		StringBuilder sb = new StringBuilder();

		for (int i = 1; i <= N; i++) {
			if (count[i] == 0) {
				sb.append(0).append("\n");
			} else {
				sb.append(count[i]).append(" ").append(nearest[i]).append("\n");
			}
		}

		System.out.println(sb);
	}
}