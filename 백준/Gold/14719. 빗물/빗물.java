import java.io.*;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());

		int[] arr = new int[W];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < W; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int result = 0;

		for (int i = 1; i < W - 1; i++) {
			int leftMax = 0;
			int rightMax = 0;

			for (int l = 0; l < i; l++) {
				leftMax = Math.max(leftMax, arr[l]);
			}

			for(int r = i + 1; r < W; r++) {
				rightMax = Math.max(rightMax, arr[r]);
			}

			int water = Math.min(leftMax, rightMax) - arr[i];
			if(water > 0) result += water;
		}

		System.out.println(result);
	}
}