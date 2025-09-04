import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		while (T-- > 0) {
			int M = Integer.parseInt(br.readLine());
			PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
			PriorityQueue<Integer> minHeap = new PriorityQueue<>();

			StringBuilder sb = new StringBuilder();
			int medianCnt = 0; // 중앙값 개수 카운트
			int numbersRead = 0; // 지금까지 읽은 수 개수

			while (numbersRead < M) {
				StringTokenizer st = new StringTokenizer(br.readLine());

				while (st.hasMoreTokens()) {
					int num = Integer.parseInt(st.nextToken());
					numbersRead++;

					// 1. 힙에 넣기
					if (maxHeap.isEmpty() || num <= maxHeap.peek()) {
						maxHeap.offer(num);
					} else {
						minHeap.offer(num);
					}

					// 2. 균형 맞추기
					if (maxHeap.size() > minHeap.size() + 1) {
						minHeap.offer(maxHeap.poll());
					} else if (minHeap.size() > maxHeap.size()) {
						maxHeap.offer(minHeap.poll());
					}

					// 3. 홀수번째일때 중앙값 기록
					if (numbersRead % 2 == 1) {
						medianCnt++;

						if (medianCnt % 10 == 0) {
							sb.append(maxHeap.peek()).append('\n');
						} else {
							sb.append(maxHeap.peek()).append(' ');
						}
					}
				}
			}
			System.out.println(medianCnt);
			System.out.println(sb);
		}
	}
}