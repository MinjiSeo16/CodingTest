import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		while (T-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());

			int[][] score = new int[k + 1][n + 1];
			int[] submitCnt = new int[n + 1];
			int[] times = new int[n + 1];
			int time = 0;

			while (m-- > 0) {
				st = new StringTokenizer(br.readLine());
				int id = Integer.parseInt(st.nextToken());
				int num = Integer.parseInt(st.nextToken());
				int s = Integer.parseInt(st.nextToken());
				submitCnt[id]++;
				times[id] = time;
				score[num][id] = Math.max(score[num][id], s);
				time++;
			}

			List<int[]> rank = new ArrayList<>();
			for (int i = 1; i < n + 1; i++) {
				int sum = 0;
				for (int j = 1; j < k + 1; j++) {
					sum += score[j][i];
				}
				rank.add(new int[] {i, sum, submitCnt[i], times[i]});
			}

			rank.sort((a, b) -> {
				if (a[1] != b[1])
					return b[1] - a[1];
				if (a[2] != b[2])
					return a[2] - b[2];
				return a[3] - b[3];
			});

			int myRank = 1;
			for (int[] team : rank) {
				if (team[0] == t) {
					System.out.println(myRank);
					break;
				}
				myRank++;
			}
		}
	}
}