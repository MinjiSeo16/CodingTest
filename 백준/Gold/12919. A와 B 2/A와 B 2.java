import java.io.*;

public class Main {

	static String S;
	static boolean possible = false;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		S = br.readLine();
		String T = br.readLine();

		dfs(T);
		System.out.println(possible ? 1 : 0);
	}

	static void dfs(String cur) {
		if (possible) return;

		// 길이가 같아지면 비교
		if (cur.length() == S.length()) {
			if (cur.equals(S)) {
				possible = true;
			}
			return;
		}

		// 끝이 A인 경우 → A 제거
		if (cur.charAt(cur.length() - 1) == 'A') {
			dfs(cur.substring(0, cur.length() - 1));
		}

		// 앞이 B인 경우 → B 제거 후 reverse
		if (cur.charAt(0) == 'B') {
			String next = new StringBuilder(cur.substring(1)).reverse().toString();
			dfs(next);
		}
	}
}