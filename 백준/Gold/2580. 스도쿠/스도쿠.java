import java.io.*;
import java.util.*;

public class Main {

	static int[][] board = new int[9][9];
	static List<int[]> zeros = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		for (int i = 0; i < 9; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if (board[i][j] == 0) {
					zeros.add(new int[] {i, j});
				}
			}
		}

		dfs(0);

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				sb.append(board[i][j]).append(" ");
			}
			sb.append("\n");
		}

		System.out.println(sb);
	}

	static boolean dfs(int idx) {
		if(idx == zeros.size()) return true;

		int x = zeros.get(idx)[0];
		int y = zeros.get(idx)[1];

		for(int num = 1; num <= 9; num++) {
			if(isValid(x, y, num)) {
				board[x][y] = num;
				if (dfs(idx + 1)) return true;
				board[x][y] = 0;
			}
		}

		return false;
	}

	static boolean isValid(int x, int y, int num) {

		//가로,세로
		for (int i = 0; i < 9; i++) {
			if(board[x][i] == num) return false;
			if(board[i][y] == num) return false;
		}

		//3x3
		int startX = (x / 3) * 3;
		int startY = (y / 3) * 3;
		for (int i = startX; i < startX + 3; i++) {
			for (int j = startY; j < startY + 3; j++) {
				if(board[i][j] == num) return false;
			}
		}

		return true;
	}
}