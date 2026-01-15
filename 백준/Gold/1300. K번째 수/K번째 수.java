import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int k = sc.nextInt();

		long left = 1;
		long right = (long) N * N;
		long answer = 0;

		while(left <= right) {
			long mid = (left + right) / 2;
			// mid 이하의 수가 곱셈표에 몇 개 있는지
			long count = 0;

			for (int i = 1; i <= N; i++) {
				// i번째 행에서 mid 이하 개수
				// i번째 행 -> i x 1, i x 2,..., i x N
				// i x j <= mid -> j <= mid / i
				count += Math.min(N, mid / i);
			}

			if (count >= k) {
				answer = mid;
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}

		System.out.println(answer);
	}
}