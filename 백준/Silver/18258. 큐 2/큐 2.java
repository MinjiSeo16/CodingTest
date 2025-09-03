import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder();
		ArrayDeque<Integer> deque = new ArrayDeque<>();

		while (N-- > 0) {
			st = new StringTokenizer(br.readLine());
			String cmd = st.nextToken();

			switch (cmd) {
				case "push":
					int num = Integer.parseInt(st.nextToken());
					deque.addLast(num);
					break;
				case "pop":
					int output = deque.isEmpty() ? -1 : deque.pollFirst();
					sb.append(output).append('\n');
					break;
				case "size":
					int size = deque.size();
					sb.append(size).append('\n');
					break;
				case "empty":
					int output2 = deque.isEmpty() ? 1 : 0;
					sb.append(output2).append('\n');
					break;
				case "front":
					int output3 = deque.isEmpty() ? -1 : deque.peekFirst();
					sb.append(output3).append('\n');
					break;
				case "back":
					int output4 = deque.isEmpty() ? -1 : deque.peekLast();
					sb.append(output4).append('\n');
					break;
			}
		}
		System.out.println(sb);
	}
}