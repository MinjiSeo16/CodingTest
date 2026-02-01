import java.io.*;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int left = 0;
		int right = N - 1;
		long best = Long.MAX_VALUE;
		int answerL = 0, answerR = 0;

		while (left < right) {
			long sum = (long) arr[left] + arr[right];

			//현재 조합이 더 0에 가까우면 갱신
			if(Math.abs(sum) < best) {
				best = Math.abs(sum);
				answerL = arr[left];
				answerR = arr[right];
			}

			if (sum < 0) {
				left++;
			} else {
				right--;
			}
		}

		System.out.println(answerL + " " + answerR);
	}
}