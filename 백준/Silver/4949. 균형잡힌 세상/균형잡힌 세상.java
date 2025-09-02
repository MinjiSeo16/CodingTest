import java.io.*;
import java.util.ArrayDeque;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		while (true) {
			String line = br.readLine();
			if(line == null) break;
			if(line.equals(".")) break;

			ArrayDeque<Character> stack = new ArrayDeque<>();
			boolean ok = true;

			for (int i = 0; i < line.length() && ok; i++) {
				char c = line.charAt(i);
				if (c == '(' || c == '[') {
					stack.push(c);
				} else if (c == ')') {
					if (stack.isEmpty() || stack.pop() != '(') {
						ok = false;
					}
				} else if (c == ']') {
					if (stack.isEmpty() || stack.pop() != '[') {
						ok = false;
					}
				}
			}
			sb.append(ok && stack.isEmpty() ? "yes" : "no").append('\n');
		}
		System.out.println(sb);
	}
}