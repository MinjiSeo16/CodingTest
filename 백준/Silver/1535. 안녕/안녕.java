import java.io.*;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] L = new int[N];
		int[] J = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			L[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			J[i] = Integer.parseInt(st.nextToken());
		}

		int[] dp = new int[100];
		for (int i = 0; i < N; i++) {
			int cost = L[i];
			int joy = J[i];
			for (int s = 99; s >= cost; s--) {
				dp[s] = Math.max(dp[s], dp[s - cost] + joy);
			}
		}
		System.out.println(dp[99]);
	}
}