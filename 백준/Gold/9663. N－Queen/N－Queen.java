import java.io.*;

public class Main {
	static int N;
	static int[] arr;
	static int count;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		count = 0;
		dfs(0);
		System.out.println(count);
	}

	static void dfs(int col) {
		if (col == N) {
			count++;
			return;
		}
		for (int row = 0; row < N; row++) {
			arr[col] = row;
			if (possible(col)) {
				dfs(col + 1);
			}
		}
	}

	static boolean possible(int col) {
		for (int i = 0; i < col; i++) {
			if (arr[col] == arr[i])
				return false;
			if (Math.abs(col - i) == Math.abs(arr[col] - arr[i]))
				return false;
		}
		return true;
	}
}