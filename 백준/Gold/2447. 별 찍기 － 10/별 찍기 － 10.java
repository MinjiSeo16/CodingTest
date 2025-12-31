import java.io.*;

public class Main {
	static char[][] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		arr = new char[N][N];
		draw(0, 0, N);

		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sb.append(arr[i][j] == '\0' ? ' ' : arr[i][j]);
			}
			sb.append('\n');
		}

		System.out.print(sb);
	}

	static void draw(int row, int col, int size) {
		if (size == 1) {
			arr[row][col] = '*';
			return;
		}

		int newSize = size / 3;

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if(i == 1 && j == 1) continue;
				draw(row + i * newSize, col + j * newSize, newSize);
			}
		}
	}
}