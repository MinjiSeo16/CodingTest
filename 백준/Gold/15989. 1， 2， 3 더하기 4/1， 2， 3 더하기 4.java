import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		int MAX = 10000;
		long[] dp = new long[MAX + 1];
		dp[0] = 1;
		int[] nums = {1, 2, 3};

		for (int num : nums) {
			for (int i = num; i <= MAX; i++) {
				dp[i] += dp[i - num];
			}
		}

		while (T-- > 0) {
			int n = sc.nextInt();
			System.out.println(dp[n]);
		}
	}
}