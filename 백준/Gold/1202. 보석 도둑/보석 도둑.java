import java.io.*;
import java.util.*;

public class Main {
	static class Jewel {
		int m, v;

		Jewel(int m, int v) {
			this.m = m;
			this.v = v;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());  //보석개수
		int K = Integer.parseInt(st.nextToken());  //가방개수

		Jewel[] jewels = new Jewel[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken()); //무게
			int V = Integer.parseInt(st.nextToken()); //가격
			jewels[i] = new Jewel(M, V);
		}

		int[] bags = new int[K];
		for (int i = 0; i < K; i++) {
			bags[i] = Integer.parseInt(br.readLine());
		}

		// 무게 오름차순, 같으면 가격 내림차순
		Arrays.sort(jewels, (a, b) -> a.m == b.m ? b.v - a.v : a.m - b.m);
		Arrays.sort(bags);

		int idx = 0; 
		long result = 0;

		// 가격 최대힙
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		for (int bag : bags) {
			// 가방에 들어갈 수 있는 보석을 모두 힙에 넣음
			while (idx < N && jewels[idx].m <= bag) {
				pq.offer(jewels[idx].v);
				idx++;
			}
			
			// 그 중 가장 비싼 보석만 하나 담기
			if (!pq.isEmpty()) {
				result += pq.poll();
			}
		}

		System.out.println(result);
	}
}