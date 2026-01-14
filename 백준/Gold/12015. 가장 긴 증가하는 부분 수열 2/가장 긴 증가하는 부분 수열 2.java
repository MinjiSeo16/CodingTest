import java.io.*;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] lis = new int[N];
		int size = 0;

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());

			if(size == 0 || lis[size - 1] < num) {
				lis[size++] = num;
			}
			else {
				int left = 0;
				int right = size - 1;

				while(left < right) {
					int mid = (left + right) / 2;

					if(lis[mid] >= num) {
						right = mid;
					} else {
						left = mid + 1;
					}
				}

				lis[left] = num;
			}
		}

		System.out.println(size);
	}
}