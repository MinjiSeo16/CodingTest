import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][2];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr, Comparator.comparingInt(a -> a[0]));

		int maxHeight = 0;
		int leftMost = -1, rightMost = -1;
		for (int i = 0; i < N; i++) {
			if (arr[i][1] > maxHeight) {
				maxHeight = arr[i][1];
				leftMost = arr[i][0];
				rightMost = arr[i][0];
			}
			if (arr[i][1] == maxHeight) {
				rightMost = arr[i][0];
			}
		}

		int result = 0;
		int beforeX = arr[0][0];
		int beforeY = arr[0][1];

		for (int i = 1; i < N && arr[i][0] <= leftMost; i++) {
			if (arr[i][1] > beforeY) {
				result += (arr[i][0] - beforeX) * beforeY;
				beforeX = arr[i][0];
				beforeY = arr[i][1];
			}
		}

		result += (rightMost - leftMost + 1) * maxHeight;
		beforeX = arr[N - 1][0];
		beforeY = arr[N - 1][1];

		for (int i = N - 2; i >= 0 && arr[i][0] >= rightMost; i--) {
			if (arr[i][1] > beforeY) {
				result += (beforeX - arr[i][0]) * beforeY;
				beforeX = arr[i][0];
				beforeY = arr[i][1];
			}
		}
		System.out.println(result);
	}
}