import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());

		int[][] arr = new int[N][3];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
			arr[i][2] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr, (o1, o2) -> {
			if (o1[0] != o2[0]) {
				return Integer.compare(o1[0], o2[0]);
			} else if (o1[1] != o2[1]) {
				return Integer.compare(o2[1], o1[1]);
			} else {
				return Integer.compare(o2[2], o1[2]);
			}
		});

		int[] dp = new int[D + 1];
		for (int i = 1; i <= D; i++) {
			dp[i] = dp[i - 1] + 1;
			for (int j = 0; j < N; j++) {
				int start = arr[j][0];
				int end = arr[j][1];
				int cost = arr[j][2];

				if (cost < end - start) {
					if (i == end) {
						dp[i] = Math.min(dp[i], dp[start] + cost);
					}
				}
			}
		}
		System.out.println(dp[D]);
	}
}