import java.io.*;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int[] arr = new int[N];
		int[] freq = new int[8001];
		long sum = 0;

		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			arr[i] = num;
			sum += num;
			freq[num + 4000]++;
		}

		Arrays.sort(arr);

		// 범위
		int range = arr[N - 1] - arr[0];

		// 산술평균
		int mean = (int) Math.round((double) sum / N);

		// 중앙값
		int median = arr[N / 2];

		// 최빈값
		int maxFreq = 0;
		for (int f : freq) {
			if (f > maxFreq) {
				maxFreq = f;
			}
		}

		int num = 0;
		boolean firstFound = false;
		for (int i = 0; i <= 8000; i++) {
			if (freq[i] == maxFreq && firstFound) {
				num = i - 4000;
				break;
			}
			if (freq[i] == maxFreq) {
				firstFound = true;
				num = i - 4000;
			}
		}

		StringBuilder sb = new StringBuilder();
		sb.append(mean).append('\n');
		sb.append(median).append('\n');
		sb.append(num).append('\n');
		sb.append(range);
		System.out.println(sb);
	}
}