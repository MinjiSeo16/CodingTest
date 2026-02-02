import java.io.*;

public class Main {

	static int[][] wins = {
		{0, 1, 2}, {3, 4, 5}, {6, 7, 8},
		{0, 3, 6}, {1, 4, 7}, {2, 5, 8},
		{0, 4, 8}, {2, 4, 6}
	};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			String s = br.readLine();
			if (s.equals("end"))
				break;

			int x = 0;
			int o = 0;
			for (char c : s.toCharArray()) {
				if (c == 'X')
					x++;
				if (c == 'O')
					o++;
			}

			boolean xWin = win(s, 'X');
			boolean oWin = win(s, 'O');

			boolean valid = true;
			// X O 개수 같거나, X 하나 더 많아야 함 (X가 먼저 두니까)
			if (!(x == o || x == o + 1)) valid = false;
			// X O 동시에 이길 수 없음
			else if (xWin && oWin) valid = false;
			// X 이겼으면 마지막 수는 X여야함 -> X = O + 1
			else if(xWin && x != o + 1) valid = false;
			// O 이겼으면 마지막 수는 O여야함 -> X = O
			else if(oWin && x != o) valid = false;
			// 아무도 이기지 않았으면 판이 꽉 차 있어야 최종 상태
			else if(!xWin && !oWin && x + o != 9) valid = false;

			System.out.println(valid ? "valid" : "invalid");
		}
	}

	private static boolean win(String s, char c) {
		for (int[] w : wins) {
			if (s.charAt(w[0]) == c &&
				s.charAt(w[1]) == c &&
				s.charAt(w[2]) == c) {
				return true;
			}
		}
		return false;
	}
}