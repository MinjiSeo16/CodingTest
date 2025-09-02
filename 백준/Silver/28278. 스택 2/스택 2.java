import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		ArrayDeque<Integer> stack = new ArrayDeque<>();
		StringBuilder sb = new StringBuilder();

		while (N-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int cmd = Integer.parseInt(st.nextToken());

			switch (cmd) {
				case 1:
					int x = Integer.parseInt(st.nextToken());
					stack.push(x);
					break;
				case 2:
					sb.append(stack.isEmpty() ? - 1 : stack.pop()).append('\n');
					break;
				case 3:
					sb.append(stack.size()).append('\n');
					break;
				case 4:
					sb.append(stack.isEmpty() ? 1 : 0).append('\n');
					break;
				case 5:
					sb.append(stack.isEmpty() ? -1 : stack.peek()).append('\n');
					break;
			}
		}
        System.out.print(sb);
	}
}