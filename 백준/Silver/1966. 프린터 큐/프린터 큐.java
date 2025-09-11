import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		while (T-- > 0) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
			Queue<int[]> q = new LinkedList<>();

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				int num = Integer.parseInt(st.nextToken());
				pq.add(num);
				q.add(new int[]{num, i});
			}

			int cnt = 0;
			while (!q.isEmpty()) {
				int[] nums = q.poll();
				int n = nums[0];
				int order = nums[1];
				if (n == pq.peek()) {
					if (order == M) {
						cnt++;
						sb.append(cnt).append('\n');
						break;
					} else {
						pq.poll();
						cnt++;
					}
				} else {
					q.offer(nums);
				}
			}
		}
		System.out.println(sb);
	}
}