import java.io.*;

public class Main {

	static int N;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		while (T-- > 0) {
			N = Integer.parseInt(br.readLine());
			dfs(1, "1");

			sb.append("\n");
		}

		System.out.println(sb);
	}

	private static void dfs(int idx, String expr) {
		if (idx == N) {
			if (calculate(expr) == 0) {
				sb.append(expr).append("\n");
			}
			return;
		}

		int next = idx + 1;

		dfs(next, expr + " " + next);
		dfs(next, expr + "+" + next);
		dfs(next, expr + "-" + next);
	}

	private static int calculate(String expr) {
		expr = expr.replace(" ", "");
		int sum = 0;
		int num = 0;
		char sign = '+';

		for (int i = 0; i < expr.length(); i++) {
			char c = expr.charAt(i);

			if (Character.isDigit(c)) {
				num = num * 10 + (c - '0');
			} else {
				if (sign == '+') sum += num;
				else sum -= num;

				sign = c;
				num = 0;
			}
		}

		if(sign == '+') sum += num;
		else sum -= num;
		return sum;
	}
}