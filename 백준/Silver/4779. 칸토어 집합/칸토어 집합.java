import java.io.IOException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);

		while (sc.hasNextInt()) {
			int N = sc.nextInt();
			int len = (int) Math.pow(3, N);
			char[] arr = new char[len];
			for (int i = 0; i < len; i++) {
				arr[i] = '-';
			}

			cantor(arr, 0, len);
			System.out.println(new String(arr));
		}
	}

	static void cantor(char[] arr, int start, int len) {
		if(len < 3) return;

		int third = len / 3;

		for (int i = start + third; i < start + 2 * third; i++) {
			arr[i] = ' ';
		}

		cantor(arr, start, third);
		cantor(arr, start + 2 * third, third);
	}
}