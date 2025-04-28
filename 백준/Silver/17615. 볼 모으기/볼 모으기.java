import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String color = br.readLine();

		int leftR = 0;
		for (int i = 0; i < N; i++) {
			if (color.charAt(i) == 'R') {
				leftR++;
			} else {
				break;
			}
		}

		int rightR = 0;
		for (int i = N - 1; i >= 0; i--) {
			if (color.charAt(i) == 'R') {
				rightR++;
			} else {
				break;
			}
		}

		int leftB = 0;
		for (int i = 0; i < N; i++) {
			if (color.charAt(i) == 'B') {
				leftB++;
			} else {
				break;
			}
		}

		int rightB = 0;
		for (int i = N - 1; i >= 0; i--) {
			if (color.charAt(i) == 'B') {
				rightB++;
			} else {
				break;
			}
		}

		int totalR = 0;
		int totalB = 0;
		for (int i = 0; i < N; i++) {
			if (color.charAt(i) == 'R') {
				totalR++;
			}
			else totalB++;
		}

		int answer = Integer.MAX_VALUE;
		answer = Math.min(answer, totalR - leftR);
		answer = Math.min(answer, totalR - rightR);
		answer = Math.min(answer, totalB - leftB);
		answer = Math.min(answer, totalB - rightB);

		System.out.println(answer);
	}
}
