import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static long M;
	static int[] trees;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		trees = new int[N];

		st = new StringTokenizer(br.readLine());
		int max = 0;
		for (int i = 0; i < N; i++) {
			trees[i] = Integer.parseInt(st.nextToken());
			max = Math.max(max, trees[i]);
		}

		int left = 0;
		int right = max;
		int answer = 0;

		while(left <= right) {
			int mid = (left + right) / 2;
			long cut = getLeftTree(mid);

			if(cut >= M) {
				answer = mid;
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}

		System.out.println(answer);
	}

	private static long getLeftTree(int h) {
		long sum = 0;
		for (int t : trees) {
			if (t > h) {
				sum += (t - h);
			}
		}
		return sum;
	}
}